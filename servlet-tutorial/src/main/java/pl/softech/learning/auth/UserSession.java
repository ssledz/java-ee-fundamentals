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

package pl.softech.learning.auth;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 *
 * @author Sławomir Śledź <slawomir.sledz@sof-tech.pl>
 */
public class UserSession implements HttpSessionBindingListener {
    
    private String userName;

    public UserSession(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "UserSession{" + "userName=" + userName + '}';
    }
    
    

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        event.getSession().getServletContext().log("Binding " + this);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        event.getSession().getServletContext().log("Unbinding " + this);
    }
    
}
