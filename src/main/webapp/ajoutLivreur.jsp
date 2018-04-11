<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="Livraison.DAO.*"%>
<%@page import="Livraison.model.*"%>
<%@page import="Livraison.*"%>
<%@ page language="java" %>
<%@page import="java.util.ArrayList" import="java.sql.Date" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<div class="container-fluid">
<center>
<h1><c:out value="Ajouter un livreur" /></h1>


		<%
		String code=(String)request.getAttribute("id");
		JournauxDAO Jdao=JournauxDAO.getInstance();
		
		
		String parcours=null;
		int ID_Dep=0;
		int Code=0;
		int ID_Liv=-1;
		journaux journal=null;
		
		%>
	</br></br>
	
</br></br>

<form action="Add_Liv_Jour" method="POST">
		 
		<input 
			name="ID_Liv" 
			value="<%=ID_Liv %>"
			type="hidden">
		<p>parcours :</p>
		<input
			type="parcours"
			name="parcours" 
			value="<%=parcours %>"
			placeholder="parcours">
		<p>ID_Dep :</p>
		<input
			
			name="ID_Dep" 
			value="<%=ID_Dep %>"
			placeholder="ID_Dep">
		<p>ID_Liv :</p>
		<input
			
			name="Code" 
			value="<%=code %>"
			placeholder="Code"
			class="field left" readonly
			>
		
		<br/> <br/>
		<button  type="submit" name="action" value="create">Creer la facture</button>
	</form>



<a href="http://localhost:8080/Servlet_DAO_Magasin/client" class="button">Retour</a>
</ul>
</center>
</div>
</body>
</html>