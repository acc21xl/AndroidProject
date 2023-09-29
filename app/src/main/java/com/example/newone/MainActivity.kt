package com.example.newone

import android.graphics.Paint.Align
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.newone.ui.theme.NewOneTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.TopAppBarColors
import androidx.compose.ui.layout.ContentScale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //aabb
            NewOneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(message = "Happy Birthday Sam!", from = "From Emma")
                }
            }
        }
    }
}


@Composable
fun GreetingText(message: String, from : String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(8.dp),   //间距为8
        verticalArrangement = Arrangement.SpaceAround //used to let the comment in the center
    ) {
        Text(
            text = message,
            fontSize = 90.sp,
            lineHeight = 110.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = from,
            fontSize = 35.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)

        )
    }
}


@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.androidparty)
    Box{
        androidx.compose.foundation.Image(painter = image, contentDescription = null, contentScale = ContentScale.Crop, alpha = 0.5F)
        // contentScale 均匀缩放图片保持一定长宽比, alpha更改图片透明度，值越小透明度越高
        GreetingText(message = message,
                    from = from,
                    modifier = modifier
                        .fillMaxSize()   //make an element occupy all avaliable space
                        .padding(8.dp)
        )
    }
}


@Preview(showBackground = false, showSystemUi = true)
@Composable
fun BirthdayCardPreview() {
    NewOneTheme {
//        Greeting("James")
        GreetingImage(message = "Happy Birthday Bur9er!",from = "From Xin")
    }
}