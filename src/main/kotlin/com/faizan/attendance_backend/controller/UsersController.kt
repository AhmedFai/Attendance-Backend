package com.faizan.attendance_backend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UsersController {

    @GetMapping
    fun getUsers(
        @RequestParam page: Int,
        @RequestParam size: Int
    ): String {
        return "Page = $page , size = $size"
    }

    @PostMapping
    fun createUser(
        @RequestBody user: User
    ): String {
        return "Welcome ${user.name}"
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Double) : String {
        return "User id is $id"
    }

    @GetMapping("/search")
    fun searchUser(
        @RequestParam name: String
    ): String {
        return "Searching $name"
    }

}