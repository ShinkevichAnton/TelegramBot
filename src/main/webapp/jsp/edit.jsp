<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Обновление</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="/css/style.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<c:if test="${city!=null}">
			<form:form modelAttribute="city" action="/edit" method="post">
				<form:input path="id" type="hidden" value="${city.id}" name="id" />
				<div class="form-group">
					<label>Название города:</label>
					<form:input required="required" class="form-control" path="name"
						type="text" placeholder="Берлин" name="${city.name}" />
				</div>
				<div class="form-group">
					<label>Информация:</label>
					<form:input required="required" class="form-control"
						path="information" type="text" placeholder="Зайдите в Рейстаг"
						name="${city.information}" />
				</div>
				<input class="btn btn-success" type="submit" value="Обновить" />
			</form:form>
		</c:if>
	</div>

</body>
</html>