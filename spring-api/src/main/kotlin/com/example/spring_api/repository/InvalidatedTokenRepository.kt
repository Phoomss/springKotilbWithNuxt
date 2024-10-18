package com.example.spring_api.repository

import com.example.spring_api.models.InvalidatedToken
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface InvalidatedTokenRepository : JpaRepository<InvalidatedToken, Long> {
    fun findByToken(token: String): InvalidatedToken?
    fun deleteByExpirationTimeBefore(now: LocalDateTime)
}