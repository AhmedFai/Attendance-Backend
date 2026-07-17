package com.faizan.attendance_backend.repository

import com.faizan.attendance_backend.entity.UserProject
import org.springframework.data.jpa.repository.JpaRepository

interface UserProjectRepository : JpaRepository<UserProject, Int>