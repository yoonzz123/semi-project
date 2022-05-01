$(function(){
	
	$("#btnQnAWrite").click(function(){
		var qTitle = $("#qTitle").val();
		var qContent = $("#qContent").val();
	
		if(qTitle.length == 0){
			alert("제목을 입력해주세요.");
			$("#qTitle").focus();
			return false;
		} else if(qContent.length == 0) {
			alert("문의 내용을 입력해주세요.");
			$("#qContent").focus();
			return false;
		}
		var result = confirm('QnA를 등록하시겠습니까?'); 
		if(!result){
			return false;
		}
	});
	
	$("#btnAnswer1").click(function(){
		var answerContent = $(".answerContent").val();
		var qNo = $("#btnqNo").attr("data-no");

		if(answerContent.length == 0 || answerContent == ""){
			alert('답변 내용이 없습니다.');
			return false;
		}
		
		var result = confirm('답변을 등록하시겠습니까?');
		if(!result){
			return false;
		}
		
		$.ajax({
			url: "qna_reply.ajax",
			type: "post",
			data: {qac: answerContent, qNo: qNo},
			dataType: "text",
			success: function(){
				alert("등록이 완료되었습니다.");
				$("#replyTable").empty();
				var result = 
							"	<tr id='answerTr1'>" +
							"		<th>운영자 답변</th>" +
							"		<td class='answerContent'>&emsp;" + answerContent + "</td> " +
							"	</tr>" +
							"	<tr>" +
							"		<td id='btn'>" +
							"			<input type='button' name='btnAnswer2' id='btnAnswer2' value='수정하기' />" +
							"		</td>" +
							"	</tr>";
				$("#replyTable").append(result);
				
			},
			error: function(xhr, status, error) {
				alert("error : " + xhr.statusText + ", " + status + ", " + error);
			}
			
		});
		
	}) // end $("#btnAnswer").click
	
	$("#btnAnswer2").click(function(){
		var answerContent = $(".answerContent").text();
		$(".answerContent").remove();
		$("#btn >").remove();
		console.log('1');
		var result = 
					"<textarea class='answerContent' name='answerContent' rows='5'>"+	
							answerContent +	
					"</textarea>";
		$("#answerTr1").append(result);		
		
		var btnResult = "<input type='button' name='btnAnswer3' id='btnAnswer3' value='수정 완료' />";
		$("#btn").append(btnResult);
		
		$("#btnAnswer3").click(function(){

		var answerContent = $(".answerContent").val();
		var qNo = $("#btnqNo").attr("data-no");
		
		var result = confirm('답변을 수정하시겠습니까?'); 
		if(!result){
			return false;
		}
		
		
		$.ajax({
			url: "qna_replyUpdate.ajax",
			type: "post",
			data: {qrContent: answerContent, qNo: qNo},
			success:function(){
				alert("답변 수정이 완료되었습니다.");
				window.location.reload();
			},
			error: function(xhr, status, error) {
				alert("error : " + xhr.statusText + ", " + status + ", " + error);
			}
		});
	});
	
	
	
	});
	const handElem = document.querySelector('.hand');
	
	function moveHandler(e){
		handElem.style.transform = `translate(${e.clientX}px, ${e.clientY}px)`;
	}
	window.addEventListener('mousemove', moveHandler);
	window.addEventListener('mousedown', () =>{
		document.body.classList.add('mousedown');
	});
	window.addEventListener('mouseup', () =>{
		document.body.classList.remove('mousedown');
	});
});