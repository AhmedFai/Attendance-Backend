package com.faizan.attendance_backend.mapper

import com.faizan.attendance_backend.dto.CreateUserRequest
import com.faizan.attendance_backend.dto.UserResponse
import com.faizan.attendance_backend.entity.User

fun CreateUserRequest.toEntity(): User {
    return User(
        name = name,
        email = email,
        age = age
    )
}

fun User.toResponse(): UserResponse {
    return UserResponse(
        id = id!!,
        name = name,
        email = email,
        age = age
    )
}