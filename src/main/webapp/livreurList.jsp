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
<title>Liste des factures</title>
</head>

<body>
<div class="container-fluid">
<center>
<h1><c:out value="Liste des Factures" /></h1>

	<%
		facture facture=(facture)request.getAttribute("facture");
		
	%>

	</br></br>

	<TABLE BORDER>
	<TR>
		<TH>Date</TH><TH>Article</TH><TH>Id Client</TH><TH>Nom Client</TH><TH>Prénom Client</TH>
	</TR>
	<%
	ArrayList<facture> factures=(ArrayList<facture>) request.getAttribute("factures");
	
	ArticleDao Adao=ArticleDao.getInstance();
	ClientDAO Cdao=ClientDAO.getInstance();
	
	
	for(int i=0;i<factures.size();i++){
		facture = factures.get(i);
		%>
		<TR>
		
		<TD><%= facture.getdate() %></TD>
		<TD><%= Adao.findById(facture.getID_Article()).getNom_Article() %></TD>
		<TD><%= facture.getID_Client() %> </TD>
		<TD><%= Cdao.findById(facture.getID_Client()).getNom() %> </TD>
		<TD><%= Cdao.findById(facture.getID_Client()).getPrenom() %> </TD>
	
	</TR>
					
		<%
	}
%>
</TABLE>
<a href="http://localhost:8080/Servlet_DAO_Magasin/princ" class="button">Retour</a>
</ul>
</center>
</div>
</body>
</html>