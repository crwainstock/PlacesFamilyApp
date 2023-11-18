package com.example.placesfamilyapp.network


import com.example.placesfamilyapp.model.PlacesApiResponse
import kotlinx.serialization.json.Json
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://maps.googleapis.com/maps/api/place/"

interface PlacesApiService {
    @GET("nearbysearch/json")
    suspend fun getNearbyPlaces(
        @Query("location") location: String,
        @Query("radius") radius: Int,
        @Query("type") type: String,
        @Query("key") apiKey: String
    ): PlacesApiResponse
}

private val json = Json {
    ignoreUnknownKeys = true
}