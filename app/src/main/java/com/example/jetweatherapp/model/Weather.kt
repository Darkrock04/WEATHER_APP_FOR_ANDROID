package com.example.jetweatherapp.model

/**
 * Weather - Data class representing weather condition information
 * 
 * This data class contains detailed information about weather conditions
 * including description, icon code, and main weather type. It's used in both
 * current weather and forecast data from OpenWeatherMap API.
 * 
 * Purpose:
 * - Parse weather condition data from API responses
 * - Provide structured access to weather descriptions and icons
 * - Enable type-safe weather condition handling
 * - Support weather icon display and condition descriptions
 * 
 * Key Features:
 * - Human-readable weather description
 * - Icon code for weather visualization
 * - Unique weather condition ID
 * - Main weather category classification
 * 
 * Why nullable fields:
 * - API might not return all fields in every response
 * - Some weather conditions might not have all data
 * - Prevents crashes from missing data
 * - Allows graceful handling of incomplete responses
 */
data class Weather(
    /**
     * description - Human-readable weather description
     * 
     * Provides a detailed description of current weather conditions.
     * Examples: "clear sky", "few clouds", "scattered clouds", "broken clouds",
     * "shower rain", "rain", "thunderstorm", "snow", "mist", "fog"
     * 
     * Type: String? (nullable)
     * - Detailed weather condition description
     * - Used for weather condition display in UI
     * - Provides user-friendly weather information
     * - Essential for accessibility and user understanding
     */
    val description: String?,
    
    /**
     * icon - Weather icon code for visualization
     * 
     * Contains a code that corresponds to a specific weather icon.
     * Used to display appropriate weather icons in the UI.
     * 
     * Icon Code Format: "XXd" or "XXn"
     * - XX: Two-digit number representing weather condition
     * - d: Daytime icon
     * - n: Nighttime icon
     * 
     * Common Icon Codes:
     * - "01d/01n": Clear sky
     * - "02d/02n": Few clouds
     * - "03d/03n": Scattered clouds
     * - "04d/04n": Broken clouds
     * - "09d/09n": Shower rain
     * - "10d/10n": Rain
     * - "11d/11n": Thunderstorm
     * - "13d/13n": Snow
     * - "50d/50n": Mist
     * 
     * Type: String? (nullable)
     * - Icon code for weather visualization
     * - Used to load appropriate weather icons
     * - Enables dynamic weather icon display
     * - Critical for visual weather representation
     */
    val icon: String?,
    
    /**
     * id - Unique weather condition identifier
     * 
     * OpenWeatherMap's unique identifier for the weather condition.
     * Useful for caching, analytics, and programmatic weather condition handling.
     * 
     * Common Weather IDs:
     * - 200-232: Thunderstorm
     * - 300-321: Drizzle
     * - 500-531: Rain
     * - 600-622: Snow
     * - 701-781: Atmosphere (mist, fog, etc.)
     * - 800: Clear sky
     * - 801-804: Clouds
     * 
     * Type: Int? (nullable)
     * - Unique weather condition identifier
     * - Used for weather condition categorization
     * - Enables programmatic weather handling
     * - Useful for analytics and caching
     */
    val id: Int?,
    
    /**
     * main - Main weather category
     * 
     * Provides the primary weather category classification.
     * This is a broader classification than the detailed description.
     * 
     * Main Categories:
     * - "Clear": Clear sky conditions
     * - "Clouds": Cloudy conditions
     * - "Rain": Rainy conditions
     * - "Drizzle": Light rain conditions
     * - "Thunderstorm": Storm conditions
     * - "Snow": Snowy conditions
     * - "Mist": Foggy/hazy conditions
     * - "Fog": Foggy conditions
     * - "Haze": Hazy conditions
     * - "Dust": Dusty conditions
     * - "Sand": Sandy conditions
     * - "Ash": Ash conditions
     * - "Squall": Squall conditions
     * - "Tornado": Tornado conditions
     * 
     * Type: String? (nullable)
     * - Main weather category classification
     * - Used for weather condition grouping
     * - Enables weather-based UI theming
     * - Useful for weather condition filtering
     */
    val main: String?
)