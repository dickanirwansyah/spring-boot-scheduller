package com.dicka.examplescheduller.payload;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class RequestAccount {

    private String firstname;
    private String lastname;
    private String email;
    private LocalDateTime dateTime;
    private ZoneId timeZone;

    public RequestAccount(){}

    public RequestAccount(String firstname, String lastname, String email, LocalDateTime dateTime, ZoneId timeZone){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dateTime = dateTime;
        this.timeZone = timeZone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ZoneId getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(ZoneId timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public String toString() {
        return "RequestAccount{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", dateTime=" + dateTime +
                ", timeZone=" + timeZone +
                '}';
    }
}
