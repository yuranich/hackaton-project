package edu.phystech.hack.managed;

import edu.phystech.hack.ejb.Events;
import edu.phystech.hack.helper.IdHepler;
import edu.phystech.hack.storage.AppStorage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yuranich on 05.12.2015.
 */
@ManagedBean
@SessionScoped
public class ManageEvents {

    @Inject
    private ManageUsers userManager;

    private Events event = new Events();

    public String createEvent() {
        event.setEventId(IdHepler.createEventId());
        AppStorage.INSTANCE.addToEventStorage(event);
        return "result.xhtml";
    }

    public String removeEvent() {
        if (event.getEventId() != 0) {
            AppStorage.INSTANCE.removeEvent(event);
        }
        return "";
    }

    public List<Events> getEventsByCurrentUser() {
        List<Events> events = new ArrayList<>();
        String login = userManager.getCurrentUserLogin();
        if (login == null || login.isEmpty()) {
            return events;
        }
        ConcurrentHashMap<Integer, Events> map = AppStorage.INSTANCE.getEventStorageCopy();
        for (Events e : map.values()) {
            if (login.equals(e.getLogin())) {
                events.add(e);
            }
        }
        return events;
    }
}
