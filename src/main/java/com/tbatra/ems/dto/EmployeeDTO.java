package com.tbatra.ems.dto;

public class EmployeeDTO {

    private long id;
    private String firstName;
    private String lasteName;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public EmployeeDTO(long id, String firstName, String lasteName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lasteName = lasteName;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasteName() {
        return lasteName;
    }

    public void setLasteName(String lasteName) {
        this.lasteName = lasteName;
    }

}
