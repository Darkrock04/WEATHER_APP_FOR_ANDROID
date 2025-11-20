package com.example.jetweatherapp.model

import com.google.gson.annotations.SerializedName

/**
 * Snow - Data class representing snow precipitation data
 * 
 * This data class contains snow precipitation measurements including
 * overall snow data and time-specific snow forecasts. It's used in
 * weather responses to provide detailed snow information for a
 * specific location.
 * 
 * Purpose:
 * - Parse snow data from API responses
 * - Provide structured access to snow precipitation measurements
 * - Enable type-safe snow data handling
 * - Support snow-based weather analysis and display
 * 
 * Key Features:
 * - Overall snow precipitation data
 * - 1-hour snow forecast data
 * - 3-hour snow forecast data
 * - SerializedName annotations for API mapping
 * 
 * Why nullable fields:
 * - API might not return snow data (no snow occurring)
 * - Some locations might not have snow measurements
 * - Prevents crashes from missing data
 * - Allows graceful handling of incomplete responses
 */
data class Snow(
    /**
     * all - Overall snow precipitation data
     * 
     * Represents the total snow precipitation for the time period.
     * This field contains cumulative snow data for the entire
     * measurement period.
     * 
     * Units: mm (millimeters)
     * 
     * Snow Intensity Scale:
     * - 0 mm: No snow
     * - 0.1-2.5 mm: Light snow
     * - 2.5-10 mm: Moderate snow
     * - 10-25 mm: Heavy snow
     * - 25+ mm: Very heavy snow
     * 
     * Type: Int? (nullable)
     * - Snow precipitation in mm
     * - Used for snow intensity display
     * - Important for weather condition assessment
     * - Only present when snow is occurring
     */
    val all: Int?,
    
    /**
     * oneH - 1-hour snow forecast data
     * 
     * Contains snow precipitation data for 1-hour forecasts.
     * This field is used in forecast data to provide short-term
     * snow predictions for immediate planning.
     * 
     * @SerializedName("1h") annotation:
     * - Maps JSON field "1h" to Kotlin property "oneH"
     * - Required because "1h" is not a valid Kotlin identifier
     * - Ensures proper JSON deserialization
     * 
     * Units: mm (millimeters)
     * 
     * Type: Double? (nullable)
     * - 1-hour snow precipitation in mm
     * - Used for short-term snow forecasts
     * - Important for immediate weather predictions
     * - Only present in forecast data
     */
    @SerializedName("1h")
    val oneH: Double?,
    
    /**
     * threeH - 3-hour snow forecast data
     * 
     * Contains snow precipitation data for 3-hour forecasts.
     * This field is used in forecast data to provide medium-term
     * snow predictions for extended planning.
     * 
     * @SerializedName("3h") annotation:
     * - Maps JSON field "3h" to Kotlin property "threeH"
     * - Required because "3h" is not a valid Kotlin identifier
     * - Ensures proper JSON deserialization
     * 
     * Units: mm (millimeters)
     * 
     * Type: Double? (nullable)
     * - 3-hour snow precipitation in mm
     * - Used for medium-term snow forecasts
     * - Important for extended weather predictions
     * - Only present in forecast data
     */
    @SerializedName("3h")
    val threeH: Double?
)