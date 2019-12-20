package com.arobs.ArobsMeetup.service.user;

public class UserDTO {

    private String password;
    private String full_name;
    private String role;
    private String email;
    private int points;

    public UserDTO(String password,String full_name,String role,String email,int points){

        this.password = password;
        this.full_name = full_name;
        this.role = role;
        this.email = email;
        this.points = points;
    }

    public UserDTO() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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
}
