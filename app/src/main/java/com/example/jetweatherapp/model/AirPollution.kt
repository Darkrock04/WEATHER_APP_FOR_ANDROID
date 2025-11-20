package com.example.jetweatherapp.model

data class AirPollutionResponse(
    val coord: Coord? = null,
    val list: List<AirPollutionItem>? = null
)

data class AirPollutionItem(
    val main: AirPollutionMain? = null,
    val components: AirPollutionComponents? = null,
    val dt: Long? = null
)

data class AirPollutionMain(
    val aqi: Int? = null
)

data class AirPollutionComponents(
    val co: Double? = null,
    val no: Double? = null,
    val no2: Double? = null,
    val o3: Double? = null,
    val so2: Double? = null,
    val pm2_5: Double? = null,
    val pm10: Double? = null,
    val nh3: Double? = null
)
