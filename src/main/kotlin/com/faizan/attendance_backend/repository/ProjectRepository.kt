package com.faizan.attendance_backend.repository

import com.faizan.attendance_backend.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository: JpaRepository<Project, Int>