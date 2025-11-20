package com.example.jetweatherapp.model

/**
 * Sys - Data class representing system information for forecast items
 * 
 * This data class contains system-related information for individual
 * forecast items in the 5-day weather forecast. It provides context
 * about the time period and data source for each forecast entry.
 * 
 * Purpose:
 * - Parse system data from forecast API responses
 * - Provide structured access to forecast system information
 * - Enable type-safe system data handling
 * - Support forecast data analysis and display
 * 
 * Key Features:
 * - Part of day indicator (pod)
 * - Non-nullable field for critical data
 * - Simple structure for forecast items
 * 
 * Why non-nullable field:
 * - The pod field is always present in forecast data
 * - It's critical for determining day/night periods
 * - Ensures reliable forecast data processing
 */
data class Sys(
    /**
     * pod - Part of day indicator
     * 
     * Indicates whether the forecast period is during the day or night.
     * This is crucial for determining appropriate weather icons and
     * display themes.
     * 
     * Possible Values:
     * - "d": Day (sunrise to sunset)
     * - "n": Night (sunset to sunrise)
     * 
     * Usage:
     * - Determines which weather icons to display
     * - Influences UI theming (day/night modes)
     * - Helps with astronomical calculations
     * - Used for temperature and weather condition context
     * 
     * Type: String (non-nullable)
     * - Part of day indicator ("d" or "n")
     * - Used for day/night determination
     * - Critical for weather icon selection
     * - Essential for forecast data processing
     */
    val pod: String
)