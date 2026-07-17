package com.faizan.attendance_backend.dto

import java.time.LocalDate

data class AttendanceResponse(
    val attendanceDate: LocalDate,
    val isPresent: Boolean
)
