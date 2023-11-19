package com.example.placesfamilyapp

//Why isn't this working? What needs to change? No idea...
//import com.example.placesfamilyapp.BuildConfig
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.placesfamilyapp.model.Place
import com.example.placesfamilyapp.network.PlacesApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


/**
 * A MILLION THANKS TO Gauri Gadkari on 11/8/23 FOR SHARING SAMPLE PROJECT.
 */
private val location = "49.4521,11.0767" // Nuremberg
private val radius = 5000  // 5 kilometers
private val type = "tourist_attraction|park|zoo|museum|movie_theater"
// Add your own API_KEY here
// idk. BuildConfig is being a bitch.p
private val apiKey = "AIzaSyDKjTdwi1TdfnJTXslbm73K-hHp9mGbUDA"

sealed class PlacesUiState {
    data class Success(val places: List<Place>) : PlacesUiState()
    data class Error(val error: String) : PlacesUiState()
    object Loading : PlacesUiState()
}

class PlacesViewModel : ViewModel() {
    var placesUiState: PlacesUiState by mutableStateOf(PlacesUiState.Loading)

    init {
        viewModelScope.launch {
            placesUiState = PlacesUiState.Loading
            placesUiState = try { PlacesUiState.Success(
                PlacesApi.retrofitService.getPlaces(location, radius, type, apiKey).results
            ) } catch (e: IOException) {
                PlacesUiState.Error(e.message.toString())
            } catch (e: HttpException) {
                PlacesUiState.Error(e.message.toString())
            }
        }
    }
}