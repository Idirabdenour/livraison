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
<title>Articles en stock</title>
</head>

<body>
<div>
<center>
<h1><c:out value="Liste des Articles" /></h1>
</center>	
	<%
		article article=(article)request.getAttribute("article");
		String Nom_Article=null;
		String Categorie=null;
		String prix=null;
		String Quatite=null;
		int ID_Article=-1;
		
		if(article != null){
			Nom_Article=article.getNom_Article();
			Categorie=article.getCategorie();
			prix=article.getprix();
			Quatite=article.getQuantite();
			ID_Article=article.getID_Article();
		}
	%>

<h3><c:out value="Articles en stock :" /></h3>

<ul>

<TABLE BORDER>
	<TR>
		<TH>id</TH><TH>Nom</TH><TH>Categorie</TH><TH>Prix</TH><TH>Quantité</TH> 
	</TR>
<%
	ArrayList<article> articles=(ArrayList<article>) request.getAttribute("articles");
		
	for(int i=0;i<articles.size();i++){
		 article = articles.get(i);
		%>
	<TR>
		<TD><%= article.getID_Article() %></TD>
		<TD><%= article.getNom_Article() %></TD>
		<TD><%= article.getCategorie() %></TD>
		<TD><%= article.getprix() %> </TD>
		<TD><%= article.getQuantite() %></TD>
		<TD><a href="ArticleController?action=delete&id=<%=article.getID_Article() %>">Delete</a></TD>
		<TD><a href="ArticleController?action=select&id=<%=article.getID_Article() %>">Select</a></TD>
	</TR>
		
		<%
	}
%>
</TABLE>
</ul>
<h3><c:out value="Modifier :" /></h3>
	<form action="ArticleController" method="POST">
		 
		<input 
			class="form-control"
			name="ID_Article" 
			value="<%=ID_Article %>"
			type="hidden">
		<p>Nom :</p>
		<input
			class="form-control" 
			name="Nom_Article" 
			value="<%=Nom_Article %>"
			placeholder="Nom Article">
		<p>Categorie :</p>
		<input
			class="form-control" 
			name="Categorie" 
			value="<%=Categorie %>"
			placeholder="Categorie">
		<p>Prix :</p>
		<input
			class="form-control" 
			name="prix" 
			value="<%=prix %>"
			placeholder="prix">
		<p>Quantité :</p>
		<input 
			class="form-control"
			name="Quantite"
			value="<%=Quatite %>"
			placeholder="Quantité">
		<br/> <br/>
		<button class="btn btn-block btn-primary" type="submit" name="action" value="create">Creer un article</button>
		<button class="btn btn-block btn-primary" type="submit" name="action" value="update">Modifier l'article</button>
		<center>
		<a href="http://localhost:8080/Servlet_DAO_Magasin/princ" class="button">Retour</a>
		</center>
	</form>

</div>
</body>
</html>