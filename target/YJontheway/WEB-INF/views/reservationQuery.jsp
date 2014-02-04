<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Reservation Query</title>
</head>
<body>
<form method="post">
File Name
<input type="text" name="fileName" value="${fileName}"/>
<input type="submit" value="Query"/>
</form>
<table border="1">
	<tr>
		<th>File Name</th>
		<th>File Path</th>
		
	</tr>	
	
<c:forEach items="${reservations}" var="reservation">
	<tr>
		<td>${reservation.fileName}</td>
		
		
		<td>${reservation.filePath}</td>

	</tr>


</c:forEach>	

</table>


</body>
</html>