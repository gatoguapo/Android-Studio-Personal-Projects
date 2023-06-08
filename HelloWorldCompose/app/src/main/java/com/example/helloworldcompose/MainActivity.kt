package com.example.helloworldcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.helloworldcompose.ui.theme.HelloWorldComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloApp()
        }
    }
}

@Preview
@Composable
fun HelloApp() {
    HelloWorldComposeTheme {
        // A surface container using the 'background' color from the theme {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan)
        ) {
            item {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                    painter = painterResource(id = R.drawable.img_yop),
                    contentDescription = null
                )
                DefaultPreview()
                ExampleModifier()
                SecondPreview()
                Rows()
            }
        }
    }

}


@Composable
private fun ExampleModifier() {
    Text(
        text = "No Ramirez",
        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, start = 16.dp),
        color = Color.Magenta,
        fontSize = 16.sp
    )
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hola $name!",
        fontSize = 30.sp,
        color = Color.Magenta,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun DefaultPreview() {
    HelloWorldComposeTheme {
        Greeting("Ramirez")
    }
}

@Composable
fun SecondPreview() {
    HelloWorldComposeTheme {
        Text(
            text = "Adios Ramirez!!",
            modifier = Modifier.padding(start = 16.dp),
            color = Color.Magenta,
            fontSize = 16.sp
        )
    }
}

@Composable
fun Rows() {
    LazyRow(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp ,start = 16.dp, end = 16.dp)
    ) {
        item {
            Text(text = "Stack:", color = Color.Magenta)
        }
        item {
            Text(text = "Java", color = Color.Magenta)
        }
        item {
            Text(text = "Kotlin", color = Color.Magenta)
        }
        item {
            Text(text = "RAMIREZ", color = Color.Magenta)
        }
        item {
            Text(text = "RAMIREZ", color = Color.Magenta)
        }
        item {
            Text(text = "RAMIREZ", color = Color.Magenta)
        }
        item {
            Text(text = "RAMIREZ", color = Color.Magenta)
        }
        item {
            Text(text = "RAMIREZ", color = Color.Magenta)
        }
        item {
            Text(text = "RAMIREZ", color = Color.Magenta)
        }
        item {
            Text(text = "RAMIREZ", color = Color.Magenta)
        }
        item {
            Text(text = "RAMIREZ", color = Color.Magenta)
        }
        item {
            Text(text = "RAMIREZ", color = Color.Magenta)
        }
    }
}