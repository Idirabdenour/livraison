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
<h1><c:out value="Ajouter une facture" /></h1>


		<%
		String idclient=(String)request.getAttribute("id");
		ArticleDao Adao=ArticleDao.getInstance();
		
		//facture f=new facture();
		Date date=null;
		int ID_Article=0;
		int ID_Client=0;
		int ID_facture=-1;
		facture facture=null;
		
	/*	if(factureoo != null){
			date=factureoo.getdate();
			ID_Article=factureoo.getID_Article();
			ID_Client=factureoo.getID_Client();
			ID_facture=factureoo.getID_facture();
		}*/
		%>
	</br></br>
	
</br></br>

<form action="Add_FacC" method="POST">
		 
		<input 
			name="ID_facture" 
			value="<%=ID_facture %>"
			type="hidden">
		<p>Date :</p>
		<input
			type="date"
			name="date" 
			value="<%=date %>"
			placeholder="date">
		<p>ID_Article :</p>
		<input
			
			name="ID_Article" 
			value="<%=ID_Article %>"
			placeholder="ID_Article">
		<p>ID_Client :</p>
		<input
			
			name="ID_Client" 
			value="<%=idclient %>"
			placeholder="ID_Client"
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