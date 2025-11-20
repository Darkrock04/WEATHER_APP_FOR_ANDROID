package com.example.jetweatherapp.navigation

/**
 * WeatherScreens - Enumeration of all screens in the Weather App
 * 
 * This enum defines all the screens available in the weather application.
 * It's used by the navigation system to identify and route between
 * different screens in the app.
 * 
 * Purpose:
 * - Define all available screens in the app
 * - Provide type-safe screen identifiers
 * - Enable navigation between screens
 * - Centralize screen definitions
 * 
 * Key Features:
 * - Type-safe screen identifiers
 * - Easy to maintain and extend
 * - Used by navigation system
 * - Prevents typos in screen names
 * 
 * Why enum:
 * - Provides compile-time safety
 * - Prevents invalid screen names
 * - Easy to add new screens
 * - Centralized screen management
 */
enum class WeatherScreens {
    /**
     * SplashScreen - Initial loading screen
     * 
     * This screen is shown when the app starts up.
     * It displays a loading animation while the app
     * initializes and prepares the main screen.
     * 
     * Usage:
     * - App startup screen
     * - Loading animation display
     * - App initialization
     * - Branding and logo display
     */
    SplashScreen,
    
    /**
     * MainScreen - Primary weather display screen
     * 
     * This is the main screen of the app where users
     * can view current weather conditions and forecasts.
     * It contains the primary weather information and
     * navigation to other screens.
     * 
     * Usage:
     * - Current weather display
     * - Weather forecast
     * - Location search
     * - Main app functionality
     */
    MainScreen,
    
    /**
     * SettingScreen - App configuration screen
     * 
     * This screen allows users to configure app settings
     * such as temperature units, location preferences,
     * and other customization options.
     * 
     * Usage:
     * - Temperature unit selection
     * - Location preferences
     * - App customization
     * - User preferences
     */
    SettingScreen,
    
    /**
     * AboutScreen - App information screen
     * 
     * This screen displays information about the app,
     * including version details, developer information,
     * and other relevant app metadata.
     * 
     * Usage:
     * - App version information
     * - Developer details
     * - App description
     * - Legal information
     */
    AboutScreen
}