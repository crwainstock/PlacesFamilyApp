package com.example.placesfamilyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.placesfamilyapp.model.Place
import com.example.placesfamilyapp.ui.theme.PlacesFamilyAppTheme



class MainActivity : ComponentActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlacesFamilyAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xf2f4f3)
                ) {
                    val placesViewModel: PlacesViewModel = viewModel()
                    PlacesFamilyApp(placesUIState = placesViewModel.placesUiState)

                }
            }
        }
    }
}
@Composable
fun BottomAppBar() {
    androidx.compose.material3.BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp) // Adjust the height as needed
            .padding(16.dp),

    ) {

        Text(
            text = "Wander Wise",
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}



@Composable
fun NearbyPlaceCard(place: Place, modifier: Modifier = Modifier) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(6.dp)){
        Column {
            Row{
                Column(modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
                ){
                    Text (
                        text = place.name,
                        modifier = Modifier
                            .padding(16.dp),
                        fontSize = 25.sp,
                        lineHeight = 26.sp,
                        textAlign = TextAlign.Left

                    )
                }

                Column(modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
                ){
//                        val star = painterResource(id = R.drawable.baseline_star_outline_24)
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star icon", modifier = Modifier
                            .height(25.dp)
                            .width(25.dp)
//                            .align(Alignment.CenterVertically)
                        )
                        Text(
                            text = place.rating.toString(),
                            modifier = Modifier.padding(16.dp),
                            fontSize = 20.sp,
                            lineHeight = 18.sp,
                            textAlign = TextAlign.Right
                        )

                }
            }
        }
    }
}

@Composable
fun PlaceList(placesList: List<Place>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(placesList) {
            place -> NearbyPlaceCard(place = place)
        }
    }
}

@Composable
fun PlacesFamilyApp(placesUIState: PlacesUiState) {
    // when statement is exhaustive -- includes all state options below
    when (placesUIState) {
        is PlacesUiState.Success -> {
            PlaceList(placesUIState.places)
        }
        is PlacesUiState.Loading -> {
            // Loading message
        }
        is PlacesUiState.Error -> {
            // Error message
        }
    }
    BottomAppBar()
}




@Preview(showBackground = true)
@Composable
fun PlacesFamilyAppPreview() {
    PlacesFamilyAppTheme {
        val placesViewModel: PlacesViewModel = viewModel()
        //Again, need to access place data here
        PlacesFamilyApp(placesUIState = placesViewModel.placesUiState)
    }
}