package com.ddona.l2011_spring.controller

import com.ddona.l2011_spring.model.Student
import com.ddona.l2011_spring.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/student")
class StudentController {

    @Autowired
    private lateinit var studentService: StudentService

    @GetMapping("/all")
    fun getAllStudents(): List<Student> {
        return studentService.getAllStudents()
    }

    @GetMapping("/id/{id}")
    fun getStudentById(@PathVariable("id") id: Int): Student? {
        return studentService.getStudentById(id)
    }

    @PostMapping("/add")
    fun addStudent(@RequestBody student: Student): ResponseEntity<Student> {
        return if (studentService.getStudentById(student.id) != null) {
            ResponseEntity.badRequest().build()
        } else {
            ResponseEntity.ok(studentService.addStudent(student))
        }
    }

    @PutMapping("/update")
    fun updateStudent(@RequestBody student: Student): ResponseEntity<Student> {
        return if (studentService.getStudentById(student.id) != null) {
            ResponseEntity.ok(studentService.updateStudent(student))
        } else {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/delete/{id}")
    fun deleteStudent(@PathVariable id: Int) {
        studentService.deleteStudent(id)
    }

    @GetMapping("/name/{name}")
    fun getStudentByName(@PathVariable("name") name: String): Student {
        return studentService.getStudentByName(name)
    }

    @GetMapping("/score/{score}")
    fun getStudentsWithScoreGreaterThan(@PathVariable("score") score: Float): List<Student> {
        return studentService.getStudentsWithScoreGreaterThan(score)
    }
}