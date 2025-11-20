package com.example.jetweatherapp.repository

import com.example.jetweatherapp.data.DataOrException
import com.example.jetweatherapp.model.CurrentWeather
import com.example.jetweatherapp.model.WeatherData
import com.example.jetweatherapp.network.WeatherApi
import javax.inject.Inject

/**
 * WeatherRepository - Repository class for weather data operations
 * 
 * This repository class acts as an abstraction layer between the UI
 * and the data sources. It handles weather data retrieval from the
 * WeatherApi and wraps responses in DataOrException for consistent
 * error handling and loading state management.
 * 
 * Purpose:
 * - Abstract weather data operations from UI layer
 * - Provide consistent error handling
 * - Manage loading states for UI updates
 * - Centralize weather data logic
 * 
 * Key Features:
 * - Current weather data retrieval
 * - 5-day weather forecast
 * - Error handling with try-catch blocks
 * - Loading state management
 * - DataOrException wrapper for responses
 * 
 * Why @Inject constructor:
 * - Enables dependency injection with Hilt
 * - Provides WeatherApi instance automatically
 * - Improves testability and maintainability
 * - Follows dependency inversion principle
 */
class WeatherRepository @Inject constructor(private val weatherApi: WeatherApi) {

    /**
     * getCurrentWeather() - Retrieves current weather data for a location
     * 
     * This function fetches current weather data from the WeatherApi
     * and wraps the response in a DataOrException to handle loading
     * states and errors gracefully.
     * 
     * Parameters:
     * @param latitude - Latitude coordinate of the location
     * @param longitude - Longitude coordinate of the location
     * @param temperatureUnit - Temperature unit (metric, imperial, kelvin)
     * 
     * Returns:
     * @return DataOrException<CurrentWeather, Boolean, Exception>
     * - Contains weather data, loading state, and error information
     * 
     * Error Handling:
     * - Catches all exceptions and stores them in DataOrException
     * - Sets loading state to false in finally block
     * - Prevents crashes from network or API errors
     * - Provides consistent error handling across the app
     * 
     * Usage:
     * - Called by ViewModels to get current weather
     * - Used for real-time weather display
     * - Provides immediate weather information
     * - Essential for main weather screen
     * 
     * Why suspend function:
     * - Enables coroutine-based asynchronous calls
     * - Prevents blocking the main thread
     * - Supports reactive programming patterns
     * - Integrates with ViewModel coroutines
     */
    suspend fun getCurrentWeather(latitude: Double, longitude: Double, temperatureUnit: String): DataOrException<CurrentWeather,Boolean,Exception> {
        // Create DataOrException wrapper for response
        val weather = DataOrException<CurrentWeather,Boolean,Exception>()
        
        try {
            // Set loading state to true
            weather.loading = true
            
            // Make API call to get current weather data
            weather.data = weatherApi.getCurrentWeather(latitude,longitude,temperatureUnit)
            
        } catch (e: Exception) {
            // Store any exceptions that occur during API call
            weather.exception = e
            
        } finally {
            // Always set loading state to false, regardless of success or failure
            weather.loading = false
        }
        
        // Return the wrapped response
        return weather
    }

    /**
     * get5Day3HourWeatherForecast() - Retrieves 5-day weather forecast
     * 
     * This function fetches 5-day weather forecast data from the WeatherApi
     * and wraps the response in a DataOrException to handle loading
     * states and errors gracefully.
     * 
     * Parameters:
     * @param latitude - Latitude coordinate of the location
     * @param longitude - Longitude coordinate of the location
     * @param temperatureUnit - Temperature unit (metric, imperial, kelvin)
     * 
     * Returns:
     * @return DataOrException<WeatherData, Boolean, Exception>
     * - Contains forecast data, loading state, and error information
     * 
     * Data Structure:
     * - 40 forecast items (5 days × 8 three-hour intervals)
     * - Each item contains temperature, weather conditions, wind, etc.
     * - Items are ordered chronologically
     * - Includes city information and response metadata
     * 
     * Error Handling:
     * - Catches all exceptions and stores them in DataOrException
     * - Sets loading state to false in finally block
     * - Prevents crashes from network or API errors
     * - Provides consistent error handling across the app
     * 
     * Usage:
     * - Called by ViewModels to get weather forecast
     * - Used for forecast display and planning
     * - Provides extended weather predictions
     * - Essential for forecast screens
     * 
     * Why suspend function:
     * - Enables coroutine-based asynchronous calls
     * - Prevents blocking the main thread
     * - Supports reactive programming patterns
     * - Integrates with ViewModel coroutines
     */
    suspend fun get5Day3HourWeatherForecast(latitude: Double, longitude: Double, temperatureUnit: String): DataOrException<WeatherData,Boolean,Exception> {
        // Create DataOrException wrapper for response
        val forecast = DataOrException<WeatherData,Boolean,Exception>()
        
        try {
            // Set loading state to true
            forecast.loading = true
            
            // Make API call to get 5-day weather forecast
            forecast.data = weatherApi.get5Day3HourWeatherForecast(latitude,longitude, temperatureUnit)
            
        } catch (e: Exception) {
            // Store any exceptions that occur during API call
            forecast.exception = e
            
        } finally {
            // Always set loading state to false, regardless of success or failure
            forecast.loading = false
        }
        
        // Return the wrapped response
        return forecast
    }

    suspend fun getAirPollution(latitude: Double, longitude: Double): DataOrException<com.example.jetweatherapp.model.AirPollutionResponse, Boolean, Exception> {
        val response = DataOrException<com.example.jetweatherapp.model.AirPollutionResponse, Boolean, Exception>()
        try {
            response.loading = true
            response.data = weatherApi.getAirPollution(latitude, longitude)
        } catch (e: Exception) {
            response.exception = e
        } finally {
            response.loading = false
        }
        return response
    }

}