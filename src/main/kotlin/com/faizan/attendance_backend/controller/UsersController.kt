package com.faizan.attendance_backend.controller

import com.faizan.attendance_backend.common.MyComponent
import com.faizan.attendance_backend.dto.SuccessResponse
import com.faizan.attendance_backend.service.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UsersController(
    private val userService: UserService
) {

    @GetMapping
    fun getUsers(): List<User> {
        return userService.getUsers()
    }

    @PostMapping
    fun createUser(
        @Valid
        @RequestBody user: User
    ): ResponseEntity<SuccessResponse<User>> {
        userService.createUser(user)
        return ResponseEntity.status(HttpStatus.CREATED).body(
            SuccessResponse(
                message = "User created successfully",
                data = user
            )
        )
    }

    @GetMapping("/{id}")
    fun getUserById(
        @PathVariable id: Int
    ): ResponseEntity<SuccessResponse<User>> {
        val user = userService.getUserById(id)
        return ResponseEntity.ok(
            SuccessResponse(
                message = "User fetched successfully",
                data = user
            )
        )
    }

    @GetMapping("/email")
    fun emailExist(
        @RequestParam email: String
    ): Boolean {
        return userService.emailExist(email)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(
        @PathVariable id: Int
    ): Boolean {
        return userService.deleteUser(id)
    }

    @PutMapping("/{id}")
    fun updateUser(
        @PathVariable id: Int,
        @RequestBody user: User
    ): Boolean {
        return userService.updateUser(id, user)
    }

}