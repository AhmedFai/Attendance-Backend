package com.faizan.attendance_backend.repository

import com.faizan.attendance_backend.controller.User
import org.springframework.stereotype.Repository

@Repository
class UserRepository {

    private val users = mutableListOf(

        User(
            id = 1,
            "Faizan",
            "faizan@gmail.com",
            30
        ),

        User(
            id = 2,
            "Ali",
            "ali@gmail.com",
            28
        )

    )

    fun getUsers(): List<User> {
        return users
    }

    fun createUsers(user: User) {
        users.add(user)
    }

    fun getUserById(id: Int): User? {
        return users.find { it.id == id }
    }

    fun isEmailExist(email: String): Boolean {
       return users.any{
            it.email == email
        }
    }

    fun deleteUser(id: Int): Boolean {
        return users.removeIf {
            it.id == id
        }
    }

    fun updateUser(
        id: Int,
        user: User
    ): Boolean {
        val index = users.indexOfFirst {
         it.id == id
        }
        if (index == -1){
            return false
        }
        users[index] = user
        return true
    }

}