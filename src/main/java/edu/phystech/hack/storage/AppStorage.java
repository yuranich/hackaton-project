package edu.phystech.hack.storage;

import edu.phystech.hack.ejb.Comments;
import edu.phystech.hack.ejb.Events;
import edu.phystech.hack.ejb.Users;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yuranich on 05.12.2015.
 */
public class AppStorage {
    public static final AppStorage INSTANCE = new AppStorage();

    private final ConcurrentHashMap<Integer, Events> eventStorage = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Integer, List<Comments>> commentStorage = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Users> userStorage = new ConcurrentHashMap<>();

    private AppStorage() {
    }

    public ConcurrentHashMap<Integer, Events> getEventStorageCopy() {
        return new ConcurrentHashMap<>(eventStorage);
    }

    public ConcurrentHashMap<Integer, List<Comments>> getCommentStorageCopy() {
        return new ConcurrentHashMap<>(commentStorage);
    }

    public ConcurrentHashMap<String, Users> getUserStorageCopy() {
        return new ConcurrentHashMap<>(userStorage);
    }

    public void addToEventStorage(Events event) {
        eventStorage.put(event.getEventId(), event);
    }

    public void addToCommentStorage(Comments comment) {
        List<Comments> commentsList = commentStorage.get(comment.getEventId());
        if (commentsList == null) {
            commentsList = new LinkedList<>();
            commentStorage.put(comment.getEventId(), commentsList);
        }
        commentsList.add(comment);
    }

    public void addToUserStorage(Users user) {
        userStorage.put(user.getLogin(), user);
    }

    public void removeEvent(Events events) {
        eventStorage.remove(events.getEventId());
    }

    public void removeComment(Comments comment) {
        List<Comments> commentsList = commentStorage.get(comment.getEventId());
        if (commentsList != null) {
            commentsList.remove(comment);
        }
    }

    public void removeUser(Users user) {
        userStorage.remove(user.getLogin());
    }
}
