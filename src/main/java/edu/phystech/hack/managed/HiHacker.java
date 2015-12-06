package edu.phystech.hack.managed;

import javax.faces.bean.ManagedBean;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "hacker")
public class HiHacker {

    public String getMessage() {
        return "Hello Hacker!";
    }

    public List<String> getSimpleList() {
        return Arrays.asList("one", "two", "three");
    }
}
