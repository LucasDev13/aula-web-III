<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt" %>

<!-- Cria DAO -->
<jsp:useBean id="dao" class="br.com.jsp.dao.UserDao"/>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	
	<table>
		<!-- percorre os contatos montando as linhas da tabela -->
		<c:forEach var="contato" items="${dao.getAllRecords}">
			<tr>
				<td>${contato.name}</td>
				<td>
					<c:if test="${not empty contato.email}">
						<a href="milto:${contato.email}">${contato.email}</a>
					</c:if>
					<c:if test="${empty contato.email}">
						E-mail nao informado
					</c:if>
				</td>
				
				<td>${contato.endereco}</td>
<%-- 				<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyy" /></td> --%>
			</tr>
		</c:forEach>	
	</table>
	<c:import url="rodape.jsp"/>
</body>
</html>