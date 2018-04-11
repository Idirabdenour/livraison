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
<title>Dépositaires</title>
</head>

<body>
<div>
<center>
<h1><c:out value="Liste des Dépositaires" /></h1>
</center>	
	<%
	depositaire depositaire=(depositaire)request.getAttribute("depositaire");
		String Nom=null;
		String adresse=null;
		int ID_Dep=-1;
		
		if(depositaire != null){
			Nom=depositaire.getNom();
			adresse=depositaire.getadresse();
			ID_Dep=depositaire.getID_Dep();
		}
	%>

<h3><c:out value="Dépositaires :" /></h3>

<ul>

<TABLE BORDER>
	<TR>
		<TH>id</TH><TH>Nom</TH><TH>adresse</TH> 
	</TR>
<%
	ArrayList<depositaire> depositaires=(ArrayList<depositaire>) request.getAttribute("depositaires");
		
	for(int i=0;i<depositaires.size();i++){
		depositaire = depositaires.get(i);
		%>
	<TR>
		<TD><%= depositaire.getID_Dep() %></TD>
		<TD><%= depositaire.getNom() %></TD>
		<TD><%= depositaire.getadresse() %></TD>
		<TD><a href="ArticleController?action=delete&id=<%=depositaire.getID_Dep() %>">Delete</a></TD>
		<TD><a href="ArticleController?action=select&id=<%=depositaire.getID_Dep() %>">Select</a></TD>
	</TR>
		
		<%
	}
%>
</TABLE>
</ul>
<h3><c:out value="Modifier :" /></h3>
	<form action="Depositaire_Controller" method="POST">
		 
		<input 
			class="form-control"
			name="ID_Dep" 
			value="<%=ID_Dep %>"
			type="hidden">
		<p>Nom :</p>
		<input
			class="form-control" 
			name="Nom" 
			value="<%=Nom %>"
			placeholder="Nom">
		<p>adresse :</p>
		<input
			class="form-control" 
			name="adresse" 
			value="<%=adresse %>"
			placeholder="adresse">
		
		<button class="btn btn-block btn-primary" type="submit" name="action" value="create">Creer un dépositaire</button>
		<button class="btn btn-block btn-primary" type="submit" name="action" value="update">Modifier le dépositaire</button>
		<center>
		<a href="http://localhost:8080/livraison/princ" class="button">Retour</a>
		</center>
	</form>

</div>
</body>
</html>