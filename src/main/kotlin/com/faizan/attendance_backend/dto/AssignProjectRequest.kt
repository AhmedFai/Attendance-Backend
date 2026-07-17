package com.faizan.attendance_backend.dto

import com.faizan.attendance_backend.enums.ProjectStatus
import java.time.LocalDate

data class AssignProjectRequest(

    val userId: Int,

    val role: String,

    val assignedDate: LocalDate,

    val status: ProjectStatus
)
