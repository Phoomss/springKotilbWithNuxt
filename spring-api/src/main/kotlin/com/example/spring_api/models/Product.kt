package com.example.spring_api.models

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Entity
@Table(name = "products")
class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //setting field is primary key
    var id: Int = 0,

    @Column(name = "product_name")//set field in database
    @Size(min = 3, max = 50)// set size of database
    @NotBlank(message = "Product name is required")// set field can't is null
    val productName: String = "",

    @Column(name = "product_price") //set field in database
    @Size(min = 1, max = 10)// set size of database
    @NotBlank(message = "Product price name is required")// set field can't is null
    val productPrice: Double = 0.0,

    @Column(name = "product_quantity")//set field in database
    @Size(min = 1, max = 10)// set size of database
    @NotBlank(message = "Product quantity is required")// set field can't is null
    val productQuantity: Int = 0,

    @Column(name = "product_image")//set field in database
    val productImage: String = ""

)