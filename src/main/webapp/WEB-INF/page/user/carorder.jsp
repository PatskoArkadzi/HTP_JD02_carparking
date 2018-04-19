<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/begin-html.jsp"%>

<h2 align="center">Заказ автомобиля</h2>
<br>
<br>
<br>
<form class="order-car"
	action="MainServlet?car_id=${ordered_car.id}&user_id=1&action=car_order"
	method=POST>
	<div class="row">
		<div class=col-md-6>
			<h4>Характеристика автомобиля:</h4>
			<p>Марка автомобиля: ${ordered_car.brand}</p>
			<p>Модель автомобиля: ${ordered_car.model}</p>
			<br> <br>
			<h4>Контактные данные заказчика:</h4>
			<p>Имя: ${user.name}</p>
			<p>тел.: ${user.phoneNumber}</p>
			<p>email: ${user.email}</p>
		</div>
		<div class=col-md-5>
			<h4>Выберите период аренды:</h4>
			<p>начало:</p>
			<p>
				<input type="date" name="start" min="2012-04-18">
			</p>
			<p>конец:</p>
			<p>
				<input type="date" name="end" >
			</p>
			<br>
			<button type="submit" class="btn btn-success btn-lg">заказать</button>
			<br>
			<c:out value="${msg_error}" />
			<c:out value="${msg_order_car_success}" />
		</div>
	</div>
</form>

<%@ include file="include/end-html.jsp"%>

