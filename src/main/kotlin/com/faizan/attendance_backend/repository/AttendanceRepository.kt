package com.faizan.attendance_backend.repository

import com.faizan.attendance_backend.entity.Attendance
import org.springframework.data.jpa.repository.JpaRepository

interface AttendanceRepository : JpaRepository<Attendance, Int>