package com.faizan.attendance_backend.service

import com.faizan.attendance_backend.dto.CreateUserRequest
import com.faizan.attendance_backend.dto.UpdateUserRequest
import com.faizan.attendance_backend.dto.UserResponse
import com.faizan.attendance_backend.entity.User
import com.faizan.attendance_backend.exception.UserNotFoundException
import com.faizan.attendance_backend.mapper.toEntity
import com.faizan.attendance_backend.mapper.toResponse
import com.faizan.attendance_backend.repository.UserRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun getUsers(): List<UserResponse> {
        val users = userRepository.findAll(Sort.by("id"))
        return users.map { user -> user.toResponse() }
    }

    fun createUser(request: CreateUserRequest): UserResponse {
        val user = request.toEntity()
        val savedUser = userRepository.save(user)
        return savedUser.toResponse()
    }

    fun getUserById(id: Int): UserResponse {
        val user = userRepository.findById(id).orElseThrow { UserNotFoundException("User with id $id not found") }
        return user.toResponse()
    }

    fun emailExist(email : String): Boolean {
        return userRepository.existsByEmail(email)
    }

    fun findByEmail(email: String): UserResponse {
        val user = userRepository.findByEmail(email) ?: throw  UserNotFoundException("User with email $email not found")
        return user.toResponse()
    }

    fun findByAgeGreaterThan(age: Int): List<User> {
        return userRepository.findByAgeGreaterThan(age)
    }

    fun findByAgeBetween(startAge: Int, endAge: Int): List<User> {
        return userRepository.findByAgeBetween(startAge, endAge);
    }

    fun findByNameContaining(name: String): List<User> {
        return userRepository.findByNameContaining(name)
    }

    fun findUsersOlderThan(age: Int): List<User> {
        return userRepository.findUsersOlderThan(age)
    }

    fun searchUsers(age: Int, name: String): List<User> {
        return userRepository.searchUsers(age, name)
    }

    fun findUsersOlderThanNative(age: Int): List<User> {
        return userRepository.findUsersOlderThanNative(age)
    }

    fun updateUserName(
        id: Int,
        name: String
    ): User {
        val updatedRows = userRepository.updateUserName(id, name)
        if (updatedRows == 0){
            throw UserNotFoundException("User with id $id not found")
        }
        return userRepository.findById(id).orElseThrow {
            UserNotFoundException("User with id $id not found")
        }
    }

    fun deletingUser(id: Int): Int {
        val updatedRows = userRepository.deletingUser(id)
        if (updatedRows == 0){
            throw UserNotFoundException("User with id $id not found")
        }
        return userRepository.deletingUser(id)
    }

    fun deleteUser(id: Int) {
        if (!userRepository.existsById(id)){
            throw UserNotFoundException("User with id $id not found")
        }
        userRepository.deleteById(id)
    }

    fun updateUser(
        id: Int,
        request: UpdateUserRequest
    ): UserResponse {
        val existingUser = userRepository.findById(id)
            .orElseThrow {
                UserNotFoundException("User with id $id not found")
            }
        val updatedUser = existingUser.copy(
            name = request.name,
            age = request.age
        )
        val savedUser = userRepository.save(updatedUser)
        return savedUser.toResponse()
    }

}