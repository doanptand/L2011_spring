package com.ddona.l2011_spring.repository

import com.ddona.l2011_spring.model.StudentJDBC
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

@Repository
class StudentJDBCRepository {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    val studentMapping = RowMapper<StudentJDBC> { rs, _ ->
        StudentJDBC(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getFloat("score")
        )
    }

    fun getAllStudent(): List<StudentJDBC> {
        return jdbcTemplate.query("SELECT * FROM student", studentMapping)
    }


    fun getStudentById(id: Int): StudentJDBC? {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM student WHERE id=?",
                arrayOf(id),
                studentMapping)
    }

    fun addStudent(studentJDBC: StudentJDBC) {
        return jdbcTemplate.execute(
                "INSERT INTO student(name, address, score) VALUES('${studentJDBC.name}','${studentJDBC.address}',${studentJDBC.score})")
    }

    fun updateStudent(student: StudentJDBC): Int {
        return jdbcTemplate.update(
                "UPDATE student SET name=?, address=?, score=? WHERE id=?",
                student.name,
                student.address,
                student.score,
                student.id
        )
    }

    fun deleteStudent(id: Int): Int {
        return jdbcTemplate.update("DELETE FROM student WHERE id=?", id)
    }
}