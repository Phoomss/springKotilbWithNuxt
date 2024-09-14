package com.example.spring_api.controllers

import com.example.spring_api.models.RegisterModel
import com.example.spring_api.models.ResponseModel
import com.example.spring_api.services.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Authenticate", description = "Authenticate API")
@RestController
@RequestMapping("/api/authenticate")
class UserController(
    private val userService: UserService
) {
    @Operation(summary = "Register user", description = "Register user to database")
    @PostMapping("/register-user")
    fun registerUser(@RequestBody model: RegisterModel): ResponseEntity<ResponseModel> {
        return try {
            val user = userService.registerUser(model.username, model.email, model.password)
            ResponseEntity.ok(ResponseModel("Success", "User registered successfully"))
        } catch (e: IllegalStateException) {
            ResponseEntity.badRequest().body(ResponseModel("Error", e.message ?: "Registration failed"))
        } catch (e: IllegalStateException) {
            ResponseEntity.internalServerError()
                .body(ResponseModel("Error", e.message ?: "Registration failed due to system configuration"))
        } catch (e: Exception) {
            ResponseEntity.internalServerError().body(ResponseModel("Error", "User creation failed: ${e.message}"))
        }
    }

    @Operation(summary = "Register manager", description = "Register manager to database")
    @PostMapping("/register-manager")
    fun registerManager(@RequestBody model: RegisterModel): ResponseEntity<ResponseModel> {
        return try {
            val user = userService.registerManager(model.username, model.email, model.password)
            ResponseEntity.ok(ResponseModel("Success", "Manager registered successfully"))
        } catch (e: IllegalStateException) {
            ResponseEntity.badRequest().body(ResponseModel("Error", e.message ?: "Registration failed"))
        } catch (e: IllegalStateException) {
            ResponseEntity.internalServerError()
                .body(ResponseModel("Error", e.message ?: "Registration failed due to system configuration"))
        } catch (e: Exception) {
            ResponseEntity.internalServerError().body(ResponseModel("Error", "Manager creation failed: ${e.message}"))
        }
    }

    @Operation(summary = "Register admin", description = "Register admin to database")
    @PostMapping("/register-admin")
    fun registerAdmin(@RequestBody model: RegisterModel): ResponseEntity<ResponseModel> {
        return try {
            val user = userService.registerAdmin(model.username, model.email, model.password)
            ResponseEntity.ok(ResponseModel("Success", "Admin registered successfully"))
        } catch (e: IllegalStateException) {
            ResponseEntity.badRequest().body(ResponseModel("Error", e.message ?: "Registration failed"))
        } catch (e: IllegalStateException) {
            ResponseEntity.internalServerError()
                .body(ResponseModel("Error", e.message ?: "Registration failed due to system configuration"))
        } catch (e: Exception) {
            ResponseEntity.internalServerError().body(ResponseModel("Error", "Admin creation failed: ${e.message}"))
        }
    }
}