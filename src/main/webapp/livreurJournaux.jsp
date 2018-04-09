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
<h1><c:out value="Facture du clients" /></h1>


		<%
		facture factureoo=(facture)request.getAttribute("facture");
		
		//facture f=new facture();
		Date date=null;
		int ID_Article=0;
		int ID_Client=0;
		int ID_facture=-1;
		facture facture=null;
		
		if(factureoo != null){
			date=factureoo.getdate();
			ID_Article=factureoo.getID_Article();
			ID_Client=factureoo.getID_Client();
			ID_facture=factureoo.getID_facture();
		}
		%>
	</br></br>
	<TABLE BORDER>
	<TR>
		<TH>Date</TH><TH>Numéro d'article</TH><TH>Id Client</TH><TH>Nom Client</TH><TH>Prénom Client</TH>
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
</br></br>



<a href="http://localhost:8080/Servlet_DAO_Magasin/client" class="button">Retour</a>
</ul>
</center>
</div>
</body>
</html>