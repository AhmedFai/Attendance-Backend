package com.faizan.attendance_backend.service

import com.faizan.attendance_backend.controller.User
import com.faizan.attendance_backend.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun getUsers(): List<User>  {
        return userRepository.getUsers()
    }

    fun createUser(user: User) {
        userRepository.createUsers(user)
    }

    fun getUserById(id: Int): User? {
        return userRepository.getUserById(id)
    }

    fun emailExist(email : String): Boolean {
        return userRepository.isEmailExist(email)
    }

    fun deleteUser(id: Int): Boolean {
        return userRepository.deleteUser(id)
    }

    fun updateUser(
        id: Int,
        user: User
    ): Boolean {
        return userRepository.updateUser(id, user)
    }

}