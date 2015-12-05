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

    public void updateEventStorage(Events event) {
        eventStorage.put(event.getEventId(), event);
    }

    public void updateEventStorage(Map<Integer, Events> events) {
        eventStorage.putAll(events);
    }

    public void updateCommentStorage(Comments comment) {
        List<Comments> commentsList = commentStorage.get(comment.getEventId());
        if (commentsList == null) {
            commentsList = new LinkedList<>();
            commentStorage.put(comment.getEventId(), commentsList);
        }
        commentsList.add(comment);
    }

    public void updateCommentStorage(Map<Integer, List<Comments>> comments) {
        commentStorage.putAll(comments);
    }

    public void updateUserStorage(Users user) {
        userStorage.put(user.getLogin(), user);
    }

    public void updateUserStorage(Map<String, Users> users) {
        userStorage.putAll(users);
    }
}
