<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/begin-html.jsp"%>


<div class="container">
	<p>Введите id для поиска</p>
	<form class="read-car" action="MainServlet?action=car_read" method=POST>
		<div class="row">
			<div class=col-md-2>
				<input id="id" class="form-control input-md" name="id" />
			</div>
			<button id="Search" value="Search" name="Search"
				class="btn btn-success">search</button>
		</div>
			<p>Результат поиска:</p>
			<p>${found_car}</p>
	</form>
</div>

<%@ include file="include/end-html.jsp"%>