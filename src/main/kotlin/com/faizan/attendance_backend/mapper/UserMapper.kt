package com.faizan.attendance_backend.mapper

import com.faizan.attendance_backend.dto.AttendanceResponse
import com.faizan.attendance_backend.dto.CreateUserRequest
import com.faizan.attendance_backend.dto.UserDetailsResponse
import com.faizan.attendance_backend.dto.UserProfileResponse
import com.faizan.attendance_backend.dto.UserResponse
import com.faizan.attendance_backend.entity.Attendance
import com.faizan.attendance_backend.entity.User
import com.faizan.attendance_backend.entity.UserProfile

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

fun Attendance.toResponse(): AttendanceResponse {
    return AttendanceResponse(
        attendanceDate = attendanceDate,
        isPresent = isPresent
    )
}

fun User.toDetailsResponse(): UserDetailsResponse {
    return UserDetailsResponse(
        id = id!!,
        name = name,
        email = email,
        age = age,
        attendances = attendance.map { it.toResponse() }
    )
}

fun UserProfile.toResponse(): UserProfileResponse {
    return UserProfileResponse(
        bio = bio,
        address = address,
        dob = dob
    )
}