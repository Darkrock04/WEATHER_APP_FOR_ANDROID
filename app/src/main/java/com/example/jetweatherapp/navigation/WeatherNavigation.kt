package com.example.jetweatherapp.navigation

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetweatherapp.screens.AboutScreen
import com.example.jetweatherapp.screens.MainScreen
import com.example.jetweatherapp.screens.SettingScreen
import com.example.jetweatherapp.screens.SplashScreen
import com.example.jetweatherapp.viewmodels.LocationViewModel
import com.example.jetweatherapp.viewmodels.MainScreenViewModel
import com.example.jetweatherapp.viewmodels.PermissionViewModel
import com.example.jetweatherapp.viewmodels.SettingScreenViewModel

/**
 * WeatherNavigation() - Main navigation composable for the Weather App
 * 
 * This composable function sets up the navigation system for the entire
 * weather application. It defines the navigation graph, screen routes,
 * and handles navigation between different screens.
 * 
 * Purpose:
 * - Set up navigation system for the app
 * - Define screen routes and navigation graph
 * - Handle navigation between screens
 * - Inject ViewModels for each screen
 * 
 * Key Features:
 * - NavHost for navigation management
 * - Screen route definitions
 * - ViewModel injection with Hilt
 * - Conditional start destination based on Android version
 * - Type-safe navigation with enum
 * 
 * Why @Composable:
 * - Enables Compose UI integration
 * - Provides reactive navigation updates
 * - Integrates with Compose lifecycle
 * - Required for Compose navigation
 */
@Composable
fun WeatherNavigation() {
    // Create navigation controller for managing navigation
    val navController = rememberNavController()
    
    // Set up navigation host with conditional start destination
    NavHost(
        navController = navController, 
        startDestination = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) 
            WeatherScreens.MainScreen.name 
        else 
            WeatherScreens.SplashScreen.name
    ) {
        
        /**
         * SplashScreen route - Initial loading screen
         * 
         * This route displays the splash screen with loading animation.
         * It's shown when the app starts up and while the app initializes.
         * 
         * Parameters:
         * - navController: For navigation to other screens
         * 
         * Usage:
         * - App startup screen
         * - Loading animation display
         * - App initialization
         * - Branding and logo display
         */
        composable(route = WeatherScreens.SplashScreen.name) {
            SplashScreen(navController)
        }
        
        /**
         * MainScreen route - Primary weather display screen
         * 
         * This route displays the main weather screen with current weather
         * conditions, forecasts, and location search functionality.
         * 
         * Parameters:
         * - navController: For navigation to other screens
         * - MainScreenViewModel: For weather data management
         * - PermissionViewModel: For location permission handling
         * - LocationViewModel: For location services
         * 
         * Usage:
         * - Current weather display
         * - Weather forecast
         * - Location search
         * - Main app functionality
         */
        composable(route = WeatherScreens.MainScreen.name) {
            MainScreen(
                navController, 
                hiltViewModel<MainScreenViewModel>(), 
                hiltViewModel<PermissionViewModel>(), 
                hiltViewModel<LocationViewModel>()
            )
        }
        
        /**
         * SettingScreen route - App configuration screen
         * 
         * This route displays the settings screen where users can
         * configure app preferences and customization options.
         * 
         * Parameters:
         * - navController: For navigation to other screens
         * - SettingScreenViewModel: For settings management
         * 
         * Usage:
         * - Temperature unit selection
         * - Location preferences
         * - App customization
         * - User preferences
         */
        composable(route = WeatherScreens.SettingScreen.name) {
            SettingScreen(
                navController, 
                hiltViewModel<SettingScreenViewModel>()
            )
        }
        
        /**
         * AboutScreen route - App information screen
         * 
         * This route displays information about the app, including
         * version details, developer information, and app metadata.
         * 
         * Parameters:
         * - navController: For navigation to other screens
         * 
         * Usage:
         * - App version information
         * - Developer details
         * - App description
         * - Legal information
         */
        composable(route = WeatherScreens.AboutScreen.name) {
            AboutScreen(navController)
        }
    }
}