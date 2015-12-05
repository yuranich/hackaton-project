package edu.phystech.hack.managed;

import edu.phystech.hack.ejb.Events;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yuranich on 05.12.2015.
 */
@ManagedBean
@ApplicationScoped
public class ManageEvents {
    private ConcurrentHashMap<Integer, Events> eventStorage;


}
