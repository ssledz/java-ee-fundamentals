<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="customer"
             class="pl.softech.learning.jsp.CustomerBean" scope="session"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP java bean example</title>
        <style>
            label {
                float: left;
                padding-right: 50px;
                width: 100px;
            }
        </style>
    </head>
    <body>
        <form action="customer-controller" method="POST">
            <p>
                <label for="firstName">First name:</label>
                <input id="firstName" type="text" name="firstName" value="${customer.firstName}" />
            </p>
            <p>
                <label for="lastName">Last name:</label>
                <input id="lastName" type="text" name="lastName" value="${customer.lastName}" />
            </p>
            <input type="submit">
        </form>
    </body>
</html>
