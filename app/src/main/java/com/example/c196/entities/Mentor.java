package com.example.c196.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mentors")
public class Mentor {
    @PrimaryKey(autoGenerate = true)
    private int mentorID;
    private String mentorName;
    private String mentorPhone;
    private String mentorEmail;

    //Constructor

    public Mentor(int mentorID, String mentorName, String mentorPhone, String mentorEmail) {
        this.mentorID = mentorID;
        this.mentorName = mentorName;
        this.mentorPhone = mentorPhone;
        this.mentorEmail = mentorEmail;
    }

    public Mentor() {

    }

    //Getter

    public int getMentorID() {
        return mentorID;
    }

    public String getMentorName() {
        return mentorName;
    }

    public String getMentorPhone() {
        return mentorPhone;
    }

    public String getMentorEmail() {
        return mentorEmail;
    }

    //Setter

    public void setMentorID(int mentorID) {
        this.mentorID = mentorID;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public void setMentorPhone(String mentorPhone) {
        this.mentorPhone = mentorPhone;
    }

    public void setMentorEmail(String mentorEmail) {
        this.mentorEmail = mentorEmail;
    }
}
