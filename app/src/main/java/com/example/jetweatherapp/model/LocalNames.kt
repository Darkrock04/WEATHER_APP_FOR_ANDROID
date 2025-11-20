package com.example.jetweatherapp.model

/**
 * LocalNames - Data class representing location names in multiple languages
 * 
 * This data class contains the name of a location in various languages
 * and scripts. It's used in geocoding API responses to provide
 * localized names for international users.
 * 
 * Purpose:
 * - Parse localized names from geocoding API responses
 * - Provide structured access to multilingual location names
 * - Enable type-safe internationalization
 * - Support global accessibility and user experience
 * 
 * Key Features:
 * - Names in multiple languages and scripts
 * - Non-nullable fields for reliable data
 * - Comprehensive language coverage
 * - Support for various writing systems
 * 
 * Why non-nullable fields:
 * - These fields are always present when available
 * - They're essential for internationalization
 * - Ensures reliable multilingual support
 * - Prevents null pointer exceptions
 */
data class LocalNames(
    /**
     * ar - Arabic name of the location
     * 
     * Contains the location name written in Arabic script.
     * Used for Arabic-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Arabic
     * - Used for Arabic language support
     * - Important for Middle Eastern users
     * - Essential for Arabic accessibility
     */
    val ar: String,
    
    /**
     * cs - Czech name of the location
     * 
     * Contains the location name in Czech language.
     * Used for Czech-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Czech
     * - Used for Czech language support
     * - Important for Czech users
     * - Essential for Czech accessibility
     */
    val cs: String,
    
    /**
     * de - German name of the location
     * 
     * Contains the location name in German language.
     * Used for German-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in German
     * - Used for German language support
     * - Important for German users
     * - Essential for German accessibility
     */
    val de: String,
    
    /**
     * en - English name of the location
     * 
     * Contains the location name in English language.
     * Used as the primary international language.
     * 
     * Type: String (non-nullable)
     * - Location name in English
     * - Used as primary international language
     * - Important for global users
     * - Essential for English accessibility
     */
    val en: String,
    
    /**
     * es - Spanish name of the location
     * 
     * Contains the location name in Spanish language.
     * Used for Spanish-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Spanish
     * - Used for Spanish language support
     * - Important for Spanish users
     * - Essential for Spanish accessibility
     */
    val es: String,
    
    /**
     * fa - Persian name of the location
     * 
     * Contains the location name in Persian (Farsi) language.
     * Used for Persian-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Persian
     * - Used for Persian language support
     * - Important for Persian users
     * - Essential for Persian accessibility
     */
    val fa: String,
    
    /**
     * fr - French name of the location
     * 
     * Contains the location name in French language.
     * Used for French-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in French
     * - Used for French language support
     * - Important for French users
     * - Essential for French accessibility
     */
    val fr: String,
    
    /**
     * he - Hebrew name of the location
     * 
     * Contains the location name in Hebrew script.
     * Used for Hebrew-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Hebrew
     * - Used for Hebrew language support
     * - Important for Hebrew users
     * - Essential for Hebrew accessibility
     */
    val he: String,
    
    /**
     * hi - Hindi name of the location
     * 
     * Contains the location name in Hindi language.
     * Used for Hindi-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Hindi
     * - Used for Hindi language support
     * - Important for Hindi users
     * - Essential for Hindi accessibility
     */
    val hi: String,
    
    /**
     * ja - Japanese name of the location
     * 
     * Contains the location name in Japanese language.
     * Used for Japanese-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Japanese
     * - Used for Japanese language support
     * - Important for Japanese users
     * - Essential for Japanese accessibility
     */
    val ja: String,
    
    /**
     * kn - Kannada name of the location
     * 
     * Contains the location name in Kannada language.
     * Used for Kannada-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Kannada
     * - Used for Kannada language support
     * - Important for Kannada users
     * - Essential for Kannada accessibility
     */
    val kn: String,
    
    /**
     * ko - Korean name of the location
     * 
     * Contains the location name in Korean language.
     * Used for Korean-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Korean
     * - Used for Korean language support
     * - Important for Korean users
     * - Essential for Korean accessibility
     */
    val ko: String,
    
    /**
     * ks - Kashmiri name of the location
     * 
     * Contains the location name in Kashmiri language.
     * Used for Kashmiri-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Kashmiri
     * - Used for Kashmiri language support
     * - Important for Kashmiri users
     * - Essential for Kashmiri accessibility
     */
    val ks: String,
    
    /**
     * ky - Kyrgyz name of the location
     * 
     * Contains the location name in Kyrgyz language.
     * Used for Kyrgyz-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Kyrgyz
     * - Used for Kyrgyz language support
     * - Important for Kyrgyz users
     * - Essential for Kyrgyz accessibility
     */
    val ky: String,
    
    /**
     * ml - Malayalam name of the location
     * 
     * Contains the location name in Malayalam language.
     * Used for Malayalam-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Malayalam
     * - Used for Malayalam language support
     * - Important for Malayalam users
     * - Essential for Malayalam accessibility
     */
    val ml: String,
    
    /**
     * mr - Marathi name of the location
     * 
     * Contains the location name in Marathi language.
     * Used for Marathi-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Marathi
     * - Used for Marathi language support
     * - Important for Marathi users
     * - Essential for Marathi accessibility
     */
    val mr: String,
    
    /**
     * pa - Punjabi name of the location
     * 
     * Contains the location name in Punjabi language.
     * Used for Punjabi-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Punjabi
     * - Used for Punjabi language support
     * - Important for Punjabi users
     * - Essential for Punjabi accessibility
     */
    val pa: String,
    
    /**
     * ru - Russian name of the location
     * 
     * Contains the location name in Russian language.
     * Used for Russian-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Russian
     * - Used for Russian language support
     * - Important for Russian users
     * - Essential for Russian accessibility
     */
    val ru: String,
    
    /**
     * sr - Serbian name of the location
     * 
     * Contains the location name in Serbian language.
     * Used for Serbian-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Serbian
     * - Used for Serbian language support
     * - Important for Serbian users
     * - Essential for Serbian accessibility
     */
    val sr: String,
    
    /**
     * ta - Tamil name of the location
     * 
     * Contains the location name in Tamil language.
     * Used for Tamil-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Tamil
     * - Used for Tamil language support
     * - Important for Tamil users
     * - Essential for Tamil accessibility
     */
    val ta: String,
    
    /**
     * tt - Tatar name of the location
     * 
     * Contains the location name in Tatar language.
     * Used for Tatar-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Tatar
     * - Used for Tatar language support
     * - Important for Tatar users
     * - Essential for Tatar accessibility
     */
    val tt: String,
    
    /**
     * uk - Ukrainian name of the location
     * 
     * Contains the location name in Ukrainian language.
     * Used for Ukrainian-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Ukrainian
     * - Used for Ukrainian language support
     * - Important for Ukrainian users
     * - Essential for Ukrainian accessibility
     */
    val uk: String,
    
    /**
     * ur - Urdu name of the location
     * 
     * Contains the location name in Urdu language.
     * Used for Urdu-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Urdu
     * - Used for Urdu language support
     * - Important for Urdu users
     * - Essential for Urdu accessibility
     */
    val ur: String,
    
    /**
     * zh - Chinese name of the location
     * 
     * Contains the location name in Chinese language.
     * Used for Chinese-speaking users and regions.
     * 
     * Type: String (non-nullable)
     * - Location name in Chinese
     * - Used for Chinese language support
     * - Important for Chinese users
     * - Essential for Chinese accessibility
     */
    val zh: String
)