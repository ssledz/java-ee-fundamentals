/*
 * Copyright 2013 Sławomir Śledź <slawomir.sledz@sof-tech.pl>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.softech.learning.filter.basic;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author Sławomir Śledź <slawomir.sledz@sof-tech.pl>
 */
@WebFilter(filterName = "SimpleLayoutFilter", urlPatterns = {"/layout/*"})
public class SimpleLayoutFilter implements Filter {

    public SimpleLayoutFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet MenuExampleServlet</title>");

        out.println("<style>");
        out.println(".main_nav { list-style: none; margin: 0; padding: 0; }");
        out.println(".main_nav li { float: left; }");
        out.println(".main_nav li a { display: block; height: 72px; text-decoration: none; padding: "
                + "8px 15px;font-weight: bold; color: #069; } ");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");
        out.println("<ul class='main_nav'>");
        out.println("<li><a href=\"#\">option 1</a></li>");
        out.println("<li><a href=\"#\">option 2</a></li>");
        out.println("<li><a href=\"#\">option 3</a></li>");
        out.println("</ul>");
        out.println("<div style='clear:left'></div>");
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        out.println("<div>Footer</div>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        doBeforeProcessing(request, response);

        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        
        
        doAfterProcessing(request, response);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
