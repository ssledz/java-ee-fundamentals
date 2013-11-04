<%@page contentType="text/xml" pageEncoding="UTF-8"%>
<xml>
    <jsp:element name="parent">	
        <jsp:attribute name="firstName">Alan</jsp:attribute>
        <jsp:attribute name="lastName">Morgan</jsp:attribute>
        <jsp:body>
            <jsp:element name="child">	
                <jsp:attribute name="firstName">Anna</jsp:attribute>
                <jsp:attribute name="lastName">Morgan</jsp:attribute>
            </jsp:element>
        </jsp:body>
    </jsp:element>
</xml>
