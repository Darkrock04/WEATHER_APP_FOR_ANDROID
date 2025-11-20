package com.example.jetweatherapp.utils

/**
 * Constants - Utility object containing application-wide constants
 * 
 * This object holds all the constant values used throughout the application.
 * Using an object ensures these values are accessible globally and are immutable.
 * 
 * Purpose:
 * - Centralize configuration values
 * - Avoid magic strings/numbers scattered throughout code
 * - Make it easy to update values in one place
 * - Improve code maintainability and readability
 * 
 * Why use object instead of class:
 * - Objects are singletons in Kotlin
 * - No need to instantiate
 * - Memory efficient
 * - Thread-safe by default
 */
object Constants {
    /**
     * BASE_URL - Base URL for the OpenWeatherMap API
     * 
     * This is the root URL for all API calls to OpenWeatherMap service.
     * All weather data requests will be made to endpoints under this URL.
     * 
     * Why it's needed:
     * - OpenWeatherMap provides weather data through REST API
     * - All endpoints share the same base URL
     * - Makes it easy to change API provider if needed
     * - Follows REST API best practices
     * 
     * Usage:
     * - Combined with specific endpoint paths
     * - Used by Retrofit for HTTP client configuration
     */
    const val BASE_URL: String = "https://api.openweathermap.org/"
    
    /**
     * API_KEY - Authentication key for OpenWeatherMap API
     * 
     * This is the API key required to authenticate requests to OpenWeatherMap.
     * Without this key, API requests will be rejected with 401 Unauthorized error.
     * 
     * Security Note:
     * - In production apps, this should be stored securely
     * - Consider using Android Keystore or environment variables
     * - Never commit real API keys to version control
     * 
     * How to get API key:
     * 1. Sign up at openweathermap.org
     * 2. Go to API keys section
     * 3. Generate a new API key
     * 4. Replace this placeholder with your actual key
     * 
     * Rate Limits:
     * - Free tier: 1000 calls/day, 60 calls/minute
     * - Paid tiers offer higher limits
     */
    const val API_KEY: String = "570a99bbd6966e1146694f42a1b1ab2f"
}