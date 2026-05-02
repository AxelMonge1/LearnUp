/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author axelm
 */
public class Contact {
    private String phone;
    private String linkedin;
    private String website;

    public Contact() {
    }

    public Contact(String phone, String linkedin, String website) {
        this.phone = phone;
        this.linkedin = linkedin;
        this.website = website;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getWebsite() {
        return website;
    }
}
