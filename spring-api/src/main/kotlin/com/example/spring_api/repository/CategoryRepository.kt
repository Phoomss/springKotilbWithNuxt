package com.example.spring_api.repository

import com.example.spring_api.models.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category,Int> {
}