package com.faizan.attendance_backend.dto

data class PaginatedResponse<T>(
    val message: String,
    val data: List<T>,
    val page: Int,
    val size: Int,
    val totalElements: Long,
    val totalPages: Int,
    val first: Boolean,
    val last: Boolean
)
