<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/begin-html.jsp"%>

<div class="container">
	<div class="row">
		<div class=col-md-1 hidden=true>id</div>
		<div class=col-md-3>brand</div>
		<div class=col-md-2>model</div>
	</div>
</div>

<div class="container">
	<c:forEach items="${carlist}" var="car">
		<form class="update-catalog-${car.id}"
			action="MainServlet?action=car_update" method=POST>
			<div class="row">
				<div class=col-md-1 hidden=true>
					<input id="car_id" class="form-control input-md" name="car_id"
						value="${car.id}" />
				</div>
				<div class=col-md-3>
					<input id="car_brand" class="form-control input-md" name="car_brand"
						value="${car.brand}" />
				</div>
				<div class=col-md-2>
					<input id="car_model" class="form-control input-md" name="car_model"
						value="${car.model}" />
				</div>

				<button id="Update" value="Update" name="Update"
					class="btn btn-success">Обновить</button>
			</div>
		</form>
		<br>
	</c:forEach>
</div>

<%@ include file="include/end-html.jsp"%>

