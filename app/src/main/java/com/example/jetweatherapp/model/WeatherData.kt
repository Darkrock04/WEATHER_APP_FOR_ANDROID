package com.example.jetweatherapp.model

/**
 * WeatherData - Data class representing the 5-day weather forecast response
 * 
 * This data class maps to the JSON response from OpenWeatherMap's 5-day forecast API.
 * It contains a list of weather data items, each representing weather conditions
 * for a specific time period over the next 5 days.
 * 
 * API Endpoint: /data/2.5/forecast
 * 
 * Purpose:
 * - Parse JSON response from 5-day weather forecast API
 * - Provide structured access to forecast data
 * - Enable type-safe data handling in the app
 * - Support reactive UI updates with forecast information
 * 
 * Why nullable fields:
 * - API might not return all fields in every response
 * - Prevents crashes from missing data
 * - Allows graceful handling of incomplete responses
 * - Follows defensive programming practices
 */
data class WeatherData(
    /**
     * city - Information about the city for which forecast is provided
     * 
     * Contains city details like name, country, coordinates, etc.
     * This is the same city information for all forecast items in the list.
     * 
     * Type: City? (nullable)
     * - Nullable because API might not include city info
     * - Contains city name, country, coordinates, timezone
     */
    val city: City?,
    
    /**
     * cnt - Count of forecast items in the response
     * 
     * Indicates how many weather forecast items are included in the list.
     * Typically 40 items (5 days × 8 three-hour intervals per day).
     * 
     * Type: Int? (nullable)
     * - Nullable because count might not be provided
     * - Used for validation and UI display
     * - Helps determine if forecast data is complete
     */
    val cnt: Int?,
    
    /**
     * cod - Response code from the API
     * 
     * Indicates the status of the API request.
     * Common values:
     * - "200": Success
     * - "404": City not found
     * - "401": Invalid API key
     * - "429": Rate limit exceeded
     * 
     * Type: String? (nullable)
     * - Nullable because response might not include code
     * - Used for error handling and debugging
     * - Helps identify API issues
     */
    val cod: String?,
    
    /**
     * list - Array of weather forecast items
     * 
     * This is the main data containing weather forecasts for different time periods.
     * Each item represents weather conditions for a 3-hour interval.
     * 
     * Structure:
     * - 40 items total (5 days × 8 intervals per day)
     * - Each item contains temperature, weather conditions, wind, etc.
     * - Items are ordered chronologically
     * 
     * Type: List<WeatherDataItem>? (nullable)
     * - Nullable because API might not return forecast data
     * - Empty list indicates no forecast available
     * - Used for displaying forecast in UI
     */
    val list: List<WeatherDataItem>?,
    
    /**
     * message - Additional message from the API
     * 
     * Contains additional information or error messages from the API.
     * Usually empty for successful requests, contains error details for failures.
     * 
     * Type: Int? (nullable)
     * - Nullable because message might not be provided
     * - Used for debugging and error reporting
     * - Helps understand API response issues
     */
    val message: Int?
)