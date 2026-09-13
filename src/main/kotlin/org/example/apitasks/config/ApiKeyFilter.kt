package org.example.apitasks.config

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class ApiKeyFilter (
    @Value("\${api.key}") private val validApiKey: String
): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val requestApiKey = request.getHeader("X-API-KEY")

        if (validApiKey == requestApiKey) {
            filterChain.doFilter(request, response)
        } else {
            response.status = HttpStatus.UNAUTHORIZED.value()
            response.writer.write("API Key invalida o ausente")
        }
    }

}