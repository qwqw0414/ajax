<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax::index</title>
</head>
<body>
	<h1>Ajax</h1>
	<p>Asynchronous Javascript and XML</p>
	
	<h2>Javascript</h2>
	<ul>
		<li><a href="<%=request.getContextPath()%>/js">javascript-ajax</a></li>
	</ul>
	
	<h2>jQuery</h2>
	<ul>
		<li><a href="<%=request.getContextPath()%>/jquery/text/text.jsp">javascript-ajax: text</a></li>
		<li><a href="<%=request.getContextPath()%>/jquery/html/html.jsp">javascript-ajax: html</a></li>
		<li><a href="<%=request.getContextPath()%>/jquery/csv/csv.jsp">javascript-ajax: csv</a></li>
		<li><a href="<%=request.getContextPath()%>/jquery/csv/autoComplete.jsp">javascript-ajax: autoComplete</a></li>
		<li><a href="<%=request.getContextPath()%>/jquery/xml/xml.jsp">javascript-ajax: xml</a></li>
		<li><a href="<%=request.getContextPath()%>/jquery/json/json.jsp">javascript-json: xml</a></li>
	</ul>
	
	<h2>@실습문제:스마트가전센터</h2>
	<ul>
		<li><a href="<%=request.getContextPath()%>/smart/smart.jsp">@실습문제</a></li>
	</ul>
</body>
</html>