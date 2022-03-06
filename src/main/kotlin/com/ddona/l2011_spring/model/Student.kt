package com.ddona.l2011_spring.model

import javax.persistence.*

@Entity
@Table(name = "student")
data class Student(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id", nullable = false)
        var id: Int,
        @Column(name = "name")
        var name: String,
        @Column(name = "address")
        var address: String,
        @Column(name = "score")
        var score: Float
)
