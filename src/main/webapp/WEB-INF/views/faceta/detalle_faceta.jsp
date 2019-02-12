<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href='<spring:url value="/css/bootstrap.css"/>' rel="stylesheet" />
<link href='<spring:url value="/css/fontawesome-all.css"/>' rel="stylesheet" />
<link href='<spring:url value="/css/base.css"/>' rel="stylesheet" />
<title>Pagina basica JSP</title>
</head>
<body>
	<div class="container-fluid" id="wrapper">
	<div>Detalle Faceta</div>
	</div>
	
	<script src='<spring:url value="/js/jquery-3.3.1.js"/>'></script>
	<script src='<spring:url value="/js/popper.js"/>'></script>
	<script src='<spring:url value="/js/bootstrap.js"/>'></script>
</body>
</html>