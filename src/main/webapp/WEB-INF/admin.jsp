<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>login page</title>
</head>
<body>
<c:out value="hello admin" />

<a href='<c:url value="/logout" />' >log out!</a>
</body>
</html>
