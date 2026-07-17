package com.faizan.attendance_backend.dto

import jakarta.validation.constraints.NotBlank

data class CreateProjectRequest(

    @field:NotBlank(message = "Project name cannot be empty")
    val name: String,

    @field:NotBlank(message = "Description cannot be empty")
    val description: String

)
