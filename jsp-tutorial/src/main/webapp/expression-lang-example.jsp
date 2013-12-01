<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="customer"
             class="pl.softech.learning.jsp.CustomerBean" scope="request"/>
<jsp:setProperty name="customer" property="firstName" param="firstName"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Expression Language Page Example</title>
    </head>
    <body>
        <ul>
            <li>firstName: ${pageContext.request.getParameter("firstName")}</li>
            <li>firstName: ${param["firstName"]}</li>
            <li>referer: ${header["Referer"]}</li>
            <li>cookie[JSESSIONID]: ${cookie["JSESSIONID"].value}</li>
            <li>customer ${requestScope["customer"]}</li>
            <li>firstName: ${requestScope["customer"]["firstName"]}</li>
            <li>firstName: ${requestScope["customer"].firstName}</li>
        </ul>
    </body>
</html>
