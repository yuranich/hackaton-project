package edu.phystech.hack.helper;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Alex on 12/5/2015.
 */
public class IdHepler {

    private static AtomicInteger commentId = new AtomicInteger(0);
    private static AtomicInteger evenetId = new AtomicInteger(0);

    public static Integer createCommentId(){
        return commentId.incrementAndGet();
    }

    public static Integer createEventId(){
        return evenetId.incrementAndGet();
    }

}
