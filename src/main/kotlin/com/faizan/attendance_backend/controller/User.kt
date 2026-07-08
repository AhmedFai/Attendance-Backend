package com.faizan.attendance_backend.controller

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class User(
    val id: Int,

    @field:NotBlank(message = "Name cannot be empty")
    val name: String,

    @field:Email(message = "Invalid Email")
    val email: String,

    @field:Min(value = 18, message = "Age must be at least 18")
    val age: Int
)
