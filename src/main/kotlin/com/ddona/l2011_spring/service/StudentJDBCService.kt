package com.ddona.l2011_spring.service

import com.ddona.l2011_spring.model.StudentJDBC
import com.ddona.l2011_spring.repository.StudentJDBCRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentJDBCService {

    @Autowired
    private lateinit var studentRepository: StudentJDBCRepository

    fun getAllStudent(): List<StudentJDBC> {
        return studentRepository.getAllStudent()
    }


    fun getStudentById(id: Int): StudentJDBC? {
        return studentRepository.getStudentById(id)
    }

    fun addStudent(studentJDBC: StudentJDBC) {
        return studentRepository.addStudent(studentJDBC)
    }

    fun updateStudent(student: StudentJDBC): Int {
        return studentRepository.updateStudent(student)
    }

    fun deleteStudent(id: Int): Int {
        return studentRepository.deleteStudent(id)
    }
}