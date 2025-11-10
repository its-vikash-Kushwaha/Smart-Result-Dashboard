package com.smart.result.controllers;


import com.smart.result.entities.Mark;
import com.smart.result.entities.Student;
import com.smart.result.payload.StudentForm;
import com.smart.result.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @RequestMapping("/input")
    public String viewResult(){
        System.out.println("Result app");
        return "view_result";
    }


    @RequestMapping("/view")
    public String getResult(){
        return "result_data";
    }

    @RequestMapping("/add")
    public String addResult(Model model){

        StudentForm  studentForm=new StudentForm();
        model.addAttribute("studentForm",studentForm);
        return "add_result";
    }
    @RequestMapping(value="/process-form",method= RequestMethod.POST)
    public String saveResult( @ModelAttribute StudentForm studentForm,Model model){

     String studentId=   resultService.save(studentForm);
     model.addAttribute("studentId",studentId);
        return "result_sucess";

    }

//    @PostMapping("/view-result")

    @RequestMapping(value="/view-result",method= RequestMethod.POST)
    public String viewResultByRollNumber(@RequestParam("rollNumber") String rollNumber,Model model){

        System.out.println("Roll Number : "+rollNumber);
        Student student = resultService.getResultByRollNumber(rollNumber);
//        System.out.println(student.getName());
//        System.out.println(student.getMarkList().size());

        if(student==null){
            return "result_not_fount";
        }else{
            double totalMarks=0;
            double totalMaxMarks=0;
            for(Mark mark:student.getMarkList()){
                totalMarks+=mark.getMarks();
                totalMaxMarks+=mark.getMaxMarks();
            }
            double percentage=(totalMarks/totalMaxMarks)*100;
            model.addAttribute("percentage",String.format("%.2f",percentage)+"%");
            model.addAttribute("totalMarks",(int)totalMarks);
            model.addAttribute("totalMaxMarks",(int)totalMaxMarks);
            String totalGrade = "";
            String feedback = "";

            if (percentage > 90) {
                totalGrade = "A+";
                feedback = "Excellent performance! Keep it up.";
            } else if (percentage > 80 && percentage <= 90) {
                totalGrade = "A";
                feedback = "Very good work, just a little push for perfection.";
            } else if (percentage > 70 && percentage <= 80) {
                totalGrade = "B+";
                feedback = "Good job, but there is room for improvement.";
            } else if (percentage > 60 && percentage <= 70) {
                totalGrade = "B";
                feedback = "Fair attempt, try to focus more on weak areas.";
            } else {
                totalGrade = "F";
                feedback = "Needs improvement. Don’t give up, work harder next time.";
            }
            model.addAttribute("feedback",feedback);
            model.addAttribute("totalGrade",totalGrade);
            model.addAttribute("student",student);
            model.addAttribute("marks",student.getMarkList());
            return "result_data";
        }

    }
}




//        System.out.println(studentForm.getName());
//        System.out.println(studentForm.getMarks().size());
//
//        studentForm.getMarks().forEach(marks->{
//            System.out.println("subject  :"+marks.getSubject());
//            System.out.println("Marks : "+marks.getMarks());
//            System.out.println("Max Marks : "+marks.getMaxMarks());
//            System.out.println("Remark : "+marks.getRemark());
//            System.out.println("Grade : "+marks.getGrade());
//            System.out.println("----------------------------");
//        });