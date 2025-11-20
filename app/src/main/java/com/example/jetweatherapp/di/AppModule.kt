package com.example.jetweatherapp.di

import com.example.jetweatherapp.network.GeocodingApi
import com.example.jetweatherapp.network.WeatherApi
import com.example.jetweatherapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * AppModule - Dependency injection module for the Weather App
 * 
 * This module provides dependencies for the entire application using
 * Hilt dependency injection. It configures Retrofit instances for
 * API calls and makes them available throughout the app.
 * 
 * Purpose:
 * - Configure and provide Retrofit instances
 * - Set up API interfaces for dependency injection
 * - Centralize network configuration
 * - Enable singleton pattern for API clients
 * 
 * Key Features:
 * - Retrofit configuration with base URL
 * - Gson converter for JSON parsing
 * - Singleton instances for API clients
 * - Hilt integration for dependency injection
 * 
 * Why @Module:
 * - Marks this class as a Dagger module
 * - Enables dependency provision
 * - Required for Hilt dependency injection
 * - Centralizes dependency configuration
 * 
 * Why @InstallIn(SingletonComponent::class):
 * - Installs this module in the singleton component
 * - Makes dependencies available app-wide
 * - Ensures single instance of dependencies
 * - Required for Hilt to work properly
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * provideGeocodingApi() - Provides GeocodingApi instance
     * 
     * This function creates and configures a Retrofit instance
     * specifically for geocoding API calls. It sets up the base URL,
     * JSON converter, and creates the API interface.
     * 
     * Returns:
     * @return GeocodingApi - Configured Retrofit interface for geocoding
     * 
     * Configuration:
     * - Base URL: OpenWeatherMap API base URL
     * - Converter: Gson for JSON parsing
     * - Interface: GeocodingApi for type-safe API calls
     * 
     * Why @Singleton:
     * - Ensures single instance across the app
     * - Improves performance and memory usage
     * - Prevents multiple Retrofit instances
     * - Required for efficient API client management
     * 
     * Why @Provides:
     * - Marks this function as a dependency provider
     * - Enables Hilt to inject this dependency
     * - Required for dependency injection to work
     * - Makes the dependency available to other classes
     * 
     * Usage:
     * - Injected into GeocodingRepository
     * - Used for location search operations
     * - Provides coordinates for weather API calls
     * - Essential for location-based features
     */
    @Singleton
    @Provides
    fun provideGeocodingApi(): GeocodingApi = Retrofit
        .Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GeocodingApi::class.java)

    /**
     * provideWeatherApi() - Provides WeatherApi instance
     * 
     * This function creates and configures a Retrofit instance
     * specifically for weather API calls. It sets up the base URL,
     * JSON converter, and creates the API interface.
     * 
     * Returns:
     * @return WeatherApi - Configured Retrofit interface for weather data
     * 
     * Configuration:
     * - Base URL: OpenWeatherMap API base URL
     * - Converter: Gson for JSON parsing
     * - Interface: WeatherApi for type-safe API calls
     * 
     * Why @Singleton:
     * - Ensures single instance across the app
     * - Improves performance and memory usage
     * - Prevents multiple Retrofit instances
     * - Required for efficient API client management
     * 
     * Why @Provides:
     * - Marks this function as a dependency provider
     * - Enables Hilt to inject this dependency
     * - Required for dependency injection to work
     * - Makes the dependency available to other classes
     * 
     * Usage:
     * - Injected into WeatherRepository
     * - Used for weather data retrieval
     * - Provides current weather and forecast data
     * - Essential for weather display functionality
     */
    @Singleton
    @Provides
    fun provideWeatherApi(): WeatherApi = Retrofit
        .Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherApi::class.java)

}