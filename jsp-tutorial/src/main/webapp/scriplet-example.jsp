<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scriplet Page Example</title>
    </head>
    <body>

        <ul>
            <%for (int i = 0; i < 5; i++) {%>
            <li>i=<%=i%></li>
                <%if(i % 2 == 0) {%>
                    <ul>
                        <li>Even !</li>
                    </ul>
                <%}%>
            <%}%>
        </ul>
        
        <%! int[][] tab = { 
            {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}
        };%>
        
        <table border="1">
            <%for(int i = 0 ; i < tab.length; i++) {%>
            <tr>
                <%for(int j = 0 ; j < tab[i].length; j++) {%>
                <td><%=tab[i][j]%></td>
                <%}%>
            </tr>    
            <%}%>
            
        </table>
            <% out.print("<h1>Printing String with out object</h1>"); %>
    </body>
</html>
