<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <table border="1">
      <tr>
        <th>ISBN</th>
        <th>Title</th>
        <th>Price</th>
        <th>Description</th>
        <th>Number of pages</th>
        <th>Illustrations</th>
      </tr>

      <c:import url="books.xml" var="bookContent"/>
      <x:parse xml="${bookContent}" var="doc"/>

      <x:forEach var="b" select="$doc/books/book">

        <tr>
          <td><x:out select="$b/@isbn"/></td>
          <td><x:out select="$b/title"/></td>
          <td><x:out select="$b/@price"/></td>
          <td><x:out select="$b/description"/></td>
          <td><x:out select="$b/@nbOfPage"/></td>
          <td><x:out select="$b/@illustrations"/></td>
        </tr>
      </x:forEach>
    </table>
  </body>
</html>
