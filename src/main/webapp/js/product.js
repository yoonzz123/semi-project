$(function(){

	// 카트 기능 구현 ---------------------------------------------------------
	
	$("#btnCart").on("click",function(){
		var cQTY = $("#odQTY").val();
		var pNo = $("#pNo").attr("value");
		var mId = $("#mId").attr("value");
		
		
		console.log(cQTY);
		// 비회원 유효성 검사
		if(mId == "" || mId == null){
			var result = confirm("회원전용 서비스 입니다. \n로그인 창으로 이동하시겠습니까?");
			if(result){
					window.location.href="loginForm.mvc";
					return false;
				}
		}
		
		$.ajax({
			url: "cart.ajax",
			type: "post",
			data: "cQTY=" + cQTY + "&pNo=" + pNo,
			//data: {"cQTY" : cQTY, "pNo" : pNo},
			success: function(){
				// 장바구니 페이지 이동 여부
				var result = confirm('상품이 카트에 저장되었습니다.\n장바구니 페이지로 이동하시겠습니까?'); 
				if(!result){
					return false;
				} else {
					window.location.href="cart.mvc";
				}
			},
			error: function(xhr, status, error) {
				alert("error : " + xhr.statusText + ", " + status + ", " + error);
			}
		});
	});
	
	// 수량 버튼 컨트롤
	$("input[type=number").on("change keyup paste", function() {
		cQTY = $(this).val();
		$(this).attr("value", cQTY);
	});
	
	// 결제버튼 
	$("#btnOrder").on("click",function(){
		var cQTY = $("#odQTY").val();
		var mId = $("#mId").attr("value");
		
		if(mId == "" || mId == null){
			
			var result = confirm("회원전용 서비스 입니다. \n로그인 창으로 이동하시겠습니까?");
			if(result == true){
					window.location.href="loginForm.mvc";
					return false;
				}
			return false;
		}
		
		$("#nowBuyForm").submit()
		
		// 비회원 유효성 검사
		
	});
	
}); // end $(document).ready();