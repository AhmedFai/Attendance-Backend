package com.faizan.attendance_backend.dto

import java.time.LocalDate

data class UserProfileResponse(
    val bio: String,
    val address: String,
    val dob: LocalDate?
)