<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page  pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Server Date And Time</title>
    </head>
    <body>
        <p>Server date and time: <% out.print(new Date()); %></p>
    </body>
</html>
