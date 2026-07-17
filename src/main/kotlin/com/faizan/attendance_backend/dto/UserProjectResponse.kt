package com.faizan.attendance_backend.dto

import com.faizan.attendance_backend.enums.ProjectStatus
import java.time.LocalDate

data class UserProjectResponse(

    val id: Int,

    val role: String,

    val assignedDate: LocalDate,

    val status: ProjectStatus,

    val userName: String,

    val projectName: String
)
