package com.example.spring_api.controllers

import com.example.spring_api.models.Product
import com.example.spring_api.services.ProductService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

// and == 1 user have 2 role
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
@Tag(name = "Products", description = "APIs for managing products")
@RestController
@RequestMapping("/api/v1/products")
class ProductController(private val productService: ProductService) {
//    @Operation(summary = "Get all products", description = "Get all products from database ")
//    @GetMapping
//    fun getAllProducts() = productService.getAllProducts()

    @Operation(summary = "Get all products", description = "Get all products from database")
    @GetMapping
    fun getAllProducts(
        @RequestParam(value = "page", defaultValue = "1") page: Int,
        @RequestParam(value = "limit", defaultValue = "100") limit: Int,
        @RequestParam(value = "searchQuery", required = false) searchQuery: String?,
        @RequestParam(value = "selectedCategory", required = false) selectedCategory: Int?
    ): ResponseEntity<Map<String, Any>> {
        val pageable: Pageable = PageRequest.of(page - 1, limit)
        val productsPage: Page<Product> = productService.getAllProducts(searchQuery, selectedCategory, pageable)

        val response = mapOf(
            "total" to productsPage.totalElements,
            "products" to productsPage.content
        )

        return ResponseEntity.ok(response)
    }

    @Operation(summary = "Get product by id", description = "Get product by id from database")
    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Int): ResponseEntity<Map<String, Any>> {
        val product = productService.getProductByIdWithCategory(id)
        return product.map { ResponseEntity.ok(it) }
            .orElseGet { ResponseEntity.notFound().build() }
    }

    @Operation(summary = "Add new Product", description = "Post product from database")
    @PostMapping("/create")
    fun createProduct(@RequestBody product: Product): ResponseEntity<Product> {
        val createProduct = productService.createProduct(product)
        return ResponseEntity(createProduct, HttpStatus.CREATED)
    }

    @Operation(summary = "Update product by ID", description = "Update product by ID from database")
    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Int, @RequestBody product: Product): ResponseEntity<Product> {
        val updateProduct = productService.updateProduct(id, product)
        return ResponseEntity.ok(updateProduct)
    }

    @Operation(summary = "Delete product by ID", description = "Delete product by ID from database")
    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Int): ResponseEntity<Void> {
        productService.deleteProdut(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}