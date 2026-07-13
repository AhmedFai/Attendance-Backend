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

    fun emailExist(email : String): Boolean {
        return userRepository.existsByEmail(email)
    }

    fun findByEmail(email: String): User {
        return userRepository.findByEmail(email) ?: throw  UserNotFoundException("User with email $email not found")
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