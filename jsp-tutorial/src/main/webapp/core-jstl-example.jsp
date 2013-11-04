<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:out value="Hello"></c:out></br>
        
        <c:catch var="e" > 
            <%=Integer.parseInt("a")%>
        </c:catch>
        <c:if test="${e!=null}">
            <c:out value= "${e}"/></br> 
        </c:if>
    </body>
</html>
