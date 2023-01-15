package com.example.c196.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "assessments")
public class Assessment {
    @PrimaryKey(autoGenerate = true)
    private int assessmentID;
    private int courseID;
    private String assessmentTitle;
    private String assessmentType;
    private String assessmentStartDate;
    private String assessmentEndDate;

    //Constructor

    public Assessment(int assessmentID, String assessmentTitle, String assessmentType, String assessmentStartDate, String assessmentEndDate, int courseID) {
        this.assessmentID = assessmentID;
        this.assessmentTitle = assessmentTitle;
        this.assessmentType = assessmentType;
        this.assessmentStartDate = assessmentStartDate;
        this.assessmentEndDate = assessmentEndDate;
        this.courseID = courseID;
    }

    public Assessment() {

    }

    //Getter

    public int getAssessmentID() {
        return assessmentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public String getAssessmentTitle() {
        return assessmentTitle;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    public String getAssessmentStartDate() {
        return assessmentStartDate;
    }

    public String getAssessmentEndDate() {
        return assessmentEndDate;
    }

    //Setter

    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public void setAssessmentTitle(String assessmentTitle) {
        this.assessmentTitle = assessmentTitle;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    public void setAssessmentStartDate(String assessmentStartDate) {
        this.assessmentStartDate = assessmentStartDate;
    }

    public void setAssessmentEndDate(String assessmentEndDate) {
        this.assessmentEndDate = assessmentEndDate;
    }
}
