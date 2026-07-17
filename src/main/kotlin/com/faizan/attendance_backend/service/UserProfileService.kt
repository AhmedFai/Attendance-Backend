package com.faizan.attendance_backend.service

import com.faizan.attendance_backend.entity.User
import com.faizan.attendance_backend.entity.UserProfile
import com.faizan.attendance_backend.repository.UserProfileRepository
import org.springframework.stereotype.Service

@Service
class UserProfileService(
    private val userProfileRepository: UserProfileRepository
) {

    fun createProfile(user: User): UserProfile {

        val profile = UserProfile(
            bio = "",
            address = "",
            dob = null,
            user = user
        )

        return userProfileRepository.save(profile)
    }
}