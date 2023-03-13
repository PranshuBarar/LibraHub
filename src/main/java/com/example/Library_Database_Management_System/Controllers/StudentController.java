package com.example.Library_Database_Management_System.Controllers;

import com.example.Library_Database_Management_System.DTOs.StudentUpdateMobRequestDto;
import com.example.Library_Database_Management_System.Models.Student;
import com.example.Library_Database_Management_System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/get_user")
    public String getNameByEmail(@RequestParam("email") String email){
        return studentService.findNameByEmail(email);
    }

    @PutMapping("/update_mob")
    public String updateMob(@RequestBody StudentUpdateMobRequestDto studentReq){
        return studentService.updateMobNo(studentReq);
    }
}
