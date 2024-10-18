package com.example.spring_api.repository

import com.example.spring_api.dto.ProductCategoryDTO
import com.example.spring_api.models.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface ProductRepository : JpaRepository<Product, Int> {

    @Query(
        """
        SELECT new com.example.spring_api.dto.ProductCategoryDTO(p.id, p.productName, p.unitPrice, p.unitInStock, p.productPicture, c.id, c.categoryName, p.createdDate, p.modifiedDate)
        FROM Product p JOIN Category c ON p.categoryId = c.id
        WHERE (:searchQuery IS NULL OR :searchQuery = '' OR LOWER(p.productName) LIKE LOWER(CONCAT('%', :searchQuery, '%')))
          AND (:selectedCategory IS NULL OR p.categoryId = :selectedCategory)
        """
    )
    fun findBySearchQueryAndCategory(
        @Param("searchQuery") searchQuery: String?,
        @Param("selectedCategory") selectedCategory: Int?,
        pageable: Pageable
    ): Page<ProductCategoryDTO>

    @Query(
        """
        SELECT new com.example.spring_api.dto.ProductCategoryDTO(p.id, p.productName, p.unitPrice, p.unitInStock, p.productPicture, c.id, c.categoryName, p.createdDate, p.modifiedDate)
        FROM Product p JOIN Category c ON p.categoryId = c.id
        WHERE p.id = :id
        """
    )
    fun findProductWithCategory(@Param("id") id: Int): Optional<ProductCategoryDTO>
}
