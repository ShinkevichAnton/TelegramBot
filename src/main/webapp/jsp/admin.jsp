<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Админ</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="/css/style.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="/">TravelCompany</a>
		</div>
	</div>
	</nav>
	<div class="container">
		<table class="table table-striped">
			<thead>
				
				<th>Город</th>
				<th>Информация</th>
				<th></th>
				<th></th>
				<th></th>
			</thead>
			<tbody>


				<c:forEach var="city" items="${city}">
					<tr>
	
						<td>${city.name}</td>
						<td>${city.information}</td>
						


						
						<td><button type="button" class="btn btn-warning">
								<a href="/${city.id}/update">Обновить</a>
							</button></td>
						<td><button type="button" class="btn btn-danger">
								<a href="/${city.id}/delete">Удалить</a>
							</button></td>

					</tr>
				</c:forEach>

			</tbody>
		</table>
		<button type="button" class="btn btn-success">
			<a href="/add">Добавить</a>
		</button>


		<script
			src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>