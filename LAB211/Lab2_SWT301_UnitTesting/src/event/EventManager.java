/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class EventManager {
private final Map<String, List<String>> events;
    private static final Logger LOG = Logger.getLogger(EventManager.class.getName());

    public EventManager() {
        events = new HashMap<>();
    }

    public void register(String userId, String event) {
        if (!events.containsKey(userId)) {
            List<String> listEvent = new ArrayList<>();
            listEvent.add(event);
            events.put(userId, listEvent);
        }
        events.get(userId).add(event);
    }

    public void unregister(String userId, String event) {
        if (events.containsKey(userId)) {
            events.get(userId).remove(event);
            if (events.get(userId).isEmpty()) {
                events.remove(userId);
            }
        }else{
            LOG.info("Not exist event of "+userId);
        }
    }

    public List<String> getEventsForUser(String userId) {
        return events.getOrDefault(userId, new ArrayList<>());
    }
}
