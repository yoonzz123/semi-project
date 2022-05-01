$(function(){
	
	
	$("#pDelete").on("click", function(){
		let input = confirm("정말 삭제 하시겠습니까?")
		
		if(input) {		
		$("#checkForm").attr("action", "deleteProcess.mvc");
		$("#checkForm").submit();	
		}else{
			alert('취소합니다.');
		}

	});
	
	
	$("#joinForm").submit(function(){
		
		var mid = $("#mid").val();
		var mpw = $("#mpw").val();
		var mpw2 = $("#mpw2").val();
		var mname = $("#mname").val();
		var mpost = $("#mpost").val();
		var madd = $("#madd").val();
		var madd2 = $("#madd2").val();
		var mphone2 = $("#mphone2").val();
		var mphone3 = $("#mphone3").val();
		var memailId = $("#memailId").val();
		var memailDomain = $("#memailDomain").val();
		
		if($("#isIdCheck").attr('value') == 'false'){
			alert("아이디 중복검사를 확인해주세요.");
			return false;
		}
		if(mid.length == 0){
			alert("아이디가 입력되지 않았습니다.\n아이디를 입력해주세요.");
			$(mid).focus();
			return false;
		}
		if(mpw.length == 0){
			alert("비밀번호가 입력되지 않았습니다.\n비밀번호를 입력해주세요.");
			$(mpw).focus();
			return false;
		}
		if(mpw != mpw2){
			alert("입력하신 비밀번호가 일치하지 않습니다.\n비밀번호를 확인해주세요.");
			$(mpw).focus();
			return false;
		}
		if(mname.length == 0){
			alert("이름이 입력되지 않았습니다.\n이름을 입력해주세요.");
			return false;
		}
		if(mpost.length == 0 || madd.length == 0 || madd2.length == 0){
			alert("주소가 입력되지 않았습니다.\n주소를 입력해주세요.");
			return false;
		}
		if(mphone2.length < 3 || mphone3.length < 3){
			alert("올바른 휴대폰 번호가 아닙니다.\n휴대폰 번호를 다시 입력해주세요.");
			return false;
		}
		if(memailId.length == 0 || memailDomain.length == 0){
			alert("이메일이가 입력되지 않았습니다.\n이메일을 입력해주세요.");
			return false;
		}
		
	});
	
	$("#idSerch").on('click', function(){
		url = "nameCheck.mvc";
		
		window.open(url, "nameCheck", "toolbar=no, location=no, " 
				+  "status=no, memubar=no, width=400, height=200");
		
	});
	$("#namecheck").on("click", function(){
		let name = $("#name").val();
		
		url = "nameProcess.mvc?name=" +name;
		window.open(url, "nameCheck", "toolbar=no, location=no, " 
				+  "status=no, memubar=no, width=400, height=200");
		console.log(name);
	});
	
	$("#passSerch").on("click", function(){
		url = "passCheck.mvc";
		
		window.open(url, "nameCheck", "toolbar=no, location=no, " 
				+  "status=no, memubar=no, width=400, height=200");
	});
	$("#passCheck").on("click", function(){
		let name = $("#name").val();
		let id = $("#id").val()
		
		url = `passProcess.mvc?name=${name}?id${id}`
		
		
		window.open(url, "nameCheck", "toolbar=no, location=no, " 
				+  "status=no, memubar=no, width=400, height=200");
		})
	
	$("#btnIdCheck").click(function(){
		var id = $("#mid").val();
		
		if(id.length == 0){
			alert("id를 입력해주세요");
		}
		$.ajax({
			url: "isIdCheck.ajax",
			type: "post",
			data: {mid: id},
			dataType:"json",
			success: function(data){
				if(data == true){
					$("#IdCheck").html("중복된 아이디입니다.").css('color', '#cc6600');
					$("#isIdCheck").attr('value', 'false');
				} else if(data == false){
					$("#IdCheck").html("사용 가능한 아이디입니다.").css('color', '#66ff00');
					$("#isIdCheck").attr('value', 'true');
				}
			},
			error: function(xhr, status, error) {
				alert("error : " + xhr.statusText + ", " + status + ", " + error);
			}
		});
	}).hover(function() {
		$(this).css({cursor: "pointer"});
	});
	
	// 우편번호 검색
	$("#btnZipcode").click(findZipcode).hover(function() {
		$(this).css({cursor: "pointer"});
	});
	
	
		// 이메일 도메인
	$("#selectDomain").on("change", function() {
		var str = $(this).val();
		
		if(str == "직접입력") {	
			$("#emailDomain").val("");
			$("#emailDomain").prop("readonly", false);
		} else if(str == "네이버"){	
			$("#emailDomain").val("naver.com");			
			$("#emailDomain").prop("readonly", true);
			
		} else if(str == "한메일") {		
			$("#emailDomain").val("hanmail.net");
			$("#emailDomain").prop("readonly", true);

		} else if(str == "구글") {		
			$("#emailDomain").val("gmail.com");
			$("#emailDomain").prop("readonly", true);
		}
	});
	
	//수정하기전에 검사기능
	$("#updateForm").submit(function(){
		if($("#mpw").val() == "") {
			 alert("비밀번호는 공백일수없습니다.")
			return false
		}
		
		alert("회원정보를 수정하겠습니다.")
		
	})
	
	$("#memberDeleteBtn").click(function(){
		if (!confirm("확인(예) 또는 취소(아니오)를 선택해주세요.")) {
            return false;
        } else {
            return true;
        }
	})
	
	
	
	
});

function findZipcode() {
	new daum.Postcode({
        oncomplete: function(data) {
         
            var addr = ''; 
            var extraAddr = ''; 

            if (data.userSelectedType === 'R') { 
                addr = data.roadAddress;

            } else { 
				addr = data.roadAddress; 

            }

            if(data.userSelectedType === 'R'){

                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? 
											', ' + data.buildingName : data.buildingName);
                }
                
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
				
                // 조합된 참고 항목을 상세주소에 추가한다.
                addr += extraAddr;
            }

			// 우편번호와 주소 정보를 해당 입력상자에 출력한다.
			$("#mpost").val(data.zonecode);
			$("#madd").val(addr);
			
			// 커서를 상세주소 입력상자로 이동한다.
			$("#madd2").focus();
       	}
	}).open();
}


