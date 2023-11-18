package com.example.placesfamilyapp.model

data class Place(
    val name: String,
    val address: String,
    val types: List<String>,

)

data class PlacesApiResponse(
    val results: List<Place>,
    val status: String
)