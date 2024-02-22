package com.example.Library_Database_Management_System.Services;

import com.example.Library_Database_Management_System.DTOs.StudentUpdateMobRequestDto;
import com.example.Library_Database_Management_System.Models.Student;

public interface StudentService {
    public String createStudent(Student student);
    public String findNameByEmail(String email);
    public String updateMobNo(StudentUpdateMobRequestDto StudentReq);
}
