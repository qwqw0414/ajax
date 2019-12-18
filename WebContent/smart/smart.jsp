<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="<%=request.getContextPath()%>/jquery/jquery-3.4.1.js"></script>
<title>스마트 가전센터</title>
<style>
div.container{
	float: left;
	width: 29%;
	height:300px;
    margin: 10px;
    padding: 10px;
	background:lightgrey;
	text-align:center;
}
table {
	border:1px solid;
	margin:auto;
}
td,th {
	border:1px solid;
}
span#time{
	text-decoration:underline;
	margin: 15px;
    display: block;
}
</style>
</head>
<body>
<h1>스마트 가전 센터 주문페이지</h1>
<p>
	1. ajax를 이용해서 제품주문을 처리하고, 실시간 판매현황(최근5건)에 출력하세요. <br />
	2. 10초마다 판매랭킹리스트(상위5개제품과 누적판매량)를 갱신하는 ajax함수를 작성하세요. <br />
	(bonus) 현재시각을 표시하세요.
</p>
<div id="order-container" class="container">
	<h2>주문</h2>
	<table>
		<tr>
			<th>제품명</th>
			<td>
				<select name="pname" id="pname" required>
					<option value="iPhoneX">iPhoneX</option>
					<option value="iPhone7">iPhone7</option>
					<option value="iPhone7Plus">iPhone7Plus</option>
					<option value="GalaxyNote8">GalaxyNote8</option>
					<option value="Galaxy8">Galaxy8</option>
					<option value="샤오미맥스2">샤오미맥스2</option>
					<option value="LGV30">LGV30</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>주문량</th>
			<td><input type="number" id="amount" name="amount" min="1" value="1" required></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" id="btn-order" value="주문" />
			</td>
		</tr>
	</table>
</div>

<script>
$("#btn-order").click(()=>{
	var phone = {
		pname : $("#pname").val(),
		amount : $("#amount").val(),
	}
	var $orderList = $("#order-list");
	var jsonPhone = JSON.stringify(phone);

	$.ajax({
		url:"<%=request.getContextPath()%>/smart/insertPhone",
		data: {jsonPhone:jsonPhone},
		type: "post",
		success: data =>{
			let html = "<table border='1'><tr><th>제품명</th><th>수량</th><th>제품일자</th></tr>";

			$(data).each((idx,phone)=>{
				html += "<tr><td>"+phone.pname+"</td>";
				html += "<td>"+phone.amount+"</td>";
				html += "<td>"+phone.pdate+"</td></tr>";
			});
				html += "</table>";

			$orderList.html(html);
		},
		error : (jqxhr, textStatus, errorThrown)=>{
			console.log(jqxhr, textStatus, errorThrown);
		},
		complete : function(data){
		}

	});
});
</script>

<div class="container">
	<h2>주문리스트</h2>
	<div id="order-list"></div>
</div>
<div class="container">
	<h2>인기순위</h2>
	<span id="time"></span>
	<div id="rank-list"></div>
</div>

<script>
$(()=>{
	setInterval(() => {
	var $rankList = $("#rank-list");
	$.ajax({
		url:"<%=request.getContextPath()%>/smart/selectRank",
		type: "post",
		success: data =>{
			let html = "<table border='1'><tr><th>순위</th><th>제품명</th><th>판매량</th></tr>";
			var cnt = 0;
			$(data).each((idx,phone)=>{
				html += "<tr><td>"+ ++cnt + "</td>"
				html += "<td>"+phone.pname+"</td>";
				html += "<td>"+phone.amount+"</td>";
			});
				html += "</table>";

			$rankList.html(html);
		},
		error : (jqxhr, textStatus, errorThrown)=>{
			console.log(jqxhr, textStatus, errorThrown);
		},
		complete : function(data){
		}

	});
	}, 3000);

});
</script>
</body>
</html>