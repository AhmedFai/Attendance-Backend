package com.faizan.attendance_backend.repository

import com.faizan.attendance_backend.entity.UserProfile
import org.springframework.data.jpa.repository.JpaRepository

interface UserProfileRepository : JpaRepository<UserProfile, Int>