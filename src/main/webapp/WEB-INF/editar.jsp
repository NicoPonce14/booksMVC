<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TITULO AQUi</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<h1>Editar un Libro</h1>
	<form:form action="/books/edit/${unlibro.id }" method="post" modelAttribute="libro"
		class="container">
		<input type="hidden" name="_method" value="put">
		<div class="row mb-3">
			<form:errors class="text-danger" path="title"></form:errors>
			<form:errors class="text-danger" path="language"></form:errors>
			<form:errors class="text-danger" path="description"></form:errors>
		</div>

		<div class="form-group">
			<form:label path="title" for="title">Title</form:label>
			<form:input path="title" type="text" class="form-control" id="title"
				placeholder="new title" value="${unlibro.title }"/>
		</div>
		<div class="form-group">
			<form:label path="description" for="description">Description</form:label>
			<form:input type="text" path="description" class="form-control"
				id="description"  value="${unlibro.description }"/>
		</div>
		<div class="form-group">
			<form:label path="language" for="language">Language</form:label>
			<form:input type="text" path="language" class="form-control"
				id="language" placeholder="language" value="${unlibro.language }" />
		</div>
		<div class="form-group">
			<form:label path="numberOfPages" for="numberOfPages">Number pages</form:label>
			<form:input type="text" path="numberOfPages" class="form-control"
				id="numberOfPages" placeholder="Number Pages" value="${unlibro.numberOfPages }"/>
		</div>
		<div class="form-group">
			<form:input type="hidden" path="id" class="form-control"
				id="id"  value="${unlibro.id }"/>
			<button type="submit" class="btn btn-primary mb-2 form-control ">Submit</button>
		</div>
	</form:form>
	<a href="/books"> Regresar a libros </a>
</body>
</html>