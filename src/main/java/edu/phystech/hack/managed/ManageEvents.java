package edu.phystech.hack.managed;

import edu.phystech.hack.ejb.Events;
import edu.phystech.hack.helper.IdHepler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.Timestamp;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yuranich on 05.12.2015.
 */
@ManagedBean
@SessionScoped
public class ManageEvents {
    private ConcurrentHashMap<Integer, Events> eventStorage;


    private String login;
    private String city;
    private String description;
    private Timestamp date;
    private int eventId;

    public String createEvent(){
        eventId = IdHepler.createEventId();

        return "";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
