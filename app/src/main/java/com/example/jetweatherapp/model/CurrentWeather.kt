package com.example.jetweatherapp.model

/**
 * CurrentWeather - Data class representing current weather conditions
 * 
 * This data class maps to the JSON response from OpenWeatherMap's current weather API.
 * It contains comprehensive weather information for a specific location at the current time.
 * 
 * API Endpoint: /data/2.5/weather
 * 
 * Purpose:
 * - Parse JSON response from current weather API
 * - Provide structured access to real-time weather data
 * - Enable type-safe data handling in the app
 * - Support reactive UI updates with current weather information
 * 
 * Key Features:
 * - Temperature data (current, feels like, min/max)
 * - Weather conditions (description, icon, main condition)
 * - Atmospheric data (humidity, pressure, visibility)
 * - Wind information (speed, direction)
 * - Location details (coordinates, city name, timezone)
 * - Precipitation data (rain, snow)
 * 
 * Why nullable fields:
 * - API might not return all fields in every response
 * - Some data might not be available for certain locations
 * - Prevents crashes from missing data
 * - Allows graceful handling of incomplete responses
 */
data class CurrentWeather(
    /**
     * base - Internal parameter used by OpenWeatherMap
     * 
     * This field is used internally by the API and typically contains "stations".
     * It's not commonly used in client applications but is included for completeness.
     * 
     * Type: String? (nullable)
     * - Usually "stations" for ground-based weather stations
     * - Not critical for app functionality
     */
    val base: String?,
    
    /**
     * clouds - Cloud coverage information
     * 
     * Contains data about cloud coverage percentage.
     * Useful for determining sky conditions and weather patterns.
     * 
     * Type: Clouds? (nullable)
     * - Contains cloud coverage percentage
     * - Used for weather condition display
     * - Helps determine if it's sunny, partly cloudy, or overcast
     */
    val clouds: Clouds?,
    
    /**
     * cod - Response code from the API
     * 
     * Indicates the status of the API request.
     * Common values:
     * - 200: Success
     * - 404: City not found
     * - 401: Invalid API key
     * - 429: Rate limit exceeded
     * 
     * Type: Int? (nullable)
     * - Used for error handling and debugging
     * - Helps identify API issues
     * - Critical for determining if request was successful
     */
    val cod: Int?,
    
    /**
     * coord - Geographic coordinates of the location
     * 
     * Contains latitude and longitude of the weather location.
     * Essential for mapping and location-based features.
     * 
     * Type: Coord? (nullable)
     * - Contains latitude and longitude
     * - Used for mapping and location services
     * - Required for accurate weather data
     */
    val coord: Coord?,
    
    /**
     * dt - Unix timestamp of when the weather data was calculated
     * 
     * Represents the time when the weather data was last updated.
     * Used to determine data freshness and for time-based calculations.
     * 
     * Type: Int? (nullable)
     * - Unix timestamp (seconds since epoch)
     * - Used for data freshness checks
     * - Helps determine when weather was last updated
     */
    val dt: Int?,
    
    /**
     * id - Unique identifier for the city
     * 
     * OpenWeatherMap's unique city ID for the location.
     * Useful for caching and avoiding duplicate API calls.
     * 
     * Type: Int? (nullable)
     * - Unique identifier for the city
     * - Used for caching weather data
     * - Helps avoid duplicate API requests
     */
    val id: Int?,
    
    /**
     * main - Main weather parameters
     * 
     * Contains the core weather data including temperature, humidity,
     * pressure, and other atmospheric measurements.
     * 
     * Type: Main? (nullable)
     * - Contains temperature, humidity, pressure data
     * - Most important weather information
     * - Used for primary weather display
     */
    val main: Main?,
    
    /**
     * name - Name of the city/location
     * 
     * The human-readable name of the city for which weather data is provided.
     * Used for display purposes in the UI.
     * 
     * Type: String? (nullable)
     * - City name for display
     * - Used in UI headers and location display
     * - Essential for user identification of location
     */
    val name: String?,
    
    /**
     * sys - System information about the location
     * 
     * Contains sunrise/sunset times, country code, and other
     * location-specific system information.
     * 
     * Type: SysX? (nullable)
     * - Contains sunrise/sunset times
     * - Includes country information
     * - Used for day/night calculations
     */
    val sys: SysX?,
    
    /**
     * timezone - Timezone offset in seconds
     * 
     * Indicates the timezone offset from UTC for the location.
     * Used for accurate time calculations and display.
     * 
     * Type: Int? (nullable)
     * - Timezone offset in seconds from UTC
     * - Used for local time calculations
     * - Important for accurate time display
     */
    val timezone: Int?,
    
    /**
     * visibility - Visibility distance in meters
     * 
     * Indicates how far one can see clearly in the current conditions.
     * Useful for determining fog, haze, or clear conditions.
     * 
     * Type: Int? (nullable)
     * - Visibility distance in meters
     * - Used for weather condition assessment
     * - Helps determine air quality and clarity
     */
    val visibility: Int?,
    
    /**
     * weather - Array of weather condition descriptions
     * 
     * Contains detailed weather condition information including
     * description, icon code, and main weather type.
     * 
     * Type: List<Weather>? (nullable)
     * - Array of weather condition objects
     * - Contains description, icon, main condition
     * - Used for weather icons and descriptions
     */
    val weather: List<Weather>?,
    
    /**
     * wind - Wind information
     * 
     * Contains wind speed, direction, and gust information.
     * Important for weather forecasting and outdoor activity planning.
     * 
     * Type: Wind? (nullable)
     * - Contains wind speed and direction
     * - Used for wind display and calculations
     * - Important for outdoor activity planning
     */
    val wind: Wind?,
    
    /**
     * rain - Rain precipitation data
     * 
     * Contains information about current rain conditions.
     * Only present when rain is occurring or expected.
     * 
     * Type: Rain? (nullable)
     * - Contains rain volume data
     * - Only present when raining
     * - Used for precipitation display
     */
    val rain: Rain?,
    
    /**
     * snow - Snow precipitation data
     * 
     * Contains information about current snow conditions.
     * Only present when snow is occurring or expected.
     * 
     * Type: Snow? (nullable)
     * - Contains snow volume data
     * - Only present when snowing
     * - Used for precipitation display
     */
    val snow: Snow?
)