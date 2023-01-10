package com.example.c196.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "courses")
public class Course {
    @PrimaryKey(autoGenerate = true)
    private int courseID;
    private String courseTitle;
    private String courseStartDate;
    private String courseEndDate;
    private String courseStatus;
    private int termID;

    //Constructor
    public Course(int courseID, String courseTitle, String courseStartDate, String courseEndDate, String courseStatus, int termID) {
        this.courseID = courseID;
        this.courseTitle = courseTitle;
        this.courseStartDate = courseStartDate;
        this.courseEndDate = courseEndDate;
        this.courseStatus = courseStatus;
        this.termID = termID;
    }

    public Course() {

    }

    //Getter
    public int getCourseID() {
        return courseID;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getCourseStartDate() {
        return courseStartDate;
    }

    public String getCourseEndDate() {
        return courseEndDate;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public int getTermID() {
        return termID;
    }

    //Setter
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setCourseStartDate(String courseStartDate) {
        this.courseStartDate = courseStartDate;
    }

    public void setCourseEndDate(String courseEndDate) {
        this.courseEndDate = courseEndDate;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public void setTermID(int termID) {
        this.termID = termID;
    }
}
