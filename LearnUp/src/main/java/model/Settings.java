/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author axelm
 */
public class Settings {
    private boolean notifications;
    private boolean darkMode;
    private String language;

    public Settings() {
    }

    public Settings(boolean notifications, boolean darkMode, String language) {
        this.notifications = notifications;
        this.darkMode = darkMode;
        this.language = language;
    }

    public void setNotifications(boolean notifications) {
        this.notifications = notifications;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isNotifications() {
        return notifications;
    }

    public boolean isDarkMode() {
        return darkMode;
    }

    public String getLanguage() {
        return language;
    }
}
