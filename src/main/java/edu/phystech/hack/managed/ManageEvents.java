package edu.phystech.hack.managed;

import edu.phystech.hack.ejb.Events;
import edu.phystech.hack.helper.IdHepler;
import edu.phystech.hack.storage.AppStorage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by yuranich on 05.12.2015.
 */
@ManagedBean(name ="manageEvents")
@SessionScoped
public class ManageEvents {

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

    public Events getEvent() {
        return event;
    }
}
