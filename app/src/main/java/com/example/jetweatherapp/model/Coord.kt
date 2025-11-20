package com.example.jetweatherapp.model

/**
 * Coord - Data class representing geographic coordinates
 * 
 * This data class contains latitude and longitude information
 * for a specific location. It's used throughout the weather app
 * to represent geographic positions for cities, weather stations,
 * and user locations.
 * 
 * Purpose:
 * - Parse coordinate data from API responses
 * - Provide structured access to latitude and longitude
 * - Enable type-safe geographic data handling
 * - Support location-based features and calculations
 * 
 * Key Features:
 * - Latitude coordinate (north-south position)
 * - Longitude coordinate (east-west position)
 * - Nullable fields for defensive programming
 * - Simple structure for easy usage
 * 
 * Why nullable fields:
 * - API might not return coordinate data
 * - Some locations might not have valid coordinates
 * - Prevents crashes from missing data
 * - Allows graceful handling of incomplete responses
 */
data class Coord(
    /**
     * lat - Latitude coordinate
     * 
     * Represents the north-south position of a location on Earth.
     * Latitude ranges from -90° (South Pole) to +90° (North Pole).
     * 
     * Coordinate System:
     * - Positive values: North of the equator
     * - Negative values: South of the equator
     * - 0°: Equator
     * - ±90°: Poles
     * 
     * Examples:
     * - New York: ~40.7128°N (positive)
     * - Sydney: ~-33.8688°S (negative)
     * - London: ~51.5074°N (positive)
     * - São Paulo: ~-23.5505°S (negative)
     * 
     * Type: Double? (nullable)
     * - Latitude in decimal degrees
     * - Used for geographic calculations
     * - Essential for mapping and location services
     * - Required for accurate weather data retrieval
     */
    val lat: Double?,
    
    /**
     * lon - Longitude coordinate
     * 
     * Represents the east-west position of a location on Earth.
     * Longitude ranges from -180° (International Date Line) to +180°.
     * 
     * Coordinate System:
     * - Positive values: East of the Prime Meridian
     * - Negative values: West of the Prime Meridian
     * - 0°: Prime Meridian (Greenwich, UK)
     * - ±180°: International Date Line
     * 
     * Examples:
     * - New York: ~-74.0060°W (negative)
     * - Tokyo: ~139.6917°E (positive)
     * - London: ~-0.1278°W (negative)
     * - Sydney: ~151.2093°E (positive)
     * 
     * Type: Double? (nullable)
     * - Longitude in decimal degrees
     * - Used for geographic calculations
     * - Essential for mapping and location services
     * - Required for accurate weather data retrieval
     */
    val lon: Double?
)