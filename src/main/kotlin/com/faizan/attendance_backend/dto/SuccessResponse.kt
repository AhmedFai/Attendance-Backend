package com.faizan.attendance_backend.dto

data class SuccessResponse<T>(
    val message: String,
    val data: T
)
