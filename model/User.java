package model;

import java.util.List;

public class User {
    private final int userId;
    private String name;
    private String email;
    private String passwordHash;
    private List<String> preferences; // e.g. ["electronics", "books"]

    public User(int userId, String name, String email, String passwordHash, List<String> preferences) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.preferences = preferences;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }

    public void updateProfile(String newName, String newEmail) {
        this.name = newName;
        this.email = newEmail;
    }

    public boolean authenticate(String suppliedHash) {
        return this.passwordHash.equals(suppliedHash);
    }
}
