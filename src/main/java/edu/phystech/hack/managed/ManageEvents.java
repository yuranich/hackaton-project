package edu.phystech.hack.managed;

import edu.phystech.hack.ejb.Events;
import edu.phystech.hack.helper.IdHepler;
import edu.phystech.hack.storage.AppStorage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yuranich on 05.12.2015.
 */
@ManagedBean(name = "events")
@SessionScoped
public class ManageEvents {

    @ManagedProperty(value = "#{users}")
    private ManageUsers users;

    private Events event = new Events();

    public Events getEvent() {
        return event;
    }

    public void setEvent(Events event) {
        this.event = event;
    }

    public String createEvent() {
        event.setEventId(IdHepler.createEventId());
        event.setLogin(users.getCurrentUserLogin());
        AppStorage.INSTANCE.addToEventStorage(copyEvents(event));
        return "my_events.xhtml";
    }

    public String removeEvent() {
        if (event.getEventId() != 0) {
            AppStorage.INSTANCE.removeEvent(event);
        }
        return "";
    }

    public List<Events> getEventsByCurrentUser() {
        List<Events> events = new ArrayList<>();
        String login = users.getCurrentUserLogin();
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

    public ManageUsers getUsers() {
        return users;
    }

    public void setUsers(ManageUsers users) {
        this.users = users;
    }

    public Events copyEvents(Events event) {
        Events res = new Events();
        res.setEventId(event.getEventId());
        res.setLogin(event.getLogin());
        res.setCountry(event.getCountry());
        res.setCity(event.getCity());
        res.setDate(event.getDate());
        res.setAddress(event.getAddress());
        res.setDescription(event.getDescription());
        return res;
    }
}
