package com.faizan.attendance_backend.controller

import com.faizan.attendance_backend.dto.AttendanceResponse
import com.faizan.attendance_backend.entity.Attendance
import com.faizan.attendance_backend.service.AttendanceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/attendance")
class AttendanceController(
    private val attendanceService: AttendanceService
) {

    @GetMapping
    fun getAttendance(): List<AttendanceResponse> {
        return attendanceService.getAttendance()
    }

}