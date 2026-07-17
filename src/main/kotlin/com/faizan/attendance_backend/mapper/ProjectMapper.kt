package com.faizan.attendance_backend.mapper

import com.faizan.attendance_backend.dto.CreateProjectRequest
import com.faizan.attendance_backend.dto.ProjectResponse
import com.faizan.attendance_backend.entity.Project

fun CreateProjectRequest.toEntity(): Project {
    return Project(
        name = name,
        description = description
    )
}

fun Project.toResponse(): ProjectResponse {
    return ProjectResponse(
        id = id!!,
        name = name,
        description = description
    )
}