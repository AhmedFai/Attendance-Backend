package com.faizan.attendance_backend.service

import com.faizan.attendance_backend.dto.AttendanceResponse
import com.faizan.attendance_backend.entity.Attendance
import com.faizan.attendance_backend.mapper.toResponse
import com.faizan.attendance_backend.repository.AttendanceRepository
import org.springframework.stereotype.Service

@Service
class AttendanceService(
    private val attendanceRepository: AttendanceRepository
) {

    fun getAttendance(): List<AttendanceResponse> {
        return attendanceRepository.findAll().map {
            it.toResponse()
        }
    }

}