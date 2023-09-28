package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.traceEventStart
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {

    var title by remember { mutableStateOf(1) }
    var year by remember { mutableStateOf(1) }
    var description by remember { mutableStateOf(1) }
    var currentArtwork by remember { mutableStateOf(1) }

    var imageResource = when(currentArtwork){
        1 ->R.drawable.neymar
        2 ->R.drawable.ney
        3 ->R.drawable.messi
        4 ->R.drawable.cr7
        5 ->R.drawable.dinho
        6 ->R.drawable.debruyne
        7 ->R.drawable.haaland
        8 ->R.drawable.mbappe
        9 ->R.drawable.terstegen
        else ->R.drawable.barcelona
    }
    var titleResource = when(title){
        1 ->R.string.Neymar
        2 -> R.string.Neymar
        3 ->R.string.Messi
        4 ->R.string.Cristiano_Ronaldo
        5 ->R.string.Dinho
        6 ->R.string.De_Bruyne
        7 ->R.string.haaland
        8 ->R.string.mbappe
        9 ->R.string.ter_stegen
        else ->R.string.barcelona
    }
    var yearResource = when(year){
        1 ->R.string.Neymar_year
        2 ->R.string.neymar_two_year
        3 ->R.string.Messi_year
        4 ->R.string.cr7_year
        5 ->R.string.dinho_year
        6 ->R.string.Debruyne_year
        7 ->R.string.haaland_year
        8 ->R.string.mbappe_year
        9 ->R.string.terStegen_year
        else ->R.string.barcelona_year
    }
    var descriptionResource = when(description){
        1 ->R.string.Neymar_description
        2 ->R.string.Neymar_description_two
        3 ->R.string.Messi_description
        4 ->R.string.CR7_description
        5 ->R.string.dinho_description
        6 ->R.string.Debruyne_description
        7 ->R.string.haaland_description
        8 ->R.string.mbappe_description
        9 ->R.string.terStegen_description
        else ->R.string.barcelona_description
    }
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = "Jesús Adrián Peña - 2025513",
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.black),
            fontSize = 16.sp
        )
        ArtworkImage(
            currentArtwork = imageResource
        )
        Spacer(
            modifier = modifier.size(16.dp)
        )
        ArtworkTitle(
            title = titleResource,
            year = yearResource,
            description = descriptionResource,
        )
        Spacer(
            modifier = modifier.size(25.dp)
        )
        Row(
            modifier = modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                          if (currentArtwork>1){
                              currentArtwork--
                              title--
                              year--
                              description--
                          }else if(currentArtwork==1){
                              currentArtwork = 10
                              title = 10
                              year = 10
                              description = 10
                          }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_200)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                )
            ) {
                Text(
                    text = stringResource(id = R.string.previous),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
            Button(
                onClick = {
                    currentArtwork = 1
                    title = 1
                    year = 1
                    description = 1
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_200)),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                )
            ){
                Text(
                    text = stringResource(id = R.string.reset),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
            Button(
                onClick = {
                    currentArtwork++
                    title++
                    year++
                    description++
                    if (currentArtwork>10){
                        currentArtwork = 1
                        title = 1
                        year = 1
                        description = 1
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_200)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                ),
            ) {
                Text(
                    text = stringResource(id = R.string.next),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}

@Composable
fun ArtworkImage(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {
    Image(
        painter = painterResource(id = currentArtwork),
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes year: Int,
    @StringRes description: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.blue_100),
            fontSize = 32.sp,
        )
        Text(
            text = stringResource(id = year),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_300),
            fontSize = 16.sp,
        )
        Text(
            text = stringResource(id = description),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.black),
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}

