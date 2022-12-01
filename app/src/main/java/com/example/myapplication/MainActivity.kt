package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                    SetImage()
                    SetRow()
                    SetColumn()
//                    SetButton()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Android Developer"

    )


}
@Composable
fun SetImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null,
        modifier = Modifier.requiredSize(50.dp)
    )
}

//@Composable
//fun SetButton(){
//    val context = LocalContext.current
//    Button(
//        onClick = {
//            Toast.makeText(context,"button clicked", Toast.LENGTH_SHORT).show()
//            context.startActivity(Intent(context,MainActivity::class.java))
//         },
//        modifier = Modifier
//            .wrapContentHeight()
//            .wrapContentWidth()
//            .padding(PaddingValues(top = 50.dp))
//
//    ) {
//        Text(
//            text ="button test",
//            color = colorResource(id = R.color.teal_200),
//
//        )
//    }
//}




@Composable
fun SetRow(){
    Row {
        Text(text = "text")
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            modifier = Modifier.requiredSize(100.dp)
        )

    }
}

@Composable
fun SetColumn(){
    var remembered by remember { mutableStateOf("")}
    var remembered2 by remember { mutableStateOf("")}
    Column(
        modifier = Modifier.padding(PaddingValues(top = 200.dp)),
        horizontalAlignment =  CenterHorizontally
    ) {
        TextField(value = remembered,
            onValueChange = {
                remembered = it
            },
            label = {
                Text(text = "Enter you name")
            }


        )
        TextField(value = remembered2,
            onValueChange = {
                remembered2 = it
            },
            label = {
                Text(text = "Enter you password")
            }


        )
        val context = LocalContext.current
        Button(
            onClick = {
                Toast.makeText(context,"$remembered $remembered2", Toast.LENGTH_SHORT).show()
                context.startActivity(Intent(context,MainActivity::class.java))
            },
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .padding(PaddingValues(top = 50.dp))
                .align(alignment = CenterHorizontally)

        ) {
            Text(
                text ="button test",
                color = colorResource(id = R.color.teal_200),

                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}