package org.example.apitasks.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val apiKeyFilter: ApiKeyFilter
) {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() } // Desactivar CSRF para APIs REST
            .authorizeHttpRequests { it.anyRequest().permitAll() } // Permitir que las peticiones lleguen a tu filtro
            .addFilterBefore(apiKeyFilter, UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }
}