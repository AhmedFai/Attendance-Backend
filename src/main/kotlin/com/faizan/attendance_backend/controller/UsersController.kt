package com.faizan.attendance_backend.controller

import com.faizan.attendance_backend.dto.CreateUserRequest
import com.faizan.attendance_backend.dto.SuccessResponse
import com.faizan.attendance_backend.dto.UpdateUserRequest
import com.faizan.attendance_backend.dto.UserDetailsResponse
import com.faizan.attendance_backend.dto.UserProfileResponse
import com.faizan.attendance_backend.dto.UserResponse
import com.faizan.attendance_backend.entity.User
import com.faizan.attendance_backend.mapper.toEntity
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
    fun getUsers(): ResponseEntity<SuccessResponse<List<UserResponse>>> {
        val users = userService.getUsers()
        return ResponseEntity.ok(
            SuccessResponse(
                message = "User fetched successfully",
                data = users
            )
        )
    }

    @GetMapping("/{id}/details")
    fun getUserDetails(
        @PathVariable id: Int
    ): ResponseEntity<SuccessResponse<UserDetailsResponse>> {
        val details = userService.getUserDetails(id)
        return ResponseEntity.ok(
            SuccessResponse(
                message = "Details are as follows",
                data = details
            )
        )
    }

    @GetMapping("/{id}/profile")
    fun getUserProfile(
        @PathVariable id: Int
    ): ResponseEntity<SuccessResponse<UserProfileResponse>> {

        val profile = userService.getUserProfile(id)

        return ResponseEntity.ok(
            SuccessResponse(
                message = "Profile fetched successfully",
                data = profile
            )
        )
    }

    @PostMapping
    fun createUser(
        @Valid
        @RequestBody request: CreateUserRequest
    ): ResponseEntity<SuccessResponse<UserResponse>> {
        val savedUser = userService.createUser(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(
            SuccessResponse(
                message = "User created successfully",
                data = savedUser
            )
        )
    }

    @PostMapping("/register")
    fun registerUser(
        @Valid
        @RequestBody request: CreateUserRequest
    ): ResponseEntity<SuccessResponse<UserResponse>> {

        val user = userService.registerUser(request)

        return ResponseEntity.status(HttpStatus.CREATED).body(
            SuccessResponse(
                message = "User registered successfully",
                data = user
            )
        )
    }

    @GetMapping("/{id}")
    fun getUserById(
        @PathVariable id: Int
    ): ResponseEntity<SuccessResponse<UserResponse>> {
        val user = userService.getUserById(id)
        return ResponseEntity.ok(
            SuccessResponse(
                message = "User fetched successfully",
                data = user
            )
        )
    }

//    @GetMapping("/email")
//    fun emailExist(
//        @RequestParam email: String
//    ): Boolean {
//        return userService.emailExist(email)
//    }

    @GetMapping("/email")
    fun findByEmail(
        @RequestParam email: String
    ): ResponseEntity<SuccessResponse<UserResponse>> {
        val user = userService.findByEmail(email)
        return ResponseEntity.ok(
            SuccessResponse(
                message = "User fetched successfully.",
                data = user
            )
        )
    }

    @GetMapping("/age")
    fun findByAgeGreaterThan(
        @RequestParam age: Int
    ): ResponseEntity<SuccessResponse<List<User>>> {
        val users = userService.findByAgeGreaterThan(age)
        return ResponseEntity.ok(
            SuccessResponse(
                message = "Users are as follows:",
                data = users
            )
        )
    }

    @GetMapping("/ageBetween")
    fun findByAgeBetween(
        @RequestParam startAge : Int,
        @RequestParam endAge : Int
    ): ResponseEntity<SuccessResponse<List<User>>> {
        val users = userService.findByAgeBetween(startAge, endAge)
        return ResponseEntity.ok(
            SuccessResponse(
                message = "Filtered users",
                data = users
            )
        )
    }

    @GetMapping("/search")
    fun findByNameContaining(
        @RequestParam name: String
    ): ResponseEntity<SuccessResponse<List<User>>> {
        val users = userService.findByNameContaining(name)
        return ResponseEntity.ok(
            SuccessResponse(
                message = "Here are the search users",
                data = users
            )
        )
    }

    @GetMapping("/ageOlder")
    fun findUsersOlderThan(
        @RequestParam age: Int
    ): ResponseEntity<SuccessResponse<List<User>>> {
        val user  = userService.findUsersOlderThan(age)
        return ResponseEntity.ok(
            SuccessResponse(
                message = "Older users",
                data = user
            )
        )
    }

    @GetMapping("/search-custom")
    fun searchUsers(
        @RequestParam age: Int,
        @RequestParam name: String
    ): ResponseEntity<SuccessResponse<List<User>>> {
        val users = userService.searchUsers(age, name)
        return ResponseEntity.ok(
            SuccessResponse(
                message = "Custom search users",
                data = users
            )
        )
    }

    @GetMapping("/get-older")
    fun findUsersOlderThanNative(
        @RequestParam age: Int
    ): ResponseEntity<SuccessResponse<List<User>>> {
        val users = userService.findUsersOlderThanNative(age)
        return ResponseEntity.ok(
            SuccessResponse(
                message = "Older people",
                data = users
            )
        )
    }

    @PutMapping("/update-name")
    fun updateUserName(
        @RequestParam id: Int,
        @RequestParam name: String
    ): ResponseEntity<SuccessResponse<User>> {
        val user = userService.updateUserName(id, name)
        return ResponseEntity.ok(
            SuccessResponse(
                message = "User updated successfully",
                data = user
            )
        )
    }

    @DeleteMapping("/delete-user")
    fun deletingUser(
       @RequestParam id: Int
    ): Int {
        return userService.deletingUser(id)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(
        @PathVariable id: Int
    ): ResponseEntity<SuccessResponse<Nothing?>> {
        userService.deleteUser(id)
        return ResponseEntity.ok(
            SuccessResponse(
                message = "User deleted successfully",
                data = null
            )
        )
    }

    @PutMapping("/{id}")
    fun updateUser(
        @PathVariable id: Int,
        @Valid
        @RequestBody userRequest: UpdateUserRequest
    ): ResponseEntity<SuccessResponse<UserResponse>> {
        val updatedUser = userService.updateUser(id, userRequest)
        return ResponseEntity.ok(
            SuccessResponse(
                message = "User updated successfully",
                data = updatedUser
            )
        )
    }

}