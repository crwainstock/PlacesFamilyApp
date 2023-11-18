package com.example.placesfamilyapp.network


import com.example.placesfamilyapp.model.PlacesApiResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
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

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    .build()

object PlacesApi {
    val retrofitService : PlacesApiService by lazy {
        retrofit.create(PlacesApiService::class.java)
    }
}