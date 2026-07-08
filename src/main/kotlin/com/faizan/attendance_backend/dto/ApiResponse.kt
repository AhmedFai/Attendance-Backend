package com.faizan.attendance_backend.dto


data class ApiResponse<T>(
    val message: String,
    val data: T?
)
