package com.example.jetweatherapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.jetweatherapp.navigation.WeatherNavigation
import com.example.jetweatherapp.ui.theme.JetWeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * MainActivity - Main Activity class for the Weather App
 * 
 * This is the primary activity that serves as the entry point for the user interface.
 * It extends ComponentActivity to support Jetpack Compose UI framework.
 * 
 * @AndroidEntryPoint annotation:
 * - Enables Hilt dependency injection for this Activity
 * - Allows injection of dependencies into this Activity
 * - Required for Activities that need dependency injection
 * 
 * Key Features:
 * - Edge-to-edge display support for modern Android design
 * - Splash screen implementation for Android 12+ devices
 * - Jetpack Compose UI setup
 * - Navigation integration
 */
 
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    /**
     * onCreate() - Activity lifecycle method called when the activity is created
     * 
     * This method initializes the activity and sets up the user interface.
     * It's called once when the activity is first created.
     * 
     * Parameters:
     * @param savedInstanceState - Bundle containing saved state data (if any)
     * 
     * What it does:
     * 1. Calls super.onCreate() to ensure proper Activity initialization
     * 2. Enables edge-to-edge display for modern Android design
     * 3. Sets up splash screen for Android 12+ devices
     * 4. Configures the Compose UI content
     * 
     * Why each step is important:
     * - enableEdgeToEdge(): Provides immersive full-screen experience
     * - Splash screen: Shows branded loading screen while app initializes
     * - setContent(): Sets up Jetpack Compose as the UI framework
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Enable edge-to-edge display for modern Android design
        // This allows content to extend behind system bars for immersive experience

        enableEdgeToEdge()
        
        // Set up splash screen for Android 12+ devices
        // Splash screen API was introduced in API level 31 (Android 12)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {

            // Install splash screen and configure it

            val splashScreen = installSplashScreen()
            
            // Keep splash screen visible initially

            splashScreen.setKeepOnScreenCondition { true }
            
            // Launch coroutine to hide splash screen after delay
            // This simulates app initialization time
            
            CoroutineScope(Dispatchers.IO).launch {
                delay(2000) // Wait for 2 seconds
                // Hide splash screen after delay
                splashScreen.setKeepOnScreenCondition { false }
            }
        }
        
        // Set up Jetpack Compose UI content
        // This replaces traditional XML layouts with Compose
        setContent {
            WeatherApp()
        }
    }
}

/**
 * WeatherApp() - Main Composable function for the Weather App UI
 * 
 * This is the root Composable function that defines the main UI structure.
 * It wraps the entire app in a theme and navigation system.
 * 
 * @Preview annotation:
 * - Enables preview in Android Studio
 * - Shows how the UI looks without running the app
 * - Useful for UI development and testing
 * 
 * @Composable annotation:
 * - Marks this function as a Composable
 * - Allows it to be used in Compose UI
 * - Enables reactive UI updates
 * 
 * Structure:
 * - JetWeatherAppTheme: Applies custom theme (colors, typography, etc.)
 * - Surface: Material Design surface container
 * - WeatherNavigation: Handles navigation between screens
 * 
 * Why this structure:
 * - Theme wrapper ensures consistent design across the app
 * - Surface provides Material Design foundation
 * - Navigation handles screen transitions
 */
@Preview
@Composable
fun WeatherApp() {
    // Apply custom theme to the entire app
    JetWeatherAppTheme {
        // Material Design surface container
        // fillMaxSize() makes it take up the entire screen
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Navigation component that handles screen transitions
            WeatherNavigation()
        }
    }
}