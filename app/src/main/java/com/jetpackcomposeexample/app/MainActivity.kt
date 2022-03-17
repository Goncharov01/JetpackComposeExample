package com.jetpackcomposeexample.app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.jetpackcomposeexample.app.ui.theme.JetpackComposeExampleTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.jetpackcomposeexample.app.ui.theme.OrangeColor

class MainActivity : ComponentActivity() {

    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            MyScreen()

        }
    }
}

@Composable
fun MyScreen2() {

    Column(
        modifier = Modifier
            .background(Color(0xFF321500))
            .fillMaxSize()
    ) {}

}

@Composable
fun MyScreen() {

    val state = remember {
        mutableStateOf(true)
    }

    if (state.value) {

        Column(
            modifier = Modifier
                .background(Color(0xFF321500))
                .fillMaxSize()
        ) {

            Column() {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1F),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        "Jetpack\nCompose",
                        fontSize = 58.sp,
                        textAlign = TextAlign.Center,
                        color = OrangeColor,
                        modifier = Modifier.fillMaxWidth(),
                        fontFamily = FontFamily(Font(R.font.tourney_semi_bold))
                    )

                }

                Button(
                    onClick = { state.value = false }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    shape = RoundedCornerShape(45),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = OrangeColor,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Сlick Me", fontSize = 25.sp, textAlign = TextAlign.Center)
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1F),
                    contentAlignment = Alignment.Center
                ) {

                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.image_compose),
                        contentDescription = "JetCompose",
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    )
                }
            }
        }

    } else {

        MyScreen2()

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeExampleTheme {
        MyScreen()
    }
}