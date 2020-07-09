package com.udemy.spring.springselenium.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class User {


    @Id
    private Integer id;
    private String from_country;
    private String to_country;
    private Date dob;
    private String firstName;
    private String lastName;

    @Column(name = "customer_email")
    private String email;

    private String phone;
    private String comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromCountry() {
        return from_country;
    }

    public void setFromCountry(String from_country) {
        this.from_country = from_country;
    }

    public String getToCountry() {
        return to_country;
    }

    public void setToCountry(String to_country) {
        this.to_country = to_country;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
