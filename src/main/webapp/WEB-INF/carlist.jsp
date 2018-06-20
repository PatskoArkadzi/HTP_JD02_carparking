<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>user main page</title>
</head>
<body>
	<div class="container">
		<form onSubmit="addCar(); return false;">
			<div class="row">
				<input id="id" hidden="true" value="0" />
				<input id="brand" placeholder="brand"	value="Lada" />
				<input id="model" placeholder="model" value="Granta" />
				<input type="submit" value="add car" />
			</div>
		</form>		
		<hr>
		<div class="container" align="center">		
			<h3>wheather</h3>
			<img src="https://www.metaweather.com/static/img/weather/ico/${jsonWheather.get('weather_state_abbr')}.ico">
			<div>min:<fmt:formatNumber value="${jsonWheather.get('min_temp')}" maxFractionDigits="0" /> &deg;C</div>
			<div>max:<fmt:formatNumber value="${jsonWheather.get('max_temp')}" maxFractionDigits="0" /> &deg;C</div>
			
		</div>
		<hr>
		<div class="container">		
			<c:forEach items="${carlist}" var="car">
				<form onSubmit="deleteCar(${car.id},'${car.brand}','${car.model}')">
					<div class="row">
						<input value="${car.id}" />
						<input value="${car.brand}"/>
						<input value="${car.model}"/>
						<input type="submit" value="delete car" />
					</div>
				</form>	
				<hr>							
			</c:forEach>
		</div>
	</div>
	
	<script type="text/javascript">
			function addCar() {
				$.ajax({
					type : 'POST',
					url : '/carparking/cars',
					data : JSON.stringify({
						"id" : $(id).val(),
						"brand" : $(brand).val(),
						"model" : $(model).val()
					}),
					contentType : "application/json; charset=utf-8",
					dataType : "json"
				});
				return false;
			}
			function deleteCar(id,brand,model) {
				console.log(id);
				console.log(brand);
				console.log(model); 
				 $.ajax({
					type : 'DELETE',
					url : '/carparking/cars',
					data : JSON.stringify({
						"id" : id,
						"brand" : brand,
						"model" : model
					}),
					contentType : "application/json; charset=utf-8",
					dataType : "json"
				}); 
				return false;
			}
		</script>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</body>
</html>

