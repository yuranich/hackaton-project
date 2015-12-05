package edu.phystech.hack.ejb;

import java.util.GregorianCalendar;

public class Comments {

    private int commentId;
    private int eventId;
    private String login;
    private String description;
    private GregorianCalendar date;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public void setDate(GregorianCalendar date) {
        this.date = date;

    }

    @Override
    public boolean equals(Object other){
        if (!(other instanceof Comments))return false;
        if (other == this) return true;
        Comments otherMyClass = (Comments)other;
        if(this.commentId == otherMyClass.getCommentId()) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        return commentId;
    }



}
