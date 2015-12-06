package edu.phystech.hack.ejb;

import java.sql.Timestamp;
import java.util.GregorianCalendar;


public class Events {
    private int eventId;
    private String login;
    private String city;
    private String country;
    private String description;
    private GregorianCalendar date;
    private String address;
    private String date1;

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public GregorianCalendar getDate() {
        return date;
    }

    //todo parse from string
    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description.toLowerCase();
    }

    @Override
    public boolean equals(Object other){
        if (!(other instanceof Events))return false;
        if (other == this) return true;
        Events otherMyClass = (Events)other;
        if(this.eventId == otherMyClass.getEventId()) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        return eventId;
    }

}
