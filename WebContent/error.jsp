<%@ page isErrorPage="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="view/includeResources.jsp"%>
</head>
<body>
	<%@ include file="view/include/header.jsp"%>
	<div class="col-md-12">
		<h1 class="display-4 text-center">Projects</h1>
		<br /> <a href="projectForm.jsp" class="btn btn-lg btn-info">
			Create a Project </a> <br />
		<hr />
	</div>
	<h3 align="center">There is no project on your dashboard</h3>
</body>
</html>