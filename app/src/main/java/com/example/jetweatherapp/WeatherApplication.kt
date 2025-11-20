package com.example.jetweatherapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WeatherApplication : Application()



/**
 * WeatherApplication - Main Application class for the Weather App
 * 
 * This class serves as the entry point for the entire Android application.
 * It extends Application class to provide global application state and configuration.
 * 
 * @HiltAndroidApp annotation:
 * - Enables Hilt dependency injection framework for the entire application
 * - Generates necessary code for dependency injection setup
 * - Must be applied to exactly one Application class in the project
 * - Creates the ApplicationComponent that serves as the root component for dependency injection
 * 
 * Purpose:
 * - Initialize global application settings
 * - Set up dependency injection framework (Hilt)
 * - Provide application-wide configuration
 * - Handle application lifecycle events
 * 
 * Why it's needed:
 * - Android requires an Application class to manage app-wide state
 * - Hilt needs this annotation to generate DI components
 * - Provides centralized place for app initialization
 */