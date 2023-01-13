package com.example.c196.database;

import android.app.Application;

import com.example.c196.dao.AssessmentDAO;
import com.example.c196.dao.CourseDAO;
import com.example.c196.dao.TermDAO;
import com.example.c196.entities.Assessment;
import com.example.c196.entities.Course;
import com.example.c196.entities.Term;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private TermDAO mTermDAO;
    private CourseDAO mCourseDAO;
    private AssessmentDAO mAssessmentDAO;
    private List<Term> mAllTerms;
    private List<Course> mAllCourses;
    private List<Assessment> mAllAssessments;

    private static int NUMBER_OF_THREADS=4;
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application) {
        DatabaseBuilder db = DatabaseBuilder.getDatabase(application);
        mTermDAO = db.termDAO();
        mCourseDAO = db.courseDAO();
        mAssessmentDAO = db.assessmentDAO();
    }

    //Term Methods
    public List<Term> getTerms() {
        databaseExecutor.execute(() -> {
            mAllTerms = mTermDAO.getTerms();
        });
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllTerms;
    }
    public void insertTerm(Term term) {
        databaseExecutor.execute(() -> mTermDAO.insertTerm(term));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void updateTerm(Term term) {
        databaseExecutor.execute(() -> mTermDAO.updateTerm(term));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void deleteTerm(Term term){
        databaseExecutor.execute(() -> mTermDAO.deleteTerm(term));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Course Methods
    public List<Course> getCourses() {
        databaseExecutor.execute(() -> {
            mAllCourses = mCourseDAO.getCourses();
        });
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllCourses;
    }
    public void insertCourse(Course course) {
        databaseExecutor.execute(() -> mCourseDAO.insertCourse(course));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void updateCourse(Course course) {
        databaseExecutor.execute(() -> mCourseDAO.updateCourse(course));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void deleteCourse(Course course){
        databaseExecutor.execute(() -> mCourseDAO.deleteCourse(course));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Assessment Methods
    public List<Assessment> getAssessments() {
        databaseExecutor.execute(() -> mAllAssessments = mAssessmentDAO.getAssessments());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllAssessments;
    }
    public void insertAssessment(Assessment assessment) {
        databaseExecutor.execute(() -> mAssessmentDAO.insertAssessment(assessment));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void updateAssessment(Assessment assessment) {
        databaseExecutor.execute(() -> mAssessmentDAO.updateAssessment(assessment));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void deleteAssessment(Assessment assessment) {
        databaseExecutor.execute(() -> mAssessmentDAO.deleteAssessment(assessment));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
