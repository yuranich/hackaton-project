package edu.phystech.hack.managed;

import edu.phystech.hack.ejb.Comments;
import edu.phystech.hack.storage.AppStorage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by yuranich on 05.12.2015.
 */
@ManagedBean(name = "comments")
@SessionScoped
public class ManageComments {

    private Comments comment = new Comments();

    public void addComment() {
        if (comment.getEventId() != 0) {
            AppStorage.INSTANCE.addCommentStorage(copyComment(comment));
        }
    }

    public void deleteComment() {
        List<Comments> commentsList = AppStorage.INSTANCE.getCommentStorageCopy().get(comment.getEventId());
        if (commentsList == null) {
            throw new IllegalArgumentException("No comments found for evenId: " + comment.getEventId());
        }
        int size = commentsList.size();
        for (Comments com : commentsList) {
            if (com.getCommentId() == comment.getCommentId()) {
                AppStorage.INSTANCE.removeComment(com);
                break;
            }
        }
    }

    public void modifyComment() {
            
    }

    private Comments copyComment(Comments origin) {
        Comments copy = new Comments();
        copy.setCommentId(origin.getCommentId());
        copy.setDate(origin.getDate());
        copy.setEventId(origin.getEventId());
        copy.setDescription(origin.getDescription());
        copy.setLogin(origin.getLogin());
        return copy;
    }
}
