package com.example.placesfamilyapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Place(
    val name: String,
    val address: String,
    val types: List<String>,
    //add access to img here later
)

data class PlacesApiResponse(
    val results: List<Place>,
    val status: String
)