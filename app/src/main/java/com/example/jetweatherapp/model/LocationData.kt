package com.example.jetweatherapp.model

/**
 * LocationData - Custom ArrayList for location search results
 * 
 * This class extends ArrayList<LocationDataItem> to provide a specialized
 * collection for storing location search results from the geocoding API.
 * It's used to hold multiple location matches when searching for cities
 * or places by name.
 * 
 * Purpose:
 * - Provide a specialized collection for location data
 * - Enable type-safe location data handling
 * - Support location search functionality
 * - Maintain compatibility with ArrayList operations
 * 
 * Key Features:
 * - Extends ArrayList for familiar operations
 * - Type-safe with LocationDataItem
 * - Supports all standard ArrayList methods
 * - Used for location search results
 * 
 * Why extend ArrayList:
 * - Provides familiar collection operations
 * - Maintains compatibility with existing code
 * - Enables easy iteration and manipulation
 * - Supports all standard list operations
 */
class LocationData : ArrayList<LocationDataItem>()