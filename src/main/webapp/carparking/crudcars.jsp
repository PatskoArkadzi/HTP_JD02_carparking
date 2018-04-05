<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>carparking</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class=col-md-1>id</div>
			<div class=col-md-1>brand</div>
			<div class=col-md-2>model</div>
		</div>
	</div>

	<div class="container">
		<c:forEach items="${cars}" var="car">
			<form class="update-catalog-${car.id}"
				action="MainServlet?action=CRUD" method=POST>
				<div class="row">
					<div class=col-md-1>
						<input id="id" class="form-control input-md" name="id"
							value="${car.id}" />
					</div>
					<div class=col-md-1>
						<input id="brand" class="form-control input-md" name="brand"
							value="${car.brand}" />
					</div>
					<div class=col-md-3>
						<input id="model" class="form-control input-md" name="model"
							value="${car.model}" />
					</div>

					<button id="Update" value="Update" name="Update"
						class="btn btn-success">Обновить</button>

					<button id="Delete" value="Delete" name="Delete"
						class="btn btn-danger">Удалить</button>
				</div>
			</form>
			<br>
		</c:forEach>
		<br> <br>

		<p>
			<button class="btn btn-success btn-lg" type="button"
				data-toggle="collapse" data-target="#collapseExample"
				aria-expanded="false" aria-controls="collapseExample">
				Create</button>
		</p>
		<div class="collapse" id="collapseExample">
			<div class="card card-body">
				<div class="container">
					<div class="row">
						<div class=col-md-1>brand</div>
						<div class=col-md-2>model</div>
					</div>
				</div>

				<form class="create-catalog" action="MainServlet?action=CRUD"
					method=POST>
					<div class="row">
						<div class=col-md-1 hidden=true>
							<input id="id" class="form-control input-md" name="id" value="0" />
						</div>
						<div class=col-md-1>
							<input id="brand" class="form-control input-md" name="brand" />
						</div>
						<div class=col-md-3>
							<input id="model" class="form-control input-md" name="model" />
						</div>
						<button id="Create" value="Create" name="Create"
							class="btn btn-success">ok</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="container">
		<p>Введите id для поиска</p>
		<form class="update-catalog-${car.id}"
			action="MainServlet?action=CRUD" method=POST>
			<div class="row">
				<div class=col-md-2>
					<input id="id" class="form-control input-md" name="id" />
				</div>
				<button id="Search" value="Search" name="Search"
					class="btn btn-success">search</button>
			</div>
			<p>Результат поиска:</p>
			<p>${carSearch}</p>
		</form>
	</div>
	


</body>
</html>