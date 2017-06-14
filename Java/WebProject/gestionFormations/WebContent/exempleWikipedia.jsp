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
<title>Exemple d'après https://fr.wikipedia.org/wiki/JavaServer_Pages</title>
</head>
<body>
  <%-- Déclaration d'une variable globale à la classe --%>
  <%! int nombreVisites = 0; %>
  <%-- Définition de code Java --%>
  <% //Il est possible d'écrire du code Java ici
    Date date = new Date();
    // On peut incrémenter une variable globale pour compter le nombre
    // d'affichages, par exemple.
    nombreVisites++;
  %>
  <h1>Exemple de page JSP</h1>
  <%-- Impression de variables --%>
  <p>Au moment de l'exécution de ce script, nous sommes le <%= date %>.</p>
  <p>Cette page a été affichée <%= nombreVisites %> fois !</p>
</body>
</html>