package ru.savrey;

import java.util.Objects;

public class User {
    String name;
    String password;

    private final boolean isAdmin;

    boolean isAuthenticate;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(String name, String password) {
        this(name, password, false);

    }

    //3.6.
    public boolean authenticate(String name, String password) {
        if (Objects.equals(this.name, name) && Objects.equals(this.password, password)) {
            isAuthenticate = true;
            return true;
        } else {
            isAuthenticate = false;
            return false;
        }
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", isAdmin=" + isAdmin +
                ", isAuthenticate=" + isAuthenticate +
                '}';
    }
}
