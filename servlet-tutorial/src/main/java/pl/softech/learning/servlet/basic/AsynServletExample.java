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
package pl.softech.learning.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.softech.learning.servlet.ServletUtil;

/**
 *
 * @author Sławomir Śledź <slawomir.sledz@sof-tech.pl>
 */
@WebServlet(urlPatterns = {"/async-example"}, asyncSupported = true)
public class AsynServletExample extends HttpServlet {

    private class LongRunningTask implements Runnable {

        AsyncContext ac;
        int timeToSleep;

        public LongRunningTask(AsyncContext ac, int timeToSleep) {
            this.ac = ac;
            this.timeToSleep = timeToSleep;
        }

        @Override
        public void run() {

            ac.getRequest().setAttribute("timeToSleep", timeToSleep);
            
            try {
                Thread.sleep(timeToSleep);
            } catch (InterruptedException ex) {
            }
            ac.complete();
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {

        AsyncContext ac = request.startAsync();

        int timeTosleep = 5 * 1000;
        String timeout = request.getParameter("timeout");
        String sleep = request.getParameter("sleep");

        if(timeout != null) {
            ac.setTimeout(Integer.parseInt(timeout));
        }
        
        if(sleep != null) {
            timeTosleep = Integer.parseInt(sleep);
        }
        
        ac.addListener(new AsyncListener() {

            @Override
            public void onError(AsyncEvent event) throws IOException {
                ServletUtil.printMessage("AsynServletExample", "Error occoured", response);
            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {
            }

            @Override
            public void onComplete(AsyncEvent event) throws IOException {

                StringWriter writter = new StringWriter();
                ServletUtil.printRequestAttributes(request, new PrintWriter(writter));
                ServletUtil.printMessage("AsynServletExample", writter.toString(), response);

            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                ServletUtil.printMessage("AsynServletExample", "Timeout !", response);
            }
        });

        ac.start(new LongRunningTask(ac, timeTosleep));

    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
