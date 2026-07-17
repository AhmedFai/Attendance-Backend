package com.faizan.attendance_backend.service

import com.faizan.attendance_backend.dto.AssignProjectRequest
import com.faizan.attendance_backend.dto.CreateProjectRequest
import com.faizan.attendance_backend.dto.ProjectResponse
import com.faizan.attendance_backend.dto.UserProjectResponse
import com.faizan.attendance_backend.entity.User
import com.faizan.attendance_backend.entity.UserProject
import com.faizan.attendance_backend.enums.ProjectStatus
import com.faizan.attendance_backend.exception.UserNotFoundException
import com.faizan.attendance_backend.mapper.toEntity
import com.faizan.attendance_backend.mapper.toResponse
import com.faizan.attendance_backend.repository.ProjectRepository
import com.faizan.attendance_backend.repository.UserProjectRepository
import com.faizan.attendance_backend.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ProjectService(
    private val projectRepository: ProjectRepository,

    private val userRepository: UserRepository,

    private val userProjectRepository: UserProjectRepository
) {

    fun createProject(request: CreateProjectRequest): ProjectResponse {
        val project = request.toEntity()
        val savedProject = projectRepository.save(project)
        return savedProject.toResponse()
    }

    fun getProjects(): List<ProjectResponse> {
        return projectRepository.findAll().map { it.toResponse() }
    }

    fun assignUserToProject(
        projectId: Int,
        request: AssignProjectRequest
    ): UserProjectResponse {
        val user = userRepository.findById(request.userId)
            .orElseThrow {
                UserNotFoundException("User with id ${request.userId} not found")
            }

        val project = projectRepository.findById(projectId)
            .orElseThrow {
                RuntimeException("Project with id $projectId not found")
            }

        val userProject = UserProject(
            role = request.role,
            assignedDate = request.assignedDate,
            status = request.status,
            user = user,
            project = project
        )

        val savedUserProject = userProjectRepository.save(userProject)

        return savedUserProject.toResponse()
    }

    fun assignDefaultProject(user: User): UserProject {

        val defaultProject = projectRepository.findById(1)
            .orElseThrow {
                RuntimeException("Default Project not found")
            }

        val userProject = UserProject(
            role = "Developer",
            assignedDate = LocalDate.now(),
            status = ProjectStatus.ACTIVE,
            user = user,
            project = defaultProject
        )

        return userProjectRepository.save(userProject)
    }
}