<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>BOOK APIi</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container">
	<h1><c:out value="${libro.getTitle() }"></c:out></h1>
	<p>Descripcion:<c:out value="${libro.getDescription() }"></c:out></p>
	<p>Lenguaje:<c:out value="${libro.getLanguage() }"></c:out></p>
	<p>Numero de paginas:<c:out value="${libro.getNumberOfPages() }"></c:out></p>
	
	<a href="/books">Volver atras</a>
	<a href='/books/edit/${libro.getId() }'>editar</a>
	<a href='/books/delete/${libro.getId() }'>Eliminar</a>

</div>
</body>
</html>