package com.example.jetweatherapp.data

/**
 * DataOrException - Generic data wrapper class for handling API responses
 * 
 * This is a generic data class that wraps API response data along with loading state
 * and exception information. It follows the Result pattern for handling asynchronous
 * operations that can succeed or fail.
 * 
 * Generic Parameters:
 * @param T - Type of the data being wrapped (e.g., WeatherData, List<City>)
 * @param Boolean - Loading state indicator (true when loading, false when complete)
 * @param E - Type of exception that can occur (must extend Exception)
 * 
 * Purpose:
 * - Provide a consistent way to handle API responses
 * - Encapsulate loading states for UI updates
 * - Handle errors gracefully without crashing
 * - Enable reactive UI updates based on data state
 * 
 * Why this pattern is useful:
 * - Eliminates null pointer exceptions
 * - Makes error handling explicit
 * - Provides clear state management for UI
 * - Follows functional programming principles
 * 
 * Usage Example:
 * ```kotlin
 * val weatherData: DataOrException<WeatherData, Boolean, Exception> = 
 *     DataOrException(data = weather, loading = false, exception = null)
 * ```
 */
data class DataOrException<T, Boolean, E: Exception> (
    /**
     * data - The actual data returned from API call
     * 
     * This field contains the successful response data when the API call succeeds.
     * It will be null when:
     * - The API call is still in progress (loading = true)
     * - The API call failed (exception != null)
     * - No data was returned from the API
     * 
     * Type: T? (nullable generic type)
     * - Nullable because data might not be available yet
     * - Generic to support any data type
     */
    var data: T? = null,
    
    /**
     * loading - Indicates whether an API call is currently in progress
     * 
     * This boolean flag helps the UI show loading indicators while API calls
     * are being made. It's particularly useful for:
     * - Showing progress bars or spinners
     * - Disabling user interactions during loading
     * - Providing visual feedback to users
     * 
     * States:
     * - true: API call is in progress
     * - false: API call has completed (success or failure)
     * - null: Initial state before any API call
     * 
     * Type: Boolean? (nullable boolean)
     * - Nullable to distinguish between "not started" and "completed"
     */
    var loading: Boolean? = null,
    
    /**
     * exception - Contains error information when API call fails
     * 
     * This field holds exception details when something goes wrong during
     * the API call. It can contain various types of exceptions:
     * - NetworkException: No internet connection
     * - HttpException: Server returned error status code
     * - IOException: Network I/O problems
     * - Custom exceptions: App-specific errors
     * 
     * When to use:
     * - Show error messages to users
     * - Log errors for debugging
     * - Implement retry mechanisms
     * - Handle different error types differently
     * 
     * Type: E? (nullable exception type)
     * - Nullable because no exception occurred on success
     * - Generic to support different exception types
     */
    var exception: E? = null
)