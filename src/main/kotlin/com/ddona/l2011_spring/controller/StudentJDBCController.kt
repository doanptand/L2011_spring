package com.ddona.l2011_spring.controller

import com.ddona.l2011_spring.model.StudentJDBC
import com.ddona.l2011_spring.service.StudentJDBCService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/student_jdbc")
class StudentJDBCController {

    @Autowired
    private lateinit var studentService: StudentJDBCService

    @GetMapping("/all")
    fun getAllStudent(): List<StudentJDBC> {
        return studentService.getAllStudent()
    }

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable("id") id: Int): StudentJDBC? {
        return studentService.getStudentById(id)
    }

    @PostMapping("/add")
    fun addStudent(@RequestBody studentJDBC: StudentJDBC) {
        return studentService.addStudent(studentJDBC)
    }

    @PutMapping("/update")
    fun updateStudent(@RequestBody student: StudentJDBC): Int {
        return studentService.updateStudent(student)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteStudent(@PathVariable id: Int): Int {
        return studentService.deleteStudent(id)
    }

}