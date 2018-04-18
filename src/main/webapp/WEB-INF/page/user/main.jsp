<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/begin-html.jsp"%>


<div class="container">
	<div class="row">
		<div class=col-md-1>id</div>
		<div class=col-md-3>brand</div>
		<div class=col-md-2>model</div>
	</div>
</div>
<hr style="border: 1px solid black" />
<div class="container">
	<c:forEach items="${carlist}" var="car">
		<form class="order-car"
			action="MainServlet?car_id=${car.id}&user_id=1&action=car_order"
			method=POST>
			<div class="row">
				<div class=col-md-1>${car.id}</div>
				<div class=col-md-3>${car.brand}</div>
				<div class=col-md-2>${car.model}</div>

			<button id="Order" value="Order" name="Order"
					class="btn btn-danger">Заказать</button>
			</div>
		</form>
		<br>
	</c:forEach>
</div>


<%@ include file="include/end-html.jsp"%>
