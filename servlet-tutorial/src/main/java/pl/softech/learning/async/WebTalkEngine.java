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
package pl.softech.learning.async;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.servlet.AsyncContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author Sławomir Śledź <slawomir.sledz@sof-tech.pl>
 */
@WebListener
public class WebTalkEngine implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        final List<AsyncContext> ctxs = new LinkedList<>();

        EventBus eventBus = new EventBus();
        sce.getServletContext().setAttribute("eventBus", eventBus);
        eventBus.add(new NewConnectionListener() {

            @Override
            public void onNewConnection(NewConnectionEvent event) {
                synchronized (ctxs) {
                    ctxs.add(event.getCtx());
                }
            }
        });

        eventBus.add(new MessageListener() {

            final Executor executor = Executors.newCachedThreadPool();

            @Override
            public void onMessage(final MessageEvent event) {
                synchronized (ctxs) {

                    Iterator<AsyncContext> it = ctxs.iterator();
                    while (it.hasNext()) {
                        final AsyncContext ctx = it.next();
                        it.remove();
                        executor.execute(new Runnable() {

                            @Override
                            public void run() {
                                try {
                                    try (PrintWriter writer = ctx.getResponse().getWriter()) {
                                        writer.print(event.getMessage());
                                    }
                                    ctx.complete();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });
                    }
                }

            }
        });
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
