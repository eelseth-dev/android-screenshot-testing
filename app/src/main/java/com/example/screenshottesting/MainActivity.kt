package com.example.screenshottesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.screenshottesting.ui.theme.ScreenshotTestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScreenshotTestingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
//                        EndlessPager(
//                            items = listOf("A", "B", "C")
//                        )
                        val steps = 10
                        val currentStep = 3
                        Box(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Box(
                                Modifier
                                    .padding(vertical = 2.dp)
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .clip(shape = RoundedCornerShape(4.dp))
                                    .background(Color.Red)
                            )
                            Canvas(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                            ) {
                                val borderWidth = 4.dp.toPx() // Convert dp to pixels
                                val cornerRadius = 4.dp.toPx() // Corner radius in pixels

                                // Define the size of the rectangle
                                val rectWidth = (size.width / steps)
                                val rectHeight = size.height

                                (1 until steps).forEach {
                                    drawLine(
                                        color = Color.White,
                                        start = Offset((size.width / steps) * it, borderWidth / 2),
                                        end = Offset(
                                            (size.width / steps) * it,
                                            size.height - borderWidth / 2
                                        ),
                                        strokeWidth = 2.dp.toPx()
                                    )
                                }

                                // Draw a rounded rectangle border
                                drawRoundRect(
                                    color = Color.Blue, // Border color
                                    topLeft = Offset((size.width / steps) * (currentStep - 1), 0f),
                                    size = Size(rectWidth, rectHeight),
                                    cornerRadius = CornerRadius(cornerRadius, cornerRadius),
                                    style = Stroke(width = borderWidth) // Stroke style for the border
                                )
                            }
                        }


                    }

                }
            }
        }

        //setContentView(R.layout.activity_main)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello: $name!",
            style = TextStyle(color = Color.Red, fontSize = 25.sp),
            modifier = modifier
        )
        Text(
            text = "None: $name!",
            style = TextStyle(color = Color.Red, fontSize = 25.sp),
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScreenshotTestingTheme {
        Greeting("Android")
    }
}