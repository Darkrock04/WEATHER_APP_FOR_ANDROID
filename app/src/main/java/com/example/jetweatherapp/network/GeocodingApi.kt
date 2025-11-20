package com.example.jetweatherapp.network

import com.example.jetweatherapp.model.LocationData
import com.example.jetweatherapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

/**
 * GeocodingApi - Retrofit interface for geocoding API calls
 * 
 * This interface defines the API endpoints for geocoding services
 * from OpenWeatherMap. It provides functionality to convert location
 * names to coordinates and vice versa.
 * 
 * Purpose:
 * - Define geocoding API endpoints
 * - Provide type-safe location search calls
 * - Enable dependency injection with Hilt
 * - Support location name to coordinate conversion
 * 
 * Key Features:
 * - Location name to coordinates conversion
 * - ZIP code to location conversion
 * - Multiple location search results
 * - Configurable search limits
 * - Suspend functions for coroutines
 * 
 * Why @Singleton:
 * - Ensures single instance across the app
 * - Improves performance and memory usage
 * - Prevents multiple API client instances
 * - Required for Hilt dependency injection
 */
@Singleton
interface GeocodingApi {

    /**
     * getCoordinatesByLocationName() - Converts location name to coordinates
     * 
     * This function makes an HTTP GET request to the OpenWeatherMap
     * geocoding API to find coordinates for a given location name.
     * It can return multiple results for ambiguous location names.
     * 
     * API Endpoint: /geo/1.0/direct
     * 
     * Parameters:
     * @param locationName - Name of the location to search for
     * @param limit - Maximum number of results to return
     * @param apiKey - OpenWeatherMap API key for authentication
     * 
     * Returns:
     * @return LocationData - List of location matches with coordinates
     * 
     * Search Examples:
     * - "London" - Returns London, UK
     * - "New York" - Returns New York, US
     * - "Paris" - Returns Paris, France
     * - "Tokyo" - Returns Tokyo, Japan
     * 
     * Usage:
     * - Called when user searches for a location
     * - Used for location search functionality
     * - Provides coordinates for weather API calls
     * - Essential for location-based weather
     * 
     * Why suspend function:
     * - Enables coroutine-based asynchronous calls
     * - Prevents blocking the main thread
     * - Supports reactive programming patterns
     * - Integrates with ViewModel coroutines
     */
    @GET("geo/1.0/direct")
    suspend fun getCoordinatesByLocationName(
        @Query("q") locationName: String,
        @Query("limit") limit: Int = 1,
        @Query("appid") apiKey: String = Constants.API_KEY
    ): LocationData

    /**
     * getLocationByZipCode() - Converts ZIP code to location coordinates
     * 
     * This function makes an HTTP GET request to the OpenWeatherMap
     * geocoding API to find location coordinates for a given ZIP code.
     * It's useful for US-based location searches.
     * 
     * API Endpoint: /geo/1.0/zip
     * 
     * Parameters:
     * @param zipCode - ZIP code to search for (e.g., "10001,US")
     * @param apiKey - OpenWeatherMap API key for authentication
     * 
     * Returns:
     * @return LocationData - Location data for the ZIP code
     * 
     * ZIP Code Format:
     * - "10001,US" - New York, NY, US
     * - "90210,US" - Beverly Hills, CA, US
     * - "60601,US" - Chicago, IL, US
     * - "94102,US" - San Francisco, CA, US
     * 
     * Usage:
     * - Called when user searches by ZIP code
     * - Used for US-based location searches
     * - Provides coordinates for weather API calls
     * - Alternative to location name search
     * 
     * Why suspend function:
     * - Enables coroutine-based asynchronous calls
     * - Prevents blocking the main thread
     * - Supports reactive programming patterns
     * - Integrates with ViewModel coroutines
     */
    @GET("geo/1.0/zip")
    suspend fun getLocationByZipCode(
        @Query("zip") zipCode: String,
        @Query("appid") apiKey: String = Constants.API_KEY
    ): LocationData

}