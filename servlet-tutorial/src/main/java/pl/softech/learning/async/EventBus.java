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

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Sławomir Śledź <slawomir.sledz@sof-tech.pl>
 */
public class EventBus {

    private final List<NewConnectionListener> newConnectionListeners;
    private final List<MessageListener> messageListeners;

    public EventBus() {
        newConnectionListeners = new LinkedList<>();
        messageListeners = new LinkedList<>();
    }

    public void add(NewConnectionListener l) {
        newConnectionListeners.add(l);
    }
    
    public void add(MessageListener l) {
        messageListeners.add(l);
    }
    
    public void fire(NewConnectionEvent event) {
        for (NewConnectionListener l : newConnectionListeners) {
            l.onNewConnection(event);
        }
    }

    public void fire(MessageEvent event) {
        for (MessageListener l : messageListeners) {
            l.onMessage(event);
        }
    }

}
