package com.example.spring_api.services

import com.example.spring_api.models.Product
import com.example.spring_api.repository.ProductRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class ProductService(private val productRepository: ProductRepository) {
    //    get all product
//    fun getAllProducts(): List<Product> = productRepository.findAll()

    // Get all products with pagination and search
    fun getAllProducts(searchQuery: String?, selectedCategory: Int?, pageable: Pageable): Page<Product> {
        return productRepository.findBySearchQueryAndCategory(searchQuery, selectedCategory, pageable)
    }

    // Get product by id with category details
    fun getProductByIdWithCategory(id: Int): Optional<Map<String, Any>> = productRepository.findProductWithCategory(id)

    //    create product
    fun createProduct(product: Product): Product = productRepository.save(product)

    //    update product
    fun updateProduct(id: Int, updateProduct: Product): Product {
        return if (productRepository.existsById(id)) {
            updateProduct.id = id
            productRepository.save(updateProduct)
        } else {
            throw RuntimeException("Product not found with id:$id")
        }
    }

    //    delete product
    fun deleteProdut(id: Int) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id)
        } else {
            throw RuntimeException("Product not found with id:$id")
        }
    }

}