package com.faizan.attendance_backend.dto

import com.faizan.attendance_backend.entity.User

data class UserResponse(
    val id: Int,
    val name: String,
    val email: String,
    val age: Int
)