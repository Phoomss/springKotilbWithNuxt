package com.example.spring_api.repository

import com.example.spring_api.models.Role
import com.example.spring_api.models.RoleName
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Long> {
    fun findByRoleName(roleName: RoleName): Role?
}