package com.faizan.attendance_backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "user_profile")
data class UserProfile(


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    val bio: String = "",

    val address: String = "",

    val dob: LocalDate? = null,

    @OneToOne
    @JoinColumn(name = "user_id")
    val user: User = User()

)
