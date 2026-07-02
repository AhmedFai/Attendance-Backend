package com.faizan.attendance_backend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class HelloController {

    @GetMapping
    fun getUsers() = "All Users"

    @PostMapping
    fun createUser() = "Created"

}