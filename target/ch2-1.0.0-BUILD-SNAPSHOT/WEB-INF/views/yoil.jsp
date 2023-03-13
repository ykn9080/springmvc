<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<h2>Year=<%=request.getParameter("year")%></h2>
<P>  The time on the server is ${myDate.year}년 ${myDate.month}월 ${myDate.date}일 요일 }.한글깨짐방지</P>
</body>
</html>
