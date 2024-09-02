package com.example.spring_api.repository

import com.example.spring_api.models.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Int> {
}