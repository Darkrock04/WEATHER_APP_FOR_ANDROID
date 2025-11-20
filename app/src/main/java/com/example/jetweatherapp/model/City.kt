package com.example.jetweatherapp.model

/**
 * City - Data class representing city information
 * 
 * This data class contains comprehensive information about a city
 * including its location, demographics, and astronomical data.
 * It's used in weather forecast responses to provide context
 * about the location for which weather data is provided.
 * 
 * Purpose:
 * - Parse city information from API responses
 * - Provide structured access to location and demographic data
 * - Enable type-safe city data handling
 * - Support location-based features and display
 * 
 * Key Features:
 * - Geographic coordinates (latitude, longitude)
 * - City name and country information
 * - Population data
 * - Sunrise and sunset times
 * - Timezone information
 * - Unique city identifier
 * 
 * Why nullable fields:
 * - API might not return all fields in every response
 * - Some data might not be available for certain cities
 * - Prevents crashes from missing data
 * - Allows graceful handling of incomplete responses
 */
data class City(
    /**
     * coord - Geographic coordinates of the city
     * 
     * Contains the latitude and longitude of the city center.
     * Essential for mapping, location services, and accurate
     * weather data retrieval.
     * 
     * Type: Coord? (nullable)
     * - Contains latitude and longitude
     * - Used for mapping and location services
     * - Required for accurate weather data
     * - Essential for geographic calculations
     */
    val coord: Coord?,
    
    /**
     * country - Country code where the city is located
     * 
     * Contains the ISO 3166-1 alpha-2 country code.
     * Used for country identification and display purposes.
     * 
     * Examples:
     * - "US": United States
     * - "GB": United Kingdom
     * - "DE": Germany
     * - "FR": France
     * - "JP": Japan
     * 
     * Type: String? (nullable)
     * - ISO country code (2 letters)
     * - Used for country identification
     * - Important for internationalization
     * - Helps distinguish cities with same names
     */
    val country: String?,
    
    /**
     * id - Unique identifier for the city
     * 
     * OpenWeatherMap's unique identifier for the city.
     * Useful for caching, avoiding duplicate API calls,
     * and programmatic city identification.
     * 
     * Type: Int? (nullable)
     * - Unique city identifier
     * - Used for caching weather data
     * - Helps avoid duplicate API requests
     * - Enables programmatic city handling
     */
    val id: Int?,
    
    /**
     * name - Name of the city
     * 
     * The human-readable name of the city.
     * Used for display purposes in the UI and user identification.
     * 
     * Type: String? (nullable)
     * - City name for display
     * - Used in UI headers and location display
     * - Essential for user identification
     * - Primary city identifier for users
     */
    val name: String?,
    
    /**
     * population - City population count
     * 
     * The approximate population of the city.
     * Useful for demographic analysis and city size determination.
     * 
     * Type: Int? (nullable)
     * - Population count
     * - Used for demographic analysis
     * - Helps determine city size
     * - Useful for city comparison
     */
    val population: Int?,
    
    /**
     * sunrise - Sunrise time as Unix timestamp
     * 
     * The time when the sun rises in the city.
     * Used for day/night calculations and astronomical features.
     * 
     * Type: Int? (nullable)
     * - Unix timestamp of sunrise
     * - Used for day/night calculations
     * - Important for astronomical features
     * - Helps determine daylight hours
     */
    val sunrise: Int?,
    
    /**
     * sunset - Sunset time as Unix timestamp
     * 
     * The time when the sun sets in the city.
     * Used for day/night calculations and astronomical features.
     * 
     * Type: Int? (nullable)
     * - Unix timestamp of sunset
     * - Used for day/night calculations
     * - Important for astronomical features
     * - Helps determine daylight hours
     */
    val sunset: Int?,
    
    /**
     * timezone - Timezone offset in seconds
     * 
     * Indicates the timezone offset from UTC for the city.
     * Used for accurate time calculations and display.
     * 
     * Type: Int? (nullable)
     * - Timezone offset in seconds from UTC
     * - Used for local time calculations
     * - Important for accurate time display
     * - Essential for time-based features
     */
    val timezone: Int?
)