package edu.phystech.hack.managed;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "hacker")
public class HiHacker {

    public String getMessage() {
        return "Hello Hacker!";
    }
}
