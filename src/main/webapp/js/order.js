$(function(){
	// 삭제 버튼
	$(".btnoStatus").click(function(){
		$("#Status").attr('value', '1');
		oNo = $(this).attr("data-oNo")
		
		value = $("#Status").attr('value');

		$.ajax({
			url: "updateStatus.ajax",
			type: "post",
			data: {oNo:oNo, value:value},
			success: function(data){
				data
			},
			error: function(xhr, status, error) {
				alert("error : " + xhr.statusText + ", " + status + ", " + error);
			}
			
			
		})
		
		
	})
	
})