/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package event;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hanh
 */
public class EventManagerTest {

    private EventManager eventManager;

    @Before
    public void setUp() {
        eventManager = new EventManager();
    }

    @Test
    public void testRegisterEvent() {
        eventManager.register("user1", "event1");
        eventManager.register("user1", "event2");
        List<String> user1Events = eventManager.getEventsForUser("user1");
        assertEquals(2, user1Events.size());
        assertTrue(user1Events.contains("event1"));
        assertTrue(user1Events.contains("event2"));
    }

    @Test
    public void testUnregisterEvent() {
        eventManager.register("user1", "event1");
        eventManager.register("user1", "event2");
        eventManager.unregister("user1", "event1");
        List<String> user1Events = eventManager.getEventsForUser("user1");
        assertEquals(1, user1Events.size());
        assertFalse(user1Events.contains("event1"));
        assertTrue(user1Events.contains("event2"));
    }

    @Test
    public void testUnregisterAllEvents() {
        eventManager.register("user1", "event1");
        eventManager.register("user1", "event2");
        eventManager.unregister("user1", "event1");
        eventManager.unregister("user1", "event2");
        List<String> user1Events = eventManager.getEventsForUser("user1");
        assertEquals(0, user1Events.size());
    }

    @Test
    public void testGetEventsForNonExistingUser() {
        List<String> userEvents = eventManager.getEventsForUser("nonExistingUser");
        assertNotNull(userEvents);
        assertTrue(userEvents.isEmpty());
    }

}
