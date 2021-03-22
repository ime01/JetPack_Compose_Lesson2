package com.example.myjetpackcomposelesson2.navigationdrawer

import android.os.Bundle
import android.view.Surface
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myjetpackcomposelesson2.R
import dev.chrisbanes.accompanist.picasso.PicassoImage
import kotlinx.coroutines.launch

class NavigationDrawerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Surface {

                    val state = rememberScaffoldState()
                    val  coroutineScope  = rememberCoroutineScope()

                    Scaffold(
                        scaffoldState = state,
                        topBar = {
                                 TopAppBar(
                                     title = { Text(text = "Navigation Demo")},
                                     navigationIcon = { IconButton(onClick = {
                                         coroutineScope.launch{state.drawerState.open()}
                                     }) {
                                         Icon(Icons.Default.Menu, contentDescription = null)
                                     }}
                                 )


                        },
                        drawerShape = RoundedCornerShape(topEnd = 23.dp, bottomEnd = 23.dp),
                        drawerContent = { NavDrawer(state, coroutineScope)},
                        content = {
                           PicassoImage(data= imageData().random(),
                               contentDescription = "image from picasso",
                               modifier = Modifier
                                   .fillMaxWidth()
                                   .fillMaxHeight(),
                               loading = {
                                   Box(Modifier.matchParentSize()){
                                       CircularProgressIndicator(Modifier.align(Alignment.Center))
                                   }

                               },
                               error = {
                                   Image(painter = painterResource(id = R.drawable.ic_baseline_error_outline_24),
                                       contentDescription = "Error image")
                               },
                               fadeIn = true

                           )

                        })

            }
        }
    }



}