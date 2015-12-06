package edu.phystech.hack.managed;

import edu.phystech.hack.ejb.Users;
import edu.phystech.hack.storage.AppStorage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yuranich on 05.12.2015.
 */
@ManagedBean(name = "users")
@SessionScoped
public class ManageUsers {

    private Users user = new Users();

    public String login() {
        ConcurrentHashMap<String, Users> map = AppStorage.INSTANCE.getUserStorageCopy();
        Users exist = map.get(user.getLogin());
        return "";
    }

    public void logout() {

    }

    public String addUser() {
        AppStorage.INSTANCE.addToUserStorage(copyUsers(user));
        return "";
    }

    public void removeUser() {

    }

    public String getCurrentUserLogin() {
        return "qu";
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    private Users copyUsers(Users user) {
        Users copy = new Users();
        copy.setLogin(user.getLogin());
        copy.setPassword(user.getPassword());
        copy.setAge(user.getAge());
        copy.setCity(user.getCity());
        copy.setCountry(user.getCountry());
        copy.setLanguage(user.getLanguage());
        return copy;
    }
}
