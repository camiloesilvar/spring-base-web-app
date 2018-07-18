<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href='<spring:url value="/css/bootstrap.css"/>' rel="stylesheet" />

<script type="text/javascript" src='<spring:url value="/js/jquery-3.3.1.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/js/popper.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/js/bootstrap.js"/>'></script>
<title>Pagina basica JSP</title>
</head>
<body>
	<div>base.jsp</div>
	<div>Contenido del JSP</div>
	<div><img alt="Spring 5" src='<spring:url value="/img/Spring_framework.png"/>'></div>
</body>
</html>