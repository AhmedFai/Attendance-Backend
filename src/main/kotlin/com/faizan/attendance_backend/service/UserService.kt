package com.faizan.attendance_backend.service

import com.faizan.attendance_backend.entity.User
import com.faizan.attendance_backend.exception.UserNotFoundException
import com.faizan.attendance_backend.repository.UserRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun getUsers(): List<User> {
        return userRepository.findAll(Sort.by("id"))
    }

    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    fun getUserById(id: Int): User {
        return userRepository.findById(id).orElseThrow { UserNotFoundException("User with id $id not found") }
    }

//    fun emailExist(email : String): Boolean {
//        return userRepository.isEmailExist(email)
//    }

    fun deleteUser(id: Int) {
        if (!userRepository.existsById(id)){
            throw UserNotFoundException("User with id $id not found")
        }
        userRepository.deleteById(id)
    }

    fun updateUser(
        id: Int,
        user: User
    ): User {
        val existingUser = userRepository.findById(id)
            .orElseThrow {
                UserNotFoundException("User with id $id not found")
            }
        val updatedUser = existingUser.copy(
            name = user.name,
            email = user.email,
            age = user.age
        )
        return userRepository.save(updatedUser)
    }

}