package edu.phystech.hack.managed;

import edu.phystech.hack.ejb.Events;
import edu.phystech.hack.storage.AppStorage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alex on 12/5/2015.
 */

@ManagedBean
@SessionScoped
public class SearchEvent {
    private String city;
    private GregorianCalendar date;
    private String description;


    public String makeSearch(){
        return "result.xhtml";
    }

    public List<Events> getEventsByParams(){
        ConcurrentHashMap<Integer, Events> eventBeforeSearch = AppStorage.INSTANCE.getEventStorageCopy();
        ConcurrentHashMap<Integer, Events> eventAfterSearch = new ConcurrentHashMap<Integer,Events>();
        if(city != null && city.length() != 0){
            for(Map.Entry<Integer,Events> entry : eventBeforeSearch.entrySet()){
                if(city.equalsIgnoreCase(entry.getValue().getCity())) eventAfterSearch.put(entry.getKey(),entry.getValue());
            }
        }
        eventBeforeSearch.clear();
        eventBeforeSearch = AppStorage.INSTANCE.getEventStorageCopy();

        if ( description != null && description.length() > 0 && !description.equals("") ){
            eventAfterSearch.clear();
            for(Map.Entry<Integer,Events> entry : eventBeforeSearch.entrySet()){
                if(entry.getValue().getDescription().contains(description) ) eventAfterSearch.put(entry.getKey(),entry.getValue());
            }
        }
        eventBeforeSearch = new ConcurrentHashMap<Integer,Events>(eventAfterSearch);

     /*   if(date != null){
            for(Map.Entry<Integer,Events> entry : eventBeforeSearch.entrySet()){
                GregorianCalendar eventDate = entry.getValue().getDate();
                GregorianCalendar before = new GregorianCalendar(eventDate.get(1),eventDate.get(2),eventDate.get(4)+1);
                GregorianCalendar after = new GregorianCalendar(eventDate.get(1),eventDate.get(2),eventDate.get(4));
                if(date.after(after) && date.before(before)) eventAfterSearch.put(entry.getKey(),entry.getValue());
            }
        }
    */    return new ArrayList<Events>(eventAfterSearch.values());
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

    public GregorianCalendar getDate() {
        return date;
    }

    // todo parse from string
    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
}

