<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>login page</title>
</head>
<body>
	<c:url var="loginURL" value="/login">
	</c:url>

	<form action="${loginURL}" method="post">

		<input type="text" id="username" name="user" />
		<input type="password" id="password" name="password" />
			<input type="submit" value="log in" />
	</form>
</body>
</html>
