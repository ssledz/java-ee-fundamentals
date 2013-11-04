<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Secondary Page</title>
    </head>
    <body>
        <%! String pageName = "Secondary";%>
        <%@ include file="WEB-INF/jspf/menu.jspf"%>
        <h1>Secondary Page</h1>
        <%@ include file="WEB-INF/jspf/footer.jspf"%>
    </body>
</html>
