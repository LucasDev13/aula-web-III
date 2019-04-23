<%@page import="foo.Counter"%> <!-- importação da classe Counter -->
<%@page import="foo.ConnectionFactory" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- The pages cont is: -->
<!-- o código abaixo e denominado scrptles porque esta dentro dos  -->
<%-- <%! --%>
<!-- //  	//out.println(Counter.getCount()); -->
<!-- // 	int count=0; -->
<%-- %> --%>
<%-- <%= ++count %> --%>


<h1>CRUD JSP</h1>
<h3>Usuarios</h3>

	<a href="adduserform.jsp">Cadastrar usuarios</a>
	<a href="viewusers.jsp">Visualizar usuarios</a>

	
</body>
</html>