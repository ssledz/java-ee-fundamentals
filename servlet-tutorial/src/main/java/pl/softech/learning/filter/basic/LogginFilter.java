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
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 *
 * @author Sławomir Śledź <slawomir.sledz@sof-tech.pl>
 */
@WebFilter(filterName = "LogginFilter", urlPatterns = {"/log/*"}, initParams = {
    @WebInitParam(name = "debug", value = "true")})
public class LogginFilter implements Filter {

    private boolean debug;

    private FilterConfig filterConfig = null;

    public LogginFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("LogginFilter:DoBeforeProcessing");

            for (Enumeration en = request.getParameterNames(); en.hasMoreElements();) {
                String name = (String) en.nextElement();
                String values[] = request.getParameterValues(name);
                int n = values.length;
                StringBuilder buf = new StringBuilder();
                buf.append(name);
                buf.append("=");
                for (int i = 0; i < n; i++) {
                    buf.append(values[i]);
                    if (i < n - 1) {
                        buf.append(",");
                    }
                }
                log(buf.toString());
            }
        }
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("LogginFilter:DoAfterProcessing");

            for (Enumeration en = request.getAttributeNames(); en.hasMoreElements();) {
                String name = (String) en.nextElement();
                Object value = request.getAttribute(name);
                log("attribute: " + name + "=" + value.toString());

            }
        }

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

        if (debug) {
            log("LogginFilter:doFilter()");
        }

        doBeforeProcessing(request, response);

        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            t.printStackTrace();
        }

        doAfterProcessing(request, response);

    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        debug = Boolean.parseBoolean(this.filterConfig.getInitParameter("debug"));
        if (filterConfig != null) {
            if (debug) {
                log("LogginFilter:Initializing filter");
            }
        }
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
