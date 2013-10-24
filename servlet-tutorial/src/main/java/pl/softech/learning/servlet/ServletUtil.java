/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.softech.learning.servlet;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ssledz
 */
public class ServletUtil {

    public static void printBasicServletInfo(HttpServlet servlet, HttpServletRequest request, PrintWriter out) {

        out.println("<h2>Basic Servlet Information</h2>");
        out.println("<ul>");
        out.println("<li>Servlet context path: " + request.getContextPath() + "</li>");
        out.println("<li>Servlet path: " + request.getServletPath() + "</li>");
        out.println("<li>Http protocol: " + request.getProtocol() + "</li>");
        out.println("<li>Http method: " + request.getMethod() + "</li>");
        out.println("<li>Servlet name: " + servlet.getServletName() + "</li>");
        out.println("<li>Servlet info: " + servlet.getServletInfo() + "</li>");
        out.println("</ul>");

    }

}
