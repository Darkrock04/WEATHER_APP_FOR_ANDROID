package com.example.jetweatherapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetweatherapp.model.AirPollutionResponse

@Composable
fun AirPollutionCard(airPollution: AirPollutionResponse) {
    val aqi = airPollution.list?.firstOrNull()?.main?.aqi ?: 0
    val components = airPollution.list?.firstOrNull()?.components

    val (aqiText, aqiColor) = when (aqi) {
        1 -> "Good" to Color(0xFF4CAF50)
        2 -> "Fair" to Color(0xFF8BC34A)
        3 -> "Moderate" to Color(0xFFFFC107)
        4 -> "Poor" to Color(0xFFFF9800)
        5 -> "Very Poor" to Color(0xFFF44336)
        else -> "Unknown" to Color.Gray
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.2f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Air Quality Index",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "$aqi",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = aqiColor
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = aqiText,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    color = aqiColor
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            if (components != null) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    PollutantItem("CO", components.co)
                    PollutantItem("NO2", components.no2)
                    PollutantItem("O3", components.o3)
                    PollutantItem("PM2.5", components.pm2_5)
                }
            }
        }
    }
}

@Composable
fun PollutantItem(name: String, value: Double?) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = name,
            style = MaterialTheme.typography.bodySmall,
            color = Color.White.copy(alpha = 0.7f)
        )
        Text(
            text = String.format("%.1f", value ?: 0.0),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}
