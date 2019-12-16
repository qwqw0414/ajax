<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax::jquery::autoComplete</title>
<script src="<%=request.getContextPath()%>/jquery/jquery-3.4.1.js"></script>
<script>
$(function(){
	$("#srchName").on('keyup', function(){
		var srchNameVal = $(this).val().trim();
		
		//공백 입력시 ajax요청 보내지 않음.
		if(srchNameVal.length == 0) return;
		
		$.ajax({
			url: "<%=request.getContextPath()%>/jquery/autoComplete",
			type: "post",
			//data: "srchName="+srchNameVal,
			data: {srchName: srchNameVal},//객체로 전달해도 jquery가 직렬화처리
			success: function(data){
				console.log(data);
			},
			error: function(jqxhr, textStatus, errorThrown){
				console.log("ajax처리실패!", jqxhr, textStatus, errorThrown);
			}
		});
		
	});
});
</script>
</head>
<body>
	<h1>ajax::jquery::autoComplete</h1>
	<h2>친구 검색</h2>
	<div class="wrapper">
		<input type="text" id="srchName" />
	</div>






</body>
</html>