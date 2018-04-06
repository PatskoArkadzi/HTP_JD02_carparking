<!--
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>start page</title>
</head>
<body>
	<p>Hello user</p>
	<p>Cars: ${message}</p>
	<p>
		<a href="MainServlet?action=CRUD">CarsCRUD</a>
	</p>
<jsp:forward page ="/MainServlet?action=view_car_list"/>
</body>
</html>
-->

<jsp:forward page ="/MainServlet">
	<jsp:param value="view_car_list" name="action" />
</jsp:forward>