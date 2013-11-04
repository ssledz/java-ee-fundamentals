<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <c:catch var="e" > 
      <%=Integer.parseInt("a")%>
    </c:catch>
    <c:if test="${e != null}">
      <c:out value= "${e}"/></br> 
    </c:if>

    <c:set var="max" value="20"/>
    <ul>
      <c:forEach var="i" begin="3" end="${max - 5}">
        <li>
          <c:choose>
            <c:when test="${i % 2 == 0}">
              <c:out value="${i} is even"/><br/>
            </c:when>
            <c:otherwise>
              <c:out value="${i} is odd"/><br/>
            </c:otherwise>
          </c:choose>    
        </li>
      </c:forEach>
    </ul>

    <c:url scope="page" context="/aaa" value="/abcd/a?param=ala ma kota&param2=sss sss" var="url"></c:url><br/>
    <c:out value="${url}"/><br/>

    <c:import url="expression-lang-example.jsp">
      <c:param name="firstName" value="Alan"/>
      <c:param name="lastName" value="Turing"/>
    </c:import>
  </body>
</html>
