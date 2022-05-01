$(function(){
	
	//리뷰폼 열기
	$(".r-toggle-btn").click(function(){
		$(this).next().toggle(function(){
	        $("this").addClass('show'),
	        $("this").removeClass('show')
		})
	})
	
	//리뷰폼 검사기능
	$(".reviewForm").submit(function(e) {
		if(!this.rTitle.value) {
			e.preventDefault()
			alert("제목을 입력해주세요")
		}
		if(!this.rContent.value) {
			e.preventDefault()
			alert("내용을 입력해주세요")
		}
	})
	
	//바로구매폼 검사기능
	$("#odQTY").change(function() {
		if(this.value < 1) 
			this.value = 1		
	})
	
})