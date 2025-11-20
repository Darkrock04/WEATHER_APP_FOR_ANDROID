package com.example.jetweatherapp.repository

import com.example.jetweatherapp.data.DataOrException
import com.example.jetweatherapp.model.LocationDataItem
import com.example.jetweatherapp.network.GeocodingApi
import com.example.jetweatherapp.utils.Constants
import java.time.LocalDateTime
import javax.inject.Inject

/**
 * GeocodingRepository - Repository class for geocoding operations
 * 
 * This repository class acts as an abstraction layer between the UI
 * and the geocoding data sources. It handles location search operations
 * from the GeocodingApi and wraps responses in DataOrException for
 * consistent error handling and loading state management.
 * 
 * Purpose:
 * - Abstract geocoding operations from UI layer
 * - Provide consistent error handling
 * - Manage loading states for UI updates
 * - Centralize location search logic
 * 
 * Key Features:
 * - Location name to coordinates conversion
 * - ZIP code to location conversion
 * - Error handling with try-catch blocks
 * - Loading state management
 * - DataOrException wrapper for responses
 * 
 * Why @Inject constructor:
 * - Enables dependency injection with Hilt
 * - Provides GeocodingApi instance automatically
 * - Improves testability and maintainability
 * - Follows dependency inversion principle
 */
class GeocodingRepository @Inject constructor(private val geocodingApi: GeocodingApi) {

    /**
     * getCoordinatesByLocationName() - Converts location name to coordinates
     * 
     * This function searches for a location by name using the GeocodingApi
     * and wraps the response in a DataOrException to handle loading
     * states and errors gracefully.
     * 
     * Parameters:
     * @param locationName - Name of the location to search for
     * 
     * Returns:
     * @return DataOrException<ArrayList<LocationDataItem>, Boolean, Exception>
     * - Contains location data, loading state, and error information
     * 
     * Search Examples:
     * - "London" - Returns London, UK
     * - "New York" - Returns New York, US
     * - "Paris" - Returns Paris, France
     * - "Tokyo" - Returns Tokyo, Japan
     * 
     * Error Handling:
     * - Catches all exceptions and stores them in DataOrException
     * - Sets loading state to false in finally block
     * - Prevents crashes from network or API errors
     * - Provides consistent error handling across the app
     * 
     * Usage:
     * - Called by ViewModels to search for locations
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
    suspend fun getCoordinatesByLocationName(locationName: String): DataOrException<ArrayList<LocationDataItem>, Boolean, Exception> {
        // Create DataOrException wrapper for response
        val coordinates = DataOrException<ArrayList<LocationDataItem>, Boolean, Exception>()
        
        try {
            // Set loading state to true
            coordinates.loading = true
            
            // Make API call to search for location by name
            coordinates.data = geocodingApi.getCoordinatesByLocationName(locationName)
            
        } catch (e: Exception) {
            // Store any exceptions that occur during API call
            coordinates.exception = e
            
        } finally {
            // Always set loading state to false, regardless of success or failure
            coordinates.loading = false
        }
        
        // Return the wrapped response
        return coordinates
    }

    /**
     * getCoordinatesByZipCode() - Converts ZIP code to location coordinates
     * 
     * This function searches for a location by ZIP code using the GeocodingApi
     * and wraps the response in a DataOrException to handle loading
     * states and errors gracefully.
     * 
     * Parameters:
     * @param zipCode - ZIP code to search for (e.g., "10001,US")
     * 
     * Returns:
     * @return DataOrException<ArrayList<LocationDataItem>, Boolean, Exception>
     * - Contains location data, loading state, and error information
     * 
     * ZIP Code Format:
     * - "10001,US" - New York, NY, US
     * - "90210,US" - Beverly Hills, CA, US
     * - "60601,US" - Chicago, IL, US
     * - "94102,US" - San Francisco, CA, US
     * 
     * Error Handling:
     * - Catches all exceptions and stores them in DataOrException
     * - Sets loading state to false in finally block
     * - Prevents crashes from network or API errors
     * - Provides consistent error handling across the app
     * 
     * Usage:
     * - Called by ViewModels to search by ZIP code
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
    suspend fun getCoordinatesByZipCode(zipCode: String): DataOrException<ArrayList<LocationDataItem>, Boolean, Exception> {
        // Create DataOrException wrapper for response
        val coordinates = DataOrException<ArrayList<LocationDataItem>, Boolean, Exception>()
        
        try {
            // Set loading state to true
            coordinates.loading = true
            
            // Make API call to search for location by ZIP code
            coordinates.data = geocodingApi.getLocationByZipCode(zipCode)
            
        } catch (e: Exception) {
            // Store any exceptions that occur during API call
            coordinates.exception = e
            
        } finally {
            // Always set loading state to false, regardless of success or failure
            coordinates.loading = false
        }
        
        // Return the wrapped response
        return coordinates
    }

}