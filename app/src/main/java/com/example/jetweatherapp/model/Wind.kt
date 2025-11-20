package com.example.jetweatherapp.model

/**
 * Wind - Data class representing wind information
 * 
 * This data class contains comprehensive wind data including speed,
 * direction, and gust information. It's used in weather responses
 * to provide detailed wind conditions for a specific location.
 * 
 * Purpose:
 * - Parse wind data from API responses
 * - Provide structured access to wind measurements
 * - Enable type-safe wind data handling
 * - Support wind-based calculations and display
 * 
 * Key Features:
 * - Wind speed measurement
 * - Wind direction (degrees)
 * - Wind gust information
 * - Nullable fields for defensive programming
 * 
 * Why nullable fields:
 * - API might not return all wind data
 * - Some locations might not have wind measurements
 * - Prevents crashes from missing data
 * - Allows graceful handling of incomplete responses
 */
data class Wind(
    /**
     * deg - Wind direction in degrees
     * 
     * Represents the direction from which the wind is blowing.
     * Measured in degrees from true north (0°).
     * 
     * Direction Reference:
     * - 0° or 360°: North
     * - 90°: East
     * - 180°: South
     * - 270°: West
     * 
     * Common Directions:
     * - 0-22.5°: North
     * - 22.5-67.5°: Northeast
     * - 67.5-112.5°: East
     * - 112.5-157.5°: Southeast
     * - 157.5-202.5°: South
     * - 202.5-247.5°: Southwest
     * - 247.5-292.5°: West
     * - 292.5-337.5°: Northwest
     * - 337.5-360°: North
     * 
     * Type: Int? (nullable)
     * - Wind direction in degrees (0-360)
     * - Used for wind direction display
     * - Important for weather pattern analysis
     * - Essential for wind-based calculations
     */
    val deg: Int?,
    
    /**
     * gust - Wind gust speed
     * 
     * Represents the maximum wind speed during gusts.
     * Wind gusts are sudden, brief increases in wind speed.
     * 
     * Units: m/s (meters per second)
     * 
     * Gust Characteristics:
     * - Short duration (seconds to minutes)
     * - Higher speed than sustained wind
     * - Can be significantly stronger than average wind
     * - Important for safety and outdoor activity planning
     * 
     * Type: Double? (nullable)
     * - Wind gust speed in m/s
     * - Used for wind gust display
     * - Important for safety assessments
     * - Only present when gusts are significant
     */
    val gust: Double?,
    
    /**
     * speed - Wind speed
     * 
     * Represents the average wind speed over a period of time.
     * This is the sustained wind speed, not including gusts.
     * 
     * Units: m/s (meters per second)
     * 
     * Wind Speed Categories:
     * - 0-0.5 m/s: Calm
     * - 0.5-3.3 m/s: Light air/breeze
     * - 3.3-5.5 m/s: Gentle breeze
     * - 5.5-7.9 m/s: Moderate breeze
     * - 7.9-10.7 m/s: Fresh breeze
     * - 10.7-13.8 m/s: Strong breeze
     * - 13.8-17.1 m/s: Near gale
     * - 17.1-20.7 m/s: Gale
     * - 20.7-24.4 m/s: Strong gale
     * - 24.4-28.4 m/s: Storm
     * - 28.4+ m/s: Violent storm
     * 
     * Type: Double? (nullable)
     * - Wind speed in m/s
     * - Used for wind speed display
     * - Important for weather condition assessment
     * - Essential for wind-based calculations
     */
    val speed: Double?
)