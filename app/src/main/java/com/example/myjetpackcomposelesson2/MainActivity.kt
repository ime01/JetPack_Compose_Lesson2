package com.example.myjetpackcomposelesson2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetpackcomposelesson2.ui.theme.MyJetPackComposeLesson2Theme
//import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.Green) {
                    LoadUi()
            }
        }
    }

   @Composable
   fun LoadUi(){
       val context = LocalContext.current

       val memoryData = remember{ mutableStateOf(MemoryData())}
       memoryData.value = listOfData()[0]

       val quoteSize = remember{ mutableStateOf(15)}



       Column(modifier = Modifier.fillMaxWidth()) {

           TopAppBar(title = { Text(text = "Picture Book") })

           Card(modifier = Modifier.padding(10.dp).fillMaxWidth().shadow(5.dp)) {

               Row() {

                   Text(text = "Ramdom words and pictures", color = Color.Gray, modifier = Modifier
                       .padding(all = 10.dp)
                       .align(Alignment.CenterVertically))

                   Button(onClick = {
                                    when{
                                        listOfData().indexOf(memoryData.value) == listOfData().size-1->{

                                            memoryData.value = listOfData()[0]
                                            Toast.makeText(context, "You've gotten to the end of the Array", Toast.LENGTH_LONG).show()

                                        }
                                        else->{
                                            memoryData.value = listOfData()[listOfData().indexOf(memoryData.value) + 1]
                                        }
                                    }
                   },
                       Modifier
                           .padding(10.dp)
                           .fillMaxWidth()) {

                       Text(text = "CHANGE", color = Color.White, modifier = Modifier
                           .padding(all = 10.dp)
                           .align(Alignment.CenterVertically))

                   }

               }
           }



           Card(modifier = Modifier
               .padding(10.dp)
               .fillMaxWidth()
               .shadow(5.dp)){

               Column() {
                   Image(painter = painterResource(id = memoryData.value.aImageRes), contentDescription = "images")
                   Text(text = memoryData.value.words, modifier = Modifier.padding(5.dp), color = Color.DarkGray, fontSize = quoteSize.value.sp)

               }
           }


           Button(onClick = {quoteSize.value = quoteSize.value + 1 },
               Modifier
                   .padding(all = 10.dp)
                   .fillMaxWidth()) {

               Text(text = "Increase Font Size", color = Color.White)

           }


           Button(onClick = {quoteSize.value = quoteSize.value - 1 },
               Modifier
                   .padding(all = 10.dp)
                   .fillMaxWidth()) {

               Text(text = "Decrease Font Size", color = Color.White)

           }






       }
   }


}

