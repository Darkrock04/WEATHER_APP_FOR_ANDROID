package com.example.jetweatherapp.model

/**
 * WeatherDataItem - Data class representing individual forecast item
 * 
 * This data class represents a single forecast item in the 5-day weather
 * forecast. Each item contains weather data for a specific 3-hour time
 * period, including temperature, weather conditions, wind, and other
 * meteorological data.
 * 
 * Purpose:
 * - Parse individual forecast items from API responses
 * - Provide structured access to time-specific weather data
 * - Enable type-safe forecast data handling
 * - Support detailed weather forecasting and display
 * 
 * Key Features:
 * - Time-specific weather data (3-hour intervals)
 * - Comprehensive weather measurements
 * - Cloud, rain, snow, and wind data
 * - Visibility and precipitation probability
 * - Nullable fields for defensive programming
 * 
 * Why nullable fields:
 * - API might not return all data for every time period
 * - Some measurements might not be available
 * - Prevents crashes from missing data
 * - Allows graceful handling of incomplete responses
 */
data class WeatherDataItem (
    /**
     * clouds - Cloud coverage information for this time period
     * 
     * Contains cloud coverage data specific to this 3-hour forecast period.
     * Includes overall cloud coverage and precipitation-related cloud data.
     * 
     * Type: Clouds? (nullable)
     * - Cloud coverage data for this period
     * - Used for cloud condition display
     * - Important for weather pattern analysis
     * - Essential for sky condition assessment
     */
    val clouds: Clouds?,
    
    /**
     * dt - Unix timestamp of the forecast time
     * 
     * Represents the exact time for which this forecast is valid.
     * Used for time calculations and chronological ordering of forecasts.
     * 
     * Type: Long? (nullable)
     * - Unix timestamp of forecast time
     * - Used for time calculations and display
     * - Important for chronological ordering
     * - Essential for time-based features
     */
    val dt: Long?,
    
    /**
     * dt_txt - Human-readable date and time string
     * 
     * Provides a formatted date and time string for easy display.
     * Format: "YYYY-MM-DD HH:MM:SS"
     * 
     * Type: String? (nullable)
     * - Formatted date and time string
     * - Used for time display in UI
     * - Important for user-friendly time representation
     * - Essential for forecast time display
     */
    val dt_txt: String?,
    
    /**
     * main - Main weather parameters for this time period
     * 
     * Contains the core weather data including temperature, humidity,
     * pressure, and other atmospheric measurements for this specific
     * 3-hour period.
     * 
     * Type: Main? (nullable)
     * - Main weather parameters for this period
     * - Contains temperature, humidity, pressure data
     * - Most important weather information
     * - Used for primary weather display
     */
    val main: Main?,
    
    /**
     * pop - Probability of precipitation
     * 
     * Represents the probability that precipitation will occur
     * during this 3-hour period. Expressed as a decimal (0.0 to 1.0).
     * 
     * Scale:
     * - 0.0: No precipitation expected
     * - 0.1-0.3: Low probability
     * - 0.4-0.6: Moderate probability
     * - 0.7-0.9: High probability
     * - 1.0: Certain precipitation
     * 
     * Type: Double? (nullable)
     * - Precipitation probability (0.0-1.0)
     * - Used for precipitation forecast display
     * - Important for weather planning
     * - Essential for precipitation predictions
     */
    val pop: Double?,
    
    /**
     * rain - Rain precipitation data for this time period
     * 
     * Contains rain precipitation data specific to this 3-hour period.
     * Only present when rain is expected or occurring.
     * 
     * Type: Rain? (nullable)
     * - Rain precipitation data for this period
     * - Used for rain forecast display
     * - Important for precipitation planning
     * - Only present when rain is expected
     */
    val rain: Rain?,
    
    /**
     * sys - System information for this forecast item
     * 
     * Contains system-related information including part of day
     * indicator (day/night) for this specific time period.
     * 
     * Type: Sys? (nullable)
     * - System information for this period
     * - Contains part of day indicator
     * - Used for day/night determination
     * - Important for weather icon selection
     */
    val sys: Sys?,
    
    /**
     * visibility - Visibility distance for this time period
     * 
     * Indicates how far one can see clearly during this 3-hour period.
     * Useful for determining fog, haze, or clear conditions.
     * 
     * Type: Long? (nullable)
     * - Visibility distance in meters
     * - Used for visibility display
     * - Important for weather condition assessment
     * - Helps determine air quality and clarity
     */
    val visibility: Long?,
    
    /**
     * weather - Weather condition descriptions for this time period
     * 
     * Contains detailed weather condition information including
     * description, icon code, and main weather type for this
     * specific 3-hour period.
     * 
     * Type: List<Weather>? (nullable)
     * - Array of weather condition objects
     * - Contains description, icon, main condition
     * - Used for weather icons and descriptions
     * - Essential for weather condition display
     */
    val weather: List<Weather>?,
    
    /**
     * wind - Wind information for this time period
     * 
     * Contains wind data including speed, direction, and gust
     * information specific to this 3-hour period.
     * 
     * Type: Wind? (nullable)
     * - Wind data for this period
     * - Contains wind speed and direction
     * - Used for wind display and calculations
     * - Important for outdoor activity planning
     */
    val wind: Wind?
)