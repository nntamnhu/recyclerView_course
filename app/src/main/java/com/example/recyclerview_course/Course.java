package com.example.recyclerview_course;

public class Course {
    private String courseCode;
    private String courseName;
    private String lecturerName;
    private int courseImage;

    public Course(String courseCode, String courseName, String lecturerName, int courseImage) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.lecturerName = lecturerName;
        this.courseImage = courseImage;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public int getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(int courseImage) {
        this.courseImage = courseImage;
    }
}
