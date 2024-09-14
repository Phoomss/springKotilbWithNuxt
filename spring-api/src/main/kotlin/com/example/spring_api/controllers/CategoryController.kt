package com.example.spring_api.controllers

import com.example.spring_api.models.Category
import com.example.spring_api.services.CategoryService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

// set rights
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER') or hasAuthority('USER')")
@Tag(name = "Categories", description = "APIs for managing categories")
@RestController
@RequestMapping("/api/v1/categories")
class CategoryController(private val categoryService: CategoryService) {
    @Operation(summary = "Get all categories", description = "Get all categories")
    @GetMapping
    fun getCategories(): ResponseEntity<List<Category>> {
        val categories = categoryService.getAllCategories()
        return ResponseEntity.ok(categories)
    }

    @Operation(summary = "Get categories by ID", description = "Get categories by ID from database")
    @GetMapping("/{id}")
    fun getCategory(@PathVariable id: Int): ResponseEntity<Category> {
        val category = categoryService.getCategoryById(id)
        return if (category.isPresent) {
            ResponseEntity.ok(category.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @Operation(summary = "Add new category", description = "Add new category to database")
    @PostMapping
    fun addCategory(@RequestBody category: Category): ResponseEntity<Category> {
        val savedCategory = categoryService.addCategory(category)
        return ResponseEntity.ok(savedCategory)
    }

    @Operation(summary = "Update category by ID", description = "Update category by ID from database")
    @PutMapping("/{id}")
    fun updateCategory(@PathVariable id: Int, @RequestBody category: Category): ResponseEntity<Category> {
        val updatedCategory = categoryService.updateCategory(id, category)
        return if (updatedCategory.isPresent) {
            ResponseEntity.ok(updatedCategory.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @Operation(summary = "Delete category by ID", description = "Delete category by ID from database")
    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: Int): ResponseEntity<Category> {
        val deletedCategory = categoryService.deleteCategory(id)
        return if (deletedCategory.isPresent) {
            ResponseEntity.ok(deletedCategory.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

}