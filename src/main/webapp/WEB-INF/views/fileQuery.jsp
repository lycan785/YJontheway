<%@ page language="java" contentType="text/html; charset=utf-8"
	    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>

<title>Reservation Query</title>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
	<META content="MSHTML 6.00.2800.1543" name=GENERATOR>
	<style type="text/css">
	<!--
	body{margin:0;
	font-family: Arial, Helvetica, sans-serif;
		font-size: 0.8em;
	}
	td,th,div{
			font-size: 0.8em;
	}
	a{
		color: #0066FF;
	}
	a:hover{
		color: #666;
		text-decoration: none;
	}
	
	h1{
	margin:0px;
	height:70px;
	line-height:70px;
	background: #6699CC;
	color: #fff;
	border-bottom:solid 1px #006699;
	}
	
	.search{
	background:#ddeeff;
	padding-top:5px;
	padding-bottom:5px;
	border-bottom:solid 1px #9ABBCB;
	}
	form{margin:0;
	}
	.result{
	width:70%;
		clear:both;
	margin-bottom:20px;
	margin-top:20px;}
	.result h3{
			margin:0px;
			line-height: 25px;
			font-size: 1.3em;
	}
	.linked {
		padding-top: 5px;
		padding-bottom: 5px;
	}
	.linked a{
	
	margin-right: 10px;
	border:solid 1px #CCCCCC;
	padding:3px 10px 3px 10px;
	text-decoration: none;
	}
	.linked a:hover{
	
	margin-right: 10px;
	border:solid 1px #0066FF;
		background: #0066FF;
		color: #fff;
	
	}
	hr{
	
		border: dashed 1px #ddd;
			display: block;
			background:#fff;
			height: 1px;
	}
	.footer{
		font-size:0.8em;
		border-top:solid 1px #ddd;
		padding-top:10px;
	}
	.footer a{color:#666;
	text-decoration: none;}
	.footer a:hover{
		text-decoration: underline;
	}
	-->
	</style>
	</HEAD>

</head>
<body>
<center>

<h1>LUCENE</h1>

<form method="post">
File Name
<input type="text" name="fileName" value="${fileName}" size="40"/>
<input type="submit" value="Query" size="40"/>
</form>
<table border="1">
	<tr>
		<th colspan="3">File Name</th>
		<th colspan="3">File Path</th>
		
	</tr>	
	
<c:forEach items="${files}" var="file">
	<tr>
		<td colspan="3"><h3>${file.fileName}</h3></td>
		
		
		<td colspan="3"><h3>${file.filePath}</h3></td>

	</tr>


</c:forEach>	

</table>

</center>
</body>

</html>