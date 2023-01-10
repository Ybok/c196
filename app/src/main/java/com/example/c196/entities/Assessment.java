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
    private String  assessmentDate;

    //Constructor

    public Assessment(int assessmentID, int courseID, String assessmentTitle, String assessmentType, String assessmentDate) {
        this.assessmentID = assessmentID;
        this.courseID = courseID;
        this.assessmentTitle = assessmentTitle;
        this.assessmentType = assessmentType;
        this.assessmentDate = assessmentDate;
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

    public String getAssessmentDate() {
        return assessmentDate;
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

    public void setAssessmentDate(String assessmentDate) {
        this.assessmentDate = assessmentDate;
    }
}
