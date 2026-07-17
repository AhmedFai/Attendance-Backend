package com.faizan.attendance_backend.controller

import com.faizan.attendance_backend.dto.AssignProjectRequest
import com.faizan.attendance_backend.dto.CreateProjectRequest
import com.faizan.attendance_backend.dto.ProjectResponse
import com.faizan.attendance_backend.dto.SuccessResponse
import com.faizan.attendance_backend.dto.UserProjectResponse
import com.faizan.attendance_backend.service.ProjectService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/projects")
class ProjectController(
    private val projectService: ProjectService
) {

    @PostMapping
    fun createProject(
        @Valid
        @RequestBody request: CreateProjectRequest
    ): ResponseEntity<SuccessResponse<ProjectResponse>> {
        val project = projectService.createProject(request)

        return ResponseEntity.status(HttpStatus.CREATED).body(
            SuccessResponse(
                message = "Project created successfully",
                data = project
            )
        )
    }

    @GetMapping
    fun getProjects(): ResponseEntity<SuccessResponse<List<ProjectResponse>>> {

        val projects = projectService.getProjects()

        return ResponseEntity.ok(
            SuccessResponse(
                message = "Projects fetched successfully",
                data = projects
            )
        )
    }

    @PostMapping("/{projectId}/assign-user")
    fun assignUserToProject(
        @PathVariable projectId: Int,
        @RequestBody @Valid request: AssignProjectRequest
    ): ResponseEntity<SuccessResponse<UserProjectResponse>> {

        val response = projectService.assignUserToProject(
            projectId = projectId,
            request = request
        )

        return ResponseEntity.status(HttpStatus.CREATED).body(
            SuccessResponse(
                message = "User assigned to project successfully.",
                data = response
            )
        )
    }
}