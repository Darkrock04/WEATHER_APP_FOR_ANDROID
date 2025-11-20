package com.example.jetweatherapp.model

import com.google.gson.annotations.SerializedName

/**
 * Rain - Data class representing rain precipitation data
 * 
 * This data class contains rain precipitation measurements including
 * overall rain data and time-specific rain forecasts. It's used in
 * weather responses to provide detailed rain information for a
 * specific location.
 * 
 * Purpose:
 * - Parse rain data from API responses
 * - Provide structured access to rain precipitation measurements
 * - Enable type-safe rain data handling
 * - Support rain-based weather analysis and display
 * 
 * Key Features:
 * - Overall rain precipitation data
 * - 1-hour rain forecast data
 * - 3-hour rain forecast data
 * - SerializedName annotations for API mapping
 * 
 * Why nullable fields:
 * - API might not return rain data (no rain occurring)
 * - Some locations might not have rain measurements
 * - Prevents crashes from missing data
 * - Allows graceful handling of incomplete responses
 */
data class Rain(
    /**
     * all - Overall rain precipitation data
     * 
     * Represents the total rain precipitation for the time period.
     * This field contains cumulative rain data for the entire
     * measurement period.
     * 
     * Units: mm (millimeters)
     * 
     * Rain Intensity Scale:
     * - 0 mm: No rain
     * - 0.1-2.5 mm: Light rain
     * - 2.5-10 mm: Moderate rain
     * - 10-25 mm: Heavy rain
     * - 25+ mm: Very heavy rain
     * 
     * Type: Int? (nullable)
     * - Rain precipitation in mm
     * - Used for rain intensity display
     * - Important for weather condition assessment
     * - Only present when rain is occurring
     */
    val all: Int?,
    
    /**
     * oneH - 1-hour rain forecast data
     * 
     * Contains rain precipitation data for 1-hour forecasts.
     * This field is used in forecast data to provide short-term
     * rain predictions for immediate planning.
     * 
     * @SerializedName("1h") annotation:
     * - Maps JSON field "1h" to Kotlin property "oneH"
     * - Required because "1h" is not a valid Kotlin identifier
     * - Ensures proper JSON deserialization
     * 
     * Units: mm (millimeters)
     * 
     * Type: Double? (nullable)
     * - 1-hour rain precipitation in mm
     * - Used for short-term rain forecasts
     * - Important for immediate weather predictions
     * - Only present in forecast data
     */
    @SerializedName("1h")
    val oneH: Double?,
    
    /**
     * threeH - 3-hour rain forecast data
     * 
     * Contains rain precipitation data for 3-hour forecasts.
     * This field is used in forecast data to provide medium-term
     * rain predictions for extended planning.
     * 
     * @SerializedName("3h") annotation:
     * - Maps JSON field "3h" to Kotlin property "threeH"
     * - Required because "3h" is not a valid Kotlin identifier
     * - Ensures proper JSON deserialization
     * 
     * Units: mm (millimeters)
     * 
     * Type: Double? (nullable)
     * - 3-hour rain precipitation in mm
     * - Used for medium-term rain forecasts
     * - Important for extended weather predictions
     * - Only present in forecast data
     */
    @SerializedName("3h")
    val threeH: Double?
)