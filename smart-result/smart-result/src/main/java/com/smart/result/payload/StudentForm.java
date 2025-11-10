package com.smart.result.payload;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentForm {

    private String id;
    private String name;
    private String rollNumber;
    private String email;
    private String schoolName;
    private LocalDate dob;
    private String Gender;

    private List<MarksForm> marks=new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public List<MarksForm> getMarks() {
        return marks;
    }

    public void setMarks(List<MarksForm> marks) {
        this.marks = marks;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
