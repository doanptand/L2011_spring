package com.ddona.l2011_spring.repository

import com.ddona.l2011_spring.model.Student
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : CrudRepository<Student, Int> {
    fun findStudentByName(name: String): Student
    fun findStudentsByScoreIsGreaterThan(score: Float): List<Student>
    fun findByAddressEquals(address: String): Student
}