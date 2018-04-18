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

<!-- 
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#orderModal">Заказать</button>

				Modal
				<div class="modal fade" id="orderModal" tabindex="-1" role="dialog"
					aria-labelledby="orderModalLabel" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Выберите
									период использования</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<p>Выберите дату начада:</p>
								<p>
									<input type="date" name="start">
								</p>
								<p>Выберите дату начада:</p>
								<p>
									<input type="date" name="end">
								</p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<button type="submit" class="btn btn-primary">Save
									changes</button>
							</div>
						</div>
					</div>
				</div> -->

<%@ include file="include/end-html.jsp"%>

