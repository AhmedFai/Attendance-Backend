package com.faizan.attendance_backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @field:NotBlank(message = "Name cannot be empty")
    val name: String = "",

    @field:Email(message = "Invalid Email")
    val email: String = "",

    @field:Min(value = 18, message = "Age must be at least 18")
    val age: Int = 18

)