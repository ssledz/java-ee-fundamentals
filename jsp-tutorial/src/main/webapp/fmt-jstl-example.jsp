<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Formatting Example</title>
  </head>
  <body>

    <fmt:setLocale value="${param.locale}"/>
    Locale: ${param.locale}<br/><br/>

    Dates
    <ul>
      <c:set var="now" value="<%=new java.util.Date()%>"/>
      <li><fmt:formatDate type="time" value="${now}"/></li>
      <li><fmt:formatDate type="date" value="${now}"/></li>
      <li><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${now}"/></li>
      <li><fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${now}"/></li>
    </ul>
    Currency
    <ul>
      <li><fmt:formatNumber value="20.50" type="currency"/></li>
    </ul>

    Number
    <ul>
      <li><fmt:formatNumber value="2000000.50" type="number"/></li>
    </ul>

    <fmt:bundle basename="pl.softech.learning.jstl.jstl-fmt-example">
      String Internatiolization
      <ul>
        <li>
          hello-world: <fmt:message key="hello-world"/>
        </li>
      </ul>
    </fmt:bundle>
  </body>
</html>
