package com.example.jetweatherapp.network

import com.example.jetweatherapp.model.CurrentWeather
import com.example.jetweatherapp.model.WeatherData
import com.example.jetweatherapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

/**
 * WeatherApi - Retrofit interface for weather data API calls
 * 
 * This interface defines the API endpoints for retrieving weather data
 * from OpenWeatherMap. It uses Retrofit annotations to create HTTP
 * requests for current weather and forecast data.
 * 
 * Purpose:
 * - Define weather API endpoints
 * - Provide type-safe API calls
 * - Enable dependency injection with Hilt
 * - Support both current weather and forecast data
 * 
 * Key Features:
 * - Current weather data retrieval
 * - 5-day weather forecast
 * - Coordinate-based weather queries
 * - Configurable units and API key
 * - Suspend functions for coroutines
 * 
 * Why @Singleton:
 * - Ensures single instance across the app
 * - Improves performance and memory usage
 * - Prevents multiple API client instances
 * - Required for Hilt dependency injection
 */
@Singleton
interface WeatherApi {

    /**
     * getCurrentWeather() - Retrieves current weather data for a location
     * 
     * This function makes an HTTP GET request to the OpenWeatherMap
     * current weather API to fetch real-time weather data for a
     * specific location identified by coordinates.
     * 
     * API Endpoint: /data/2.5/weather
     * 
     * Parameters:
     * @param latitude - Latitude coordinate of the location
     * @param longitude - Longitude coordinate of the location
     * @param units - Temperature units (metric, imperial, kelvin)
     * @param apiKey - OpenWeatherMap API key for authentication
     * 
     * Returns:
     * @return CurrentWeather - Current weather data for the location
     * 
     * Usage:
     * - Called when user requests current weather
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
    @GET("data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("units") units: String = "metric",
        @Query("appid") apiKey: String = Constants.API_KEY
    ): CurrentWeather

    /**
     * get5Day3HourWeatherForecast() - Retrieves 5-day weather forecast
     * 
     * This function makes an HTTP GET request to the OpenWeatherMap
     * forecast API to fetch weather predictions for the next 5 days
     * with 3-hour intervals.
     * 
     * API Endpoint: /data/2.5/forecast
     * 
     * Parameters:
     * @param latitude - Latitude coordinate of the location
     * @param longitude - Longitude coordinate of the location
     * @param units - Temperature units (metric, imperial, kelvin)
     * @param apiKey - OpenWeatherMap API key for authentication
     * 
     * Returns:
     * @return WeatherData - 5-day weather forecast data
     * 
     * Data Structure:
     * - 40 forecast items (5 days × 8 three-hour intervals)
     * - Each item contains temperature, weather conditions, wind, etc.
     * - Items are ordered chronologically
     * - Includes city information and response metadata
     * 
     * Usage:
     * - Called when user requests weather forecast
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
    @GET("data/2.5/forecast")
    suspend fun get5Day3HourWeatherForecast(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("units") units: String = "metric",
        @Query("appid") apiKey: String = Constants.API_KEY
    ): WeatherData

    @GET("data/2.5/air_pollution")
    suspend fun getAirPollution(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String = Constants.API_KEY
    ): com.example.jetweatherapp.model.AirPollutionResponse

}