package com.example.placesfamilyapp

//Why isn't this working? What needs to change? No idea...
import com.example.placesfamilyapp.BuildConfig
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
 * Created by Gauri Gadkari on 11/8/23.
 */
private val location = "37.423,-122.083"
private val radius = 5000  // 5 kilometers
private val type = "park|zoo|tourist_attraction|movie_theater|historical_landmark"
// Add your own API_KEY here
private val apiKey = BuildConfig.API_KEY

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