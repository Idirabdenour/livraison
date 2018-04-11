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
<h1><c:out value="Journaux du livreur" /></h1>


		<%
		livreur livreuroo=(livreur)request.getAttribute("livreur");
		
		//facture f=new facture();
		String parcours=null;
		int ID_Dep=0;
		int Code=0;
		int ID_Liv=-1;
		livreur livreur=null;
		
		if(livreuroo != null){
			parcours=livreuroo.getparcours();
			ID_Dep=livreuroo.getID_Dep();
			Code=livreuroo.getCode();
			ID_Liv=livreuroo.getID_Liv();
		}
		%>
	</br></br>
	<TABLE BORDER>
	<TR>
		<TH>parcours</TH><TH>Nom Dep</TH><TH>Code J</TH>
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
		<TD><%= Ldao.findByIdL_Code(livreur.getID_Liv()) %></TD>
		<TD><%= livreur.getCode() %> </TD>
		<TD><%= Jdao.findById(livreur.getID_Dep()).getTitre() %> </TD>
		<TD><%= Jdao.findById(livreur.getID_Dep()).getPrix() %> </TD>
	
	</TR>
					
		<%
	}
%>
</TABLE>
</br></br>



<a href="http://localhost:8080/livraison/client" class="button">Retour</a>
</ul>
</center>
</div>
</body>
</html>