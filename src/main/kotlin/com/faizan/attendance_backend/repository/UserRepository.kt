package com.faizan.attendance_backend.repository

import com.faizan.attendance_backend.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional

interface UserRepository : JpaRepository<User, Int> {

    fun existsByEmail(
        email: String
    ): Boolean

    fun findByEmail(
        email: String
    ): User?

    fun findByAgeGreaterThan(
        age: Int
    ): List<User>

    fun findByAgeBetween(
        startAge: Int, endAge: Int
    ): List<User>

    fun findByNameContaining(
        name: String
    ): List<User>

    @Query("SELECT u FROM User u WHERE u.age > :age")
    fun findUsersOlderThan(
        age: Int
    ): List<User>

    @Query("""SELECT u FROM User u WHERE u.age > :age AND LOWER(u.name) LIKE LOWER(CONCAT('%', :name, '%')) ORDER BY u.age DESC""")
    fun searchUsers(
        age: Int,
        name: String
    ): List<User>

    @Query(
        value = """SELECT * FROM users WHERE age > :age""",
        nativeQuery = true
    )
    fun findUsersOlderThanNative(
        age: Int
    ): List<User>

    @Transactional
    @Modifying
    @Query(
        """
    UPDATE User u
    SET u.name = :name
    WHERE u.id = :id
    """
    )
    fun updateUserName(
        id: Int,
        name: String
    ): Int

    @Transactional
    @Modifying
    @Query("""
        DELETE FROM User u
        WHERE u.id = :id
    """)
    fun deletingUser(
        id: Int
    ): Int
}