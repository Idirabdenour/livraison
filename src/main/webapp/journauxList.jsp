<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page import="Livraison.DAO.*"%>
<%@page import="Livraison.model.*"%>
<%@page import="Livraison.*"%>
<%@ page language="java" %>
<%@page import="java.util.ArrayList" import="java.util.*"
 %>
<%@page import="java.sql.Date" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gérer les journaux </title>
</head>

<body>
<div>
<center>
<h1><c:out value="Choisir un client" /></h1>
</center>

	<%
		//client
		journaux journal=(journaux)request.getAttribute("journal");
		
		String Titre=null;
		String categorie=null;
		int prix=0;
		int Code=-1;
			
		if(journal != null){
			Titre=journal.getTitre();
			prix=journal.getPrix();
			categorie=journal.getCategorie();
			Code=journal.getCode();
		}
		
	%>
	
<%
	ArrayList<journaux> journaux=(ArrayList<journaux>) request.getAttribute("journaux");
	ArrayList<facture> factures=(ArrayList<facture>) request.getAttribute("factures");
	
	
	%>
	</br></br>
	<center>
	<TABLE BORDER>
	<TR>
		<TH>Code</TH><TH>Titre</TH><TH>Prix</TH><TH>categorie</TH><TH>Selectionner</TH> 
	</TR>
	<%
	for(int i=0;i<journaux.size();i++){
		 journal = journaux.get(i);
		%>
		<TR>
		<TD><%= journal.getCode()%></TD>
		<TD><%= journal.getTitre()%></TD>
		<TD><%= journal.getPrix()%></TD>
		<TD><%= journal.getCategorie()%></TD>
		<TD><a href="Client_Controller?action=select&id=<%=journal.getCode() %>">Select</a></TD>
		
	</TR>
			
		<%
	}
%>
</TABLE>

</br></br>
<h3><c:out value="Modifier le journal" /></h3>

<form action="Client_Controller" method="POST">
		
		<input 
			name="Code" 
			value="<%=Code %>"
			type="hidden">
		<p>Titre :</p>
		<input
			name="Titre" 
			value="<%=Titre %>"
			placeholder="Titre">
		<p>Prix :</p>
		<input
			name="Prix" 
			value="<%=prix %>"
			placeholder="prix">
		<p>Categorie :</p>
		<input
			name="Categorie" 
			value="<%=categorie %>"
			placeholder="Categorie">
		<br/><br/>
		<button  type="submit" name="action" value="update">Modifier le journal </button>
		<button  type="submit" name="action" value="facture">voir ses factures</button>
		<button  type="submit" name="action" value="ajout">Ajout d'une facture</button>
</form>
</center>	
	<br/><br/>
		
		
	
	<center>
		<a href="http://localhost:8080/Servlet_DAO_Magasin/princ" class="button">Retour</a>
	</center>
</div>
</body>
</html>