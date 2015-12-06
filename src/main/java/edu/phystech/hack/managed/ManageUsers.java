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
        user.setAge(exist.getAge());
        user.setCity(exist.getCity());
        user.setCountry(exist.getCountry());
        user.setFirstName(exist.getFirstName());
        user.setLastName(exist.getLastName());
        user.setInterests(exist.getInterests());
        user.setLanguage(exist.getLanguage());
        return "faces/home.xhtml";
    }

    public String redirect(){
        if(user != null && user.getLogin() != null && user.getLogin().length() > 0){
            return "";
        }else{
            return "home.xhtml";
        }
    }

    public String logout() {
        user = new Users();
        return "home.xhtml";
    }

    public String addUser() {
        AppStorage.INSTANCE.addToUserStorage(copyUsers(user));
        return "profile.xhtml";
    }

    public boolean islogin(){

        if(user == null || user != null &&(user.getLogin() == null || user.getLogin().length() ==0 )) return true;
        if( user != null && user.getLogin() != null &&  user.getLogin().length() > 0 ){
            return false;
        }else{
            return true;
        }
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
        copy.setLastName(user.getLastName());
        copy.setFirstName(user.getFirstName());
        copy.setInterests(user.getInterests());
        return copy;
    }

    public boolean isLoggedIn() {
        return user.getLogin() != null;
    }
}
