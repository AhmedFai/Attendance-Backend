package com.faizan.attendance_backend.entity

import com.faizan.attendance_backend.enums.ProjectStatus
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "user_projects")
data class UserProject(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    val role: String = "",

    val assignedDate: LocalDate = LocalDate.now(),

    @Enumerated(EnumType.STRING)
    val status: ProjectStatus = ProjectStatus.ACTIVE,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User = User(),

    @ManyToOne
    @JoinColumn(name = "project_id")
    val project: Project = Project()
)