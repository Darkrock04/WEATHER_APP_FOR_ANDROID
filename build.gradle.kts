// Top-level build file where you can add configuration options common to all sub-projects/modules.

/**
 * This is the root-level Gradle build file for the Weather App project.
 * It configures plugins and settings that apply to all modules in the project.
 * 
 * Purpose:
 * - Define common plugin versions and configurations
 * - Set up project-wide build settings
 * - Configure plugins for all modules
 * - Centralize build configuration
 * 
 * Key Features:
 * - Plugin version management
 * - Common build settings
 * - Module configuration
 * - Build optimization
 * 
 * Why this file is needed:
 * - Android projects require a root build file
 * - Provides common configuration for all modules
 * - Manages plugin versions and dependencies
 * - Enables project-wide build settings
 */
plugins {
    // Android Application plugin - Required for Android app modules
    // This plugin provides the necessary tasks and configurations for building Android applications
    alias(libs.plugins.android.application) apply false
    
    // Kotlin Android plugin - Required for Kotlin support in Android
    // This plugin enables Kotlin language support and compilation for Android projects
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    
    // Compose Compiler plugin - Required for Jetpack Compose
    // This plugin provides the Compose compiler for transforming Compose code into efficient UI
    alias(libs.plugins.compose.compiler) apply false
    
    // Dagger Hilt Android plugin - Required for dependency injection
    // This plugin enables Hilt dependency injection framework for Android projects
    alias(libs.plugins.dagger.hilt.android) apply false
    
    // KSP (Kotlin Symbol Processing) plugin - Required for annotation processing
    // This plugin provides Kotlin Symbol Processing for compile-time code generation
    alias(libs.plugins.ksp)
}