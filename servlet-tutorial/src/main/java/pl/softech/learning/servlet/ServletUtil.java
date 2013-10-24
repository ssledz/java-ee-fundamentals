/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.softech.learning.servlet;

import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import java.io.PrintWriter;
import java.util.Enumeration;
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
        out.println("<li>Servlet path info: " + request.getPathInfo() + "</li>");
        out.println("<li>Query String: " + request.getQueryString() + "</li>");
        out.println("<li>Http protocol: " + request.getProtocol() + "</li>");
        out.println("<li>Http method: " + request.getMethod() + "</li>");
        out.println("<li>Servlet name: " + servlet.getServletName() + "</li>");
        out.println("<li>Servlet info: " + servlet.getServletInfo() + "</li>");
        out.println("</ul>");

    }

    public static void printInitParameters(HttpServlet servlet, PrintWriter out) {
        out.println("<h1>Init parameters</h1>");
        out.println("<ul>");

        for (Enumeration<String> e = servlet.getServletConfig().getInitParameterNames(); e.hasMoreElements();) {
            String paramName = e.nextElement();
            out.println(String.format("<li>%s: %s</li>", paramName,
                    servlet.getServletConfig().getInitParameter(paramName)));
        }

        out.println("</ul>");
    }

    public static void printRequestParameters(HttpServletRequest request, PrintWriter out) {

        out.println("<h1>Request parameters</h1>");
        out.println("<ul>");
        for (Enumeration<String> e = request.getParameterNames(); e.hasMoreElements();) {
            String paramName = e.nextElement();
            out.println(String.format("<li>%s: [%s]</li>", paramName,
                    Joiner.on(", ").join(request.getParameterValues(paramName))));
        }

        out.println("</ul>");
    }

    public static void printRequestHeaders(HttpServletRequest request, PrintWriter out) {

        out.println("<h1>Request headers</h1>");
        out.println("<ul>");

        for (Enumeration<String> e = request.getHeaderNames(); e.hasMoreElements();) {
            String paramName = e.nextElement();
            out.println(String.format("<li>%s: [%s]</li>", paramName,
                    Joiner.on(", ").join(Iterators.forEnumeration(request.getHeaders(paramName)))));
        }

        out.println("</ul>");
    }

}
