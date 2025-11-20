/**
 * This is the app-level Gradle build file for the Weather App.
 * It configures the specific build settings, dependencies, and plugins
 * for the main application module.
 * 
 * Purpose:
 * - Configure app-specific build settings
 * - Define dependencies for the app module
 * - Set up Android-specific configurations
 * - Enable required plugins for the app
 * 
 * Key Features:
 * - Android app configuration
 * - Dependency management
 * - Build type settings
 * - Compile options
 * - Plugin configuration
 * 
 * Why this file is needed:
 * - Each Android module needs its own build file
 * - Configures app-specific settings and dependencies
 * - Enables required plugins for the app module
 * - Manages build configurations and optimizations
 */

// Apply required plugins for the app module
plugins {
    // Android Application plugin - Required for Android app modules
    // This plugin provides the necessary tasks and configurations for building Android applications
    alias(libs.plugins.android.application)
    
    // Kotlin Android plugin - Required for Kotlin support in Android
    // This plugin enables Kotlin language support and compilation for Android projects
    alias(libs.plugins.jetbrains.kotlin.android)
    
    // Compose Compiler plugin - Required for Jetpack Compose
    // This plugin provides the Compose compiler for transforming Compose code into efficient UI
    alias(libs.plugins.compose.compiler)
    
    // Dagger Hilt Android plugin - Required for dependency injection
    // This plugin enables Hilt dependency injection framework for Android projects
    alias(libs.plugins.dagger.hilt.android)
    
    // KSP (Kotlin Symbol Processing) plugin - Required for annotation processing
    // This plugin provides Kotlin Symbol Processing for compile-time code generation
    alias(libs.plugins.ksp)
}

// Android-specific configuration
android {
    // Application namespace - Used for resource identification
    // This prevents resource conflicts and enables proper resource access
    namespace = "com.example.jetweatherapp"
    
    // Compile SDK version - The Android API level to compile against
    // This determines which Android features are available during compilation
    compileSdk = 34

    // Default configuration for the app
    defaultConfig {
        // Application ID - Unique identifier for the app on the device and Play Store
        // This must be unique across all apps and cannot be changed after publishing
        applicationId = "com.example.jetweatherapp"
        
        // Minimum SDK version - Lowest Android version that can run the app
        // This ensures compatibility with older Android versions
        minSdk = 29
        
        // Target SDK version - Android version the app is designed for
        // This determines which Android features and behaviors are used
        targetSdk = 34
        
        // Version code - Internal version number for the app
        // This is used by the Play Store to determine which version is newer
        versionCode = 2
        
        // Version name - User-visible version string
        // This is what users see in the Play Store and app settings
        versionName = "2.1"

        // Test instrumentation runner - Used for running Android tests
        // This provides the test runner for Android instrumentation tests
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        
        // Vector drawables support - Enables vector drawable support
        // This allows the use of vector drawables in older Android versions
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    // Build types configuration
    buildTypes {
        // Release build type - Optimized build for production
        release {
            // Minification - Reduces app size by removing unused code
            // This helps reduce the final APK size
            isMinifyEnabled = false
            
            // ProGuard files - Code obfuscation and optimization rules
            // These files contain rules for code obfuscation and optimization
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    
    // Compile options for Java compatibility
    compileOptions {
        // Source compatibility - Java version for source code
        // This determines which Java language features can be used
        sourceCompatibility = JavaVersion.VERSION_1_8
        
        // Target compatibility - Java version for compiled bytecode
        // This determines which Java runtime features are required
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    
    // Compose compiler configuration
    composeCompiler {
        // Strong skipping mode - Enables aggressive optimization
        // This improves Compose performance by skipping unnecessary recompositions
        enableStrongSkippingMode = true
    }
    
    // Kotlin compiler options
    kotlinOptions {
        // JVM target - Target JVM version for Kotlin compilation
        // This determines which JVM features are available
        jvmTarget = "1.8"
    }
    
    // Build features configuration
    buildFeatures {
        // Compose support - Enables Jetpack Compose
        // This allows the use of Compose UI components
        compose = true
    }
    
    // Packaging options for resources
    packaging {
        resources {
            // Exclude META-INF files - Prevents conflicts with other libraries
            // These files can cause conflicts when multiple libraries include them
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

// Dependencies for the app module
dependencies {
    // Core Android dependencies
    implementation(libs.androidx.core.ktx)                    // Kotlin extensions for Android core
    implementation(libs.androidx.lifecycle.runtime.ktx)      // Lifecycle-aware components
    implementation(libs.androidx.activity.compose)          // Compose integration for activities
    implementation(platform(libs.androidx.compose.bom))      // Compose BOM for version management
    implementation(libs.androidx.ui)                         // Compose UI components
    implementation(libs.androidx.ui.graphics)                // Compose graphics components
    implementation(libs.androidx.ui.tooling.preview)        // Compose preview tools
    implementation(libs.androidx.material3)                  // Material Design 3 components
    implementation(libs.androidx.navigation.compose)         // Compose navigation
    implementation(libs.play.services.location)             // Google Play Services location
    
    // Testing dependencies
    testImplementation(libs.junit)                           // Unit testing framework
    androidTestImplementation(libs.androidx.junit)          // Android testing framework
    androidTestImplementation(libs.androidx.espresso.core)  // UI testing framework
    androidTestImplementation(platform(libs.androidx.compose.bom)) // Compose testing BOM
    androidTestImplementation(libs.androidx.ui.test.junit4) // Compose UI testing
    debugImplementation(libs.androidx.ui.tooling)           // Debug tools for Compose
    debugImplementation(libs.androidx.ui.test.manifest)      // Test manifest for Compose

    // Constraint Layout for Compose
    implementation(libs.androidx.constraintlayout.compose)  // Constraint layout for Compose

    // Splash Screen API
    implementation(libs.androidx.core.splashscreen)        // Android 12+ splash screen

    // Hilt and Dagger for dependency injection
    implementation(libs.hilt.android)                       // Hilt dependency injection
    ksp(libs.hilt.compiler)                                // Hilt annotation processor
    implementation(libs.androidx.hilt.navigation.compose)  // Hilt navigation integration

    // Coroutines for asynchronous programming
    implementation(libs.kotlinx.coroutines.android)         // Android coroutines

    // ViewModel for UI state management
    implementation(libs.androidx.lifecycle.viewmodel.ktx)  // ViewModel with Kotlin support
    implementation(libs.androidx.lifecycle.viewmodel.compose) // Compose ViewModel integration
    ksp(libs.androidx.lifecycle.compiler)                   // Lifecycle annotation processor

    // Retrofit for network calls
    implementation(libs.retrofit)                           // HTTP client library
    implementation(libs.converter.gson)                     // JSON converter for Retrofit

    // Room database (if needed for local storage)
    implementation(libs.androidx.room.runtime)              // Room database runtime
    annotationProcessor(libs.androidx.room.compiler)       // Room annotation processor
    ksp(libs.androidx.room.compiler)                       // Room KSP processor
    implementation(libs.androidx.room.ktx)                 // Room Kotlin extensions

    // Navigation runtime
    implementation(libs.androidx.navigation.runtime.ktx)    // Navigation runtime

    // Coil for image loading
    implementation(libs.coil.compose)                       // Image loading library for Compose

    // Lottie for animations
    implementation(libs.lottie.compose)                     // Animation library for Compose
}