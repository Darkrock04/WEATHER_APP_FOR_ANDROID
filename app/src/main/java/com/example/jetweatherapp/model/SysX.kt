package com.example.jetweatherapp.model

/**
 * SysX - Data class representing system information for current weather
 * 
 * This data class contains system-related information for current weather
 * data, including country information, sunrise/sunset times, and other
 * location-specific system data. It's used in current weather responses
 * to provide context about the location and astronomical data.
 * 
 * Purpose:
 * - Parse system data from current weather API responses
 * - Provide structured access to location system information
 * - Enable type-safe system data handling
 * - Support astronomical and location-based features
 * 
 * Key Features:
 * - Country code information
 * - Sunrise and sunset times
 * - System type and ID
 * - Nullable fields for defensive programming
 * 
 * Why nullable fields:
 * - API might not return all system data
 * - Some locations might not have complete system information
 * - Prevents crashes from missing data
 * - Allows graceful handling of incomplete responses
 */
data class SysX(
    /**
     * country - Country code where the weather data is from
     * 
     * Contains the ISO 3166-1 alpha-2 country code for the location.
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
     * - Helps distinguish locations with same names
     */
    val country: String?,
    
    /**
     * id - System identifier
     * 
     * OpenWeatherMap's internal system identifier for the weather station
     * or data source. Used for internal tracking and data validation.
     * 
     * Type: Int? (nullable)
     * - System identifier number
     * - Used for data source tracking
     * - Important for data validation
     * - Helps identify weather station
     */
    val id: Int?,
    
    /**
     * sunrise - Sunrise time as Unix timestamp
     * 
     * The time when the sun rises at the location.
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
     * The time when the sun sets at the location.
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
     * type - System type identifier
     * 
     * Indicates the type of weather system or data source.
     * Used for categorizing and understanding the data source.
     * 
     * Common Types:
     * - 1: Weather station
     * - 2: Satellite data
     * - 3: Model data
     * - Other: Various data sources
     * 
     * Type: Int? (nullable)
     * - System type identifier
     * - Used for data source categorization
     * - Important for data quality assessment
     * - Helps understand data reliability
     */
    val type: Int?
)