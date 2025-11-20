package com.example.jetweatherapp.model

/**
 * LocationDataItem - Data class representing individual location search result
 * 
 * This data class represents a single location result from the geocoding API.
 * It contains comprehensive information about a location including coordinates,
 * names in multiple languages, and administrative details.
 * 
 * Purpose:
 * - Parse location data from geocoding API responses
 * - Provide structured access to location information
 * - Enable type-safe location data handling
 * - Support location search and selection functionality
 * 
 * Key Features:
 * - Geographic coordinates (latitude, longitude)
 * - Location names in multiple languages
 * - Administrative information (country, state)
 * - Non-nullable fields for critical data
 * 
 * Why non-nullable fields:
 * - These fields are always present in geocoding responses
 * - They're essential for location identification
 * - Ensures reliable location data processing
 * - Prevents null pointer exceptions
 */
data class LocationDataItem(
    /**
     * country - Country code where the location is located
     * 
     * Contains the ISO 3166-1 alpha-2 country code for the location.
     * Used for country identification and display purposes.
     * 
     * Examples:
     * - "US": United States
     * - "GB": United Kingdom
     * - "DE": Germany
     * - "FR": France
     * - "JP": Japan
     * 
     * Type: String (non-nullable)
     * - ISO country code (2 letters)
     * - Used for country identification
     * - Important for internationalization
     * - Essential for location context
     */
    val country: String,
    
    /**
     * lat - Latitude coordinate of the location
     * 
     * Represents the north-south position of the location on Earth.
     * Latitude ranges from -90° (South Pole) to +90° (North Pole).
     * 
     * Type: Double (non-nullable)
     * - Latitude in decimal degrees
     * - Used for geographic calculations
     * - Essential for mapping and location services
     * - Required for accurate weather data retrieval
     */
    val lat: Double,
    
    /**
     * local_names - Local names in multiple languages
     * 
     * Contains the location name in various languages and scripts.
     * Provides localized names for international users.
     * 
     * Type: LocalNames (non-nullable)
     * - Names in multiple languages
     * - Used for internationalization
     * - Important for user experience
     * - Essential for global accessibility
     */
    val local_names: LocalNames,
    
    /**
     * lon - Longitude coordinate of the location
     * 
     * Represents the east-west position of the location on Earth.
     * Longitude ranges from -180° (International Date Line) to +180°.
     * 
     * Type: Double (non-nullable)
     * - Longitude in decimal degrees
     * - Used for geographic calculations
     * - Essential for mapping and location services
     * - Required for accurate weather data retrieval
     */
    val lon: Double,
    
    /**
     * name - Primary name of the location
     * 
     * The main name of the location, typically in English or the
     * local language. Used as the primary identifier for the location.
     * 
     * Type: String (non-nullable)
     * - Primary location name
     * - Used for location identification
     * - Essential for user recognition
     * - Primary location identifier
     */
    val name: String,
    
    /**
     * state - State or province where the location is located
     * 
     * Contains the state, province, or administrative region
     * where the location is situated. Provides additional
     * context for location identification.
     * 
     * Type: String (non-nullable)
     * - State or province name
     * - Used for administrative context
     * - Important for location disambiguation
     * - Provides additional location context
     */
    val state: String
)