package ru.job4j.forum.models;

public class User {

    private int id;
    private String username;
    private String password;
    private Authority authority;

    public static User of(int id, String username, String pwd, Authority authority) {
        User user = new User();
        user.id = id;
        user.username = username;
        user.password = pwd;
        user.authority = authority;
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
