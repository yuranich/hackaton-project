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
        if (exist == null) {
            return "error.xhtml";
        }
        return "";
    }

    public String logout() {
        user = new Users();
        return "";
    }

    public String addUser() {
        AppStorage.INSTANCE.addToUserStorage(copyUsers(user));
        return "profile.xhtml";
    }

    public void removeUser() {
        AppStorage.INSTANCE.removeUser(user);
    }

    public String getCurrentUserLogin() {
        return user.getLogin();
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

    public boolean isLoggedIn() {
        return user.getLogin() != null;
    }
}
