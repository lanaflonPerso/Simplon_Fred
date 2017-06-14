<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 --%>
<%-- Ceci est un commentaire JSP --%>
<%@page contentType="text/html"%>
<%@page errorPage="erreur.jsp"%>
<%-- Importation d'un paquetage (package) --%>
<%@page import="java.util.*"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemple d'apr�s https://fr.wikipedia.org/wiki/JavaServer_Pages</title>
</head>
<body>
  <%-- D�claration d'une variable globale � la classe --%>
  <%! int nombreVisites = 0; %>
  <%-- D�finition de code Java --%>
  <% //Il est possible d'�crire du code Java ici
    Date date = new Date();
    // On peut incr�menter une variable globale pour compter le nombre
    // d'affichages, par exemple.
    nombreVisites++;
  %>
  <h1>Exemple de page JSP</h1>
  <%-- Impression de variables --%>
  <p>Au moment de l'ex�cution de ce script, nous sommes le <%= date %>.</p>
  <p>Cette page a �t� affich�e <%= nombreVisites %> fois !</p>
</body>
</html>