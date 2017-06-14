<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Démo JSP</title>
</head>
<body>
   Bonjour, nous sommes <font color="red"><%=new Date()%></font> et vous êtes formé par Emmanuel !
   
 <TABLE BORDER=2>
<%
    for ( int i = 0; i < 5; i++ ) {
        %>
        
        <TR>
        <TD>Number</TD>
        <TD><%= i+1 %></TD>
        </TR>
        
        <%
    }
%>

</TABLE>
   
<%
    if ( 1 == 1 ) {
        %>
        <P>Hello, world
        <%
    } else {
        %>
        <P>Goodbye, world</P>
        <%
    }
%>

<%!
    Date theDate = new Date();
    Date getDate()
    {
        System.out.println( "In getDate() method" );
        return theDate;
    }
%>
<p>Hello!  The time is now <%= getDate() %></p>


</body>
</html>