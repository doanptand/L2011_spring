package com.ddona.l2011_spring.service

import com.ddona.l2011_spring.model.Student
import com.ddona.l2011_spring.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class StudentService {

    @Autowired
    private lateinit var studentRepository: StudentRepository

    fun addStudent(student: Student): Student {
        return studentRepository.save(student)
    }

    fun updateStudent(student: Student): Student {
        return studentRepository.save(student)
    }

    fun deleteStudent(id: Int) {
        return studentRepository.deleteById(id)
    }

    fun getAllStudents(): List<Student> {
        return studentRepository.findAll().toList()
    }

    fun getStudentById(id: Int): Student? {
        return studentRepository.findByIdOrNull(id)
    }

    fun getStudentByName(name: String): Student {
        return studentRepository.findStudentByName(name)
    }

    fun getStudentsWithScoreGreaterThan(score: Float): List<Student> {
        return studentRepository.findStudentsByScoreIsGreaterThan(score)
    }

}