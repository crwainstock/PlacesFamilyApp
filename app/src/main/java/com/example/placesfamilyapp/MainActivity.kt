package com.example.placesfamilyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.placesfamilyapp.model.Place
import com.example.placesfamilyapp.ui.theme.PlacesFamilyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlacesFamilyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Need to figure out how to access the place here
                    NearbyPlaceCard(Place)

                }
            }
        }
    }
}


//How can I access the place here?
@Composable
fun NearbyPlaceCard(place: Place, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(6.dp)){
        Column {
            Text (
                text = place.name,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleSmall
            )

        }
    }
}



@Preview(showBackground = true)
@Composable
fun PlacesFamilyAppPreview() {
    PlacesFamilyAppTheme {
        //Again, need to access place data here
        NearbyPlaceCard(Place)
    }
}