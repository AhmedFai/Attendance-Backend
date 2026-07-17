package com.faizan.attendance_backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "attendance")
data class Attendance(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "attendance_date")
    val attendanceDate: LocalDate = LocalDate.now(),

    @Column(name = "is_present")
    val isPresent: Boolean  = false,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User = User()


)