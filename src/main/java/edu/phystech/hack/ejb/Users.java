package edu.phystech.hack.ejb;


public class Users {

    private String login;
    private String password;
    private String repeatpasswd;
    private String country;
    private String city;
    private String language;
    private Integer age;
    private String firstName;
    private String lastName;
    private String interests;

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRepeatpasswd() {
        return repeatpasswd;
    }

    public void setRepeatpasswd(String repeatpasswd) {
        this.repeatpasswd = repeatpasswd;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Users)) return false;
        if (other == this) return true;
        Users otherMyClass = (Users) other;
        if (otherMyClass.equals(this.login)) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }

}
