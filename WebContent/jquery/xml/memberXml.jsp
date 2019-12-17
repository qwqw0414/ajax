<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="member.model.vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    List<Member> list = (List<Member>)request.getAttribute("list");
%>
<members>
<%
	if(list!=null && !list.isEmpty()){
		for(Member m : list){	
%>
    <member>
        <name><%=m.getName()%></name>
        <phone><%=m.getPhone()%></phone>
        <profile><%=m.getProfile()%></profile>
    </member>
<%
		}
	}
%>
</members>