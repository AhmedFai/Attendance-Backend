package com.faizan.attendance_backend.dto

data class UserDetailsResponse(
    val id: Int,
    val name: String,
    val email: String,
    val age: Int,
    val attendances: List<AttendanceResponse>
)
