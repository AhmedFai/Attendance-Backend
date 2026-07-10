package com.faizan.attendance_backend.repository

import com.faizan.attendance_backend.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Int>