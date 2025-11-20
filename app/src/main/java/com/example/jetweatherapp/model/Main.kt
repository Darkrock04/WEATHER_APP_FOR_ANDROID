package com.example.jetweatherapp.model

/**
 * Main - Data class representing main weather parameters
 * 
 * This data class contains the core atmospheric and temperature data
 * from OpenWeatherMap API responses. It's used in both current weather
 * and forecast data to provide essential weather measurements.
 * 
 * Purpose:
 * - Parse main weather parameters from API responses
 * - Provide structured access to temperature and atmospheric data
 * - Enable type-safe weather data handling
 * - Support temperature unit conversions and calculations
 * 
 * Key Features:
 * - Temperature data (current, feels like, min/max)
 * - Atmospheric pressure measurements
 * - Humidity percentage
 * - Sea level and ground level pressure
 * - Temperature change calculations
 * 
 * Why nullable fields:
 * - API might not return all fields in every response
 * - Some measurements might not be available for certain locations
 * - Prevents crashes from missing data
 * - Allows graceful handling of incomplete responses
 */
data class Main(
    /**
     * feels_like - Temperature that it actually feels like
     * 
     * This is the "apparent temperature" which takes into account
     * factors like wind chill and humidity to determine how the
     * temperature actually feels to humans.
     * 
     * Calculation Factors:
     * - Wind speed (wind chill effect)
     * - Humidity (heat index effect)
     * - Solar radiation
     * - Personal factors (clothing, activity level)
     * 
     * Type: Double? (nullable)
     * - Temperature in Kelvin (API default)
     * - Used for "feels like" temperature display
     * - Important for user comfort assessment
     * - More accurate than actual temperature for human perception
     */
    val feels_like: Double?,
    
    /**
     * grnd_level - Atmospheric pressure at ground level
     * 
     * Represents the atmospheric pressure measured at ground level
     * (sea level pressure adjusted for altitude).
     * 
     * Units: hPa (hectopascals)
     * Normal Range: 980-1040 hPa
     * 
     * Type: Int? (nullable)
     * - Ground level pressure in hPa
     * - Used for weather pattern analysis
     * - Important for altitude-based pressure calculations
     * - Helps determine weather stability
     */
    val grnd_level: Int?,
    
    /**
     * humidity - Relative humidity percentage
     * 
     * Indicates the amount of water vapor in the air relative to
     * the maximum amount the air can hold at that temperature.
     * 
     * Range: 0-100%
     * - 0%: Completely dry air
     * - 50%: Moderate humidity
     * - 100%: Saturated air (fog, rain)
     * 
     * Type: Int? (nullable)
     * - Humidity percentage (0-100)
     * - Used for comfort and health assessments
     * - Important for weather condition determination
     * - Affects perceived temperature
     */
    val humidity: Int?,
    
    /**
     * pressure - Atmospheric pressure at sea level
     * 
     * Represents the atmospheric pressure standardized to sea level.
     * This is the most commonly used pressure measurement.
     * 
     * Units: hPa (hectopascals)
     * Normal Range: 980-1040 hPa
     * 
     * Weather Patterns:
     * - High pressure (>1013 hPa): Clear, stable weather
     * - Low pressure (<1013 hPa): Stormy, unstable weather
     * - Rapid changes: Weather system movement
     * 
     * Type: Int? (nullable)
     * - Sea level pressure in hPa
     * - Used for weather forecasting
     * - Important for weather pattern analysis
     * - Standard reference for pressure measurements
     */
    val pressure: Int?,
    
    /**
     * sea_level - Atmospheric pressure at sea level
     * 
     * This is the same as pressure field but explicitly named
     * for clarity. Represents atmospheric pressure at sea level.
     * 
     * Units: hPa (hectopascals)
     * 
     * Type: Int? (nullable)
     * - Sea level pressure in hPa
     * - Used for weather analysis
     * - Important for pressure trend monitoring
     * - Standard reference point for pressure
     */
    val sea_level: Int?,
    
    /**
     * temp - Current temperature
     * 
     * The actual air temperature at the measurement location.
     * This is the primary temperature value used for display.
     * 
     * Units: Kelvin (API default)
     * Conversion: K = °C + 273.15
     * 
     * Type: Double? (nullable)
     * - Temperature in Kelvin
     * - Used for primary temperature display
     * - Most important weather parameter
     * - Basis for temperature calculations
     */
    val temp: Double?,
    
    /**
     * temp_kf - Temperature change calculation
     * 
     * Represents the temperature change from the previous measurement.
     * Used for temperature trend analysis and forecasting.
     * 
     * Units: Kelvin
     * 
     * Type: Double? (nullable)
     * - Temperature change in Kelvin
     * - Used for temperature trend analysis
     * - Important for weather forecasting
     * - Helps predict temperature changes
     */
    val temp_kf: Double?,
    
    /**
     * temp_max - Maximum temperature for the period
     * 
     * The highest temperature expected during the time period
     * (day for current weather, 3-hour period for forecasts).
     * 
     * Units: Kelvin (API default)
     * 
     * Type: Double? (nullable)
     * - Maximum temperature in Kelvin
     * - Used for temperature range display
     * - Important for daily temperature planning
     * - Helps users prepare for temperature extremes
     */
    val temp_max: Double?,
    
    /**
     * temp_min - Minimum temperature for the period
     * 
     * The lowest temperature expected during the time period
     * (day for current weather, 3-hour period for forecasts).
     * 
     * Units: Kelvin (API default)
     * 
     * Type: Double? (nullable)
     * - Minimum temperature in Kelvin
     * - Used for temperature range display
     * - Important for daily temperature planning
     * - Helps users prepare for temperature extremes
     */
    val temp_min: Double?
)