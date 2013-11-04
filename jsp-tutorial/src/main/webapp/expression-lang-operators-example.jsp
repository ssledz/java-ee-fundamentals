<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Expression Language Operators Page Example</title>
        <style>
            table, td, th {
                border:1px solid black;
                padding:15px;
            }
            
            table {
                padding:0px;
            }
        </style>
    </head>
    <body>
        <table>
            <tr><th>Wyrażenie</th><th>Rezultat</th></tr>
            <tr><td>\${4.0 >= 3}</td><td>${4.0 >= 3}</td></tr>
            <tr><td>\${100.0 == 100}</td><td>${100.0 == 100}</td></tr>
            <tr><td>\${(10*10) ne 100}</td><td>${(10*10) ne 100}</td></tr>
            <tr><td>\${'a' < 'b'}</td><td>${'a' < 'b'}</td></tr>
            <tr><td>\${'hip' gt 'hit'}</td><td>${'hip' gt 'hit'}</td></tr>
            <tr><td>\${'hip' > 'hit'}</td><td>${'hip' > 'hit'}</td></tr>
            <tr><td>\${4 > 3}</td><td>${4 > 3}</td></tr>
            <tr><td>\${1.2E4 + 1.4}</td><td>${1.2E4 + 1.4}</td></tr>
            <tr><td>\${3 div 4}</td><td>${3 div 4}</td></tr>
            <tr><td>\${10 mod 4}</td><td>${10 mod 4}</td></tr>
            <tr><td>\${!empty param.firstName}</td><td>${!empty param.firstName}</td></tr>
            <tr><td>\${4 mod 2 == 0 ? "even" : "odd"}</td><td>${4 mod 2 == 0 ? "even" : "odd"}</td></tr>
        </table>
    </body>
</html>
