package com.faizan.attendance_backend.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class UpdateUserRequest(
    @field:NotBlank(message = "Name can not be empty")
    val name: String,
    @field:Min(value = 18, message = "Age must be at least 18")
    val age: Int
)
