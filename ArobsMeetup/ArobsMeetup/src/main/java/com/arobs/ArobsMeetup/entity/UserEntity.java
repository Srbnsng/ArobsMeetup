package com.arobs.ArobsMeetup.entity;

import com.arobs.ArobsMeetup.service.dto.enums.Role;

import javax.persistence.*;

@Entity
@Table(name="`User`")
public class UserEntity {
    @Id @GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name = "passwrd")
    private String password;
    @Column(name = "full_name")
    private String full_name;
    @Column(name = "urole")
    private Role role;
    @Column(name = "email")
    private String email;
    @Column(name = "points")
    private int points;


    public UserEntity(int id, String password, String full_name, Role role, String email) {
        this.id = id;
        this.password = password;
        this.full_name = full_name;
        this.role = role;
        this.email = email;
        this.points = 0;
    }

    public UserEntity(int id, String password, String full_name, Role role, String email, int points) {
        this.id = id;
        this.password = password;
        this.full_name = full_name;
        this.role = role;
        this.email = email;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", full_name='" + full_name + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", points=" + points +
                '}';
    }
}
