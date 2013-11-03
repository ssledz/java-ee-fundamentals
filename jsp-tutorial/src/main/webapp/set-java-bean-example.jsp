<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="customer"
             class="pl.softech.learning.jsp.CustomerBean" scope="session"/>
<jsp:setProperty name="customer" property="firstName"  param="firstName"/>
<jsp:setProperty name="customer" property="lastName"  param="lastName"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <jsp:getProperty name="customer" property="firstName"/>
            <jsp:getProperty name="customer" property="lastName"/>
        </h1>
    </body>
</html>
