package com.faizan.attendance_backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "projects")
data class Project(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    val name: String = "",

    val description: String = "",

    @OneToMany(mappedBy = "project")
    val userProjects: List<UserProject> = emptyList()

)
