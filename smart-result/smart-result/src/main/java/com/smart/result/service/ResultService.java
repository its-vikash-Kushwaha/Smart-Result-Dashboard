package com.smart.result.service;

import com.smart.result.entities.Mark;
import com.smart.result.entities.Student;
import com.smart.result.payload.StudentForm;
import com.smart.result.repository.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
    @Autowired
    private studentRepo srepo;

    public String save(StudentForm studentForm){
        Student student=new Student();
        student.setId(studentForm.getId());
        student.setName(studentForm.getName());
        student.setEmail(studentForm.getEmail());
        student.setDob(studentForm.getDob());
        student.setGender(studentForm.getGender());
        student.setRollNumber(studentForm.getRollNumber());
        student.setSchoolName(studentForm.getSchoolName());

      List<Mark> markList=  studentForm.getMarks().stream().map(markForm->{
            Mark mark=new Mark();
            mark.setSubject(markForm.getSubject());
            mark.setMarks(markForm.getMarks());
            mark.setMaxMarks(markForm.getMaxMarks());
            mark.setRemark(markForm.getRemark());
            mark.setGrade(markForm.getGrade());
            mark.setStudent(student);
            return mark;
        }).toList();
      student.setMarkList(markList);
      Student savedStudent=srepo.save(student);

        System.out.println("Student saved with ID: "+ savedStudent.getId());
        return savedStudent.getId();
    }

    public Student getResultByRollNumber(String rollNumber){
        return srepo.findByRollNumber(rollNumber);
    }
}
