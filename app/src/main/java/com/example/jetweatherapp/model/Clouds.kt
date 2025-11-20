package com.example.jetweatherapp.model

import com.google.gson.annotations.SerializedName

/**
 * Clouds - Data class representing cloud coverage information
 * 
 * This data class contains cloud coverage data including overall
 * cloud coverage percentage and precipitation-related cloud data.
 * It's used in weather responses to provide detailed cloud
 * condition information for a specific location.
 * 
 * Purpose:
 * - Parse cloud data from API responses
 * - Provide structured access to cloud coverage measurements
 * - Enable type-safe cloud data handling
 * - Support cloud-based weather analysis and display
 * 
 * Key Features:
 * - Overall cloud coverage percentage
 * - 1-hour precipitation cloud data
 * - 3-hour precipitation cloud data
 * - SerializedName annotations for API mapping
 * 
 * Why nullable fields:
 * - API might not return all cloud data
 * - Some locations might not have cloud measurements
 * - Prevents crashes from missing data
 * - Allows graceful handling of incomplete responses
 */
data class Clouds(
    /**
     * all - Overall cloud coverage percentage
     * 
     * Represents the percentage of the sky covered by clouds.
     * This is the most commonly used cloud coverage measurement.
     * 
     * Coverage Scale:
     * - 0%: Clear sky (no clouds)
     * - 1-25%: Few clouds
     * - 26-50%: Scattered clouds
     * - 51-75%: Broken clouds
     * - 76-99%: Overcast
     * - 100%: Completely overcast
     * 
     * Weather Implications:
     * - 0-25%: Mostly sunny, good visibility
     * - 26-50%: Partly cloudy, some sun
     * - 51-75%: Mostly cloudy, limited sun
     * - 76-100%: Overcast, no sun, possible rain
     * 
     * Type: Int? (nullable)
     * - Cloud coverage percentage (0-100)
     * - Used for cloud coverage display
     * - Important for weather condition assessment
     * - Essential for sky condition analysis
     */
    val all: Int?,
    
    /**
     * oneH - 1-hour precipitation cloud data
     * 
     * Contains cloud-related data for 1-hour precipitation forecasts.
     * This field is used in forecast data to provide cloud information
     * for short-term precipitation predictions.
     * 
     * @SerializedName("1h") annotation:
     * - Maps JSON field "1h" to Kotlin property "oneH"
     * - Required because "1h" is not a valid Kotlin identifier
     * - Ensures proper JSON deserialization
     * 
     * Type: Double? (nullable)
     * - 1-hour cloud precipitation data
     * - Used for short-term precipitation forecasts
     * - Important for immediate weather predictions
     * - Only present in forecast data
     */
    @SerializedName("1h")
    val oneH: Double?,
    
    /**
     * threeH - 3-hour precipitation cloud data
     * 
     * Contains cloud-related data for 3-hour precipitation forecasts.
     * This field is used in forecast data to provide cloud information
     * for medium-term precipitation predictions.
     * 
     * @SerializedName("3h") annotation:
     * - Maps JSON field "3h" to Kotlin property "threeH"
     * - Required because "3h" is not a valid Kotlin identifier
     * - Ensures proper JSON deserialization
     * 
     * Type: Double? (nullable)
     * - 3-hour cloud precipitation data
     * - Used for medium-term precipitation forecasts
     * - Important for extended weather predictions
     * - Only present in forecast data
     */
    @SerializedName("3h")
    val threeH: Double?
)