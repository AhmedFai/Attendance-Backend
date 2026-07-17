package com.faizan.attendance_backend.mapper

import com.faizan.attendance_backend.dto.UserProjectResponse
import com.faizan.attendance_backend.entity.UserProject

fun UserProject.toResponse(): UserProjectResponse {
    return UserProjectResponse(
        id = id!!,
        role = role,
        assignedDate = assignedDate,
        status = status,
        userName = user.name,
        projectName = project.name
    )
}