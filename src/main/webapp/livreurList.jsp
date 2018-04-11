<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="Livraison.DAO.*"%>
<%@page import="Livraison.model.*"%>
<%@page import="Livraison.*"%>
<%@ page language="java" %>
<%@page import="java.util.ArrayList" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des livreurs</title>
</head>

<body>
<div class="container-fluid">
<center>
<h1><c:out value="Liste des livreurs" /></h1>

	<%
	livreur livreur=(livreur)request.getAttribute("livreur");
		
	%>

	</br></br>

	<TABLE BORDER>
	<TR>
		<TH>Date</TH><TH>Article</TH><TH>Id Client</TH><TH>Nom Client</TH><TH>Prénom Client</TH>
	</TR>
	<%
	ArrayList<livreur> livreurs=(ArrayList<livreur>) request.getAttribute("livreurs");
	
	livreurDAO Ldao=livreurDAO.getInstance();
	JournauxDAO Jdao=JournauxDAO.getInstance();
	
	
	for(int i=0;i<livreurs.size();i++){
		livreur = livreurs.get(i);
		%>
		<TR>
		
		<TD><%= livreur.getparcours() %></TD>
		<TD><%= livreur.getID_Liv() %> </TD>
		<TD><%= Jdao.findById(livreur.getID_Liv()).getTitre() %> </TD>
		<TD><%= Jdao.findById(livreur.getID_Liv()).getPrix() %> </TD>
	
	</TR>
					
		<%
	}
%>
</TABLE>
<a href="http://localhost:8080/livraison/princ" class="button">Retour</a>
</ul>
</center>
</div>
</body>
</html>