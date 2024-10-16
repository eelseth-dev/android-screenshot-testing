package com.example.screenshottesting

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.screenshottesting.ui.theme.ScreenshotTestingTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("algarzam", "crated from main")
        val serviceIntent =
            Intent(this@MainActivity, MyForegroundService::class.java)
        ContextCompat.startForegroundService(this@MainActivity, serviceIntent)

        lifecycleScope.launch {
            viewModel.effect.collect { data ->
                when (data) {
                    "Create" -> {
                        Log.i("algarzam", "crated from main")
//                        val serviceIntent =
//                            Intent(this@MainActivity, MyForegroundService::class.java)
//                        ContextCompat.startForegroundService(this@MainActivity, serviceIntent)
                    }

                    "Destroy" -> {
                        Log.i("algarzam", "destroyed from main")
//                        this@MainActivity.stopService(
//                            Intent(
//                                this@MainActivity,
//                                MyForegroundService::class.java
//                            )
//                        )
                    }
                }
            }
        }

        enableEdgeToEdge()
        setContent {
            ScreenshotTestingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        //setContentView(R.layout.activity_main)

    }

    override fun onDestroy() {
        super.onDestroy()
        this@MainActivity.stopService(
            Intent(
                this@MainActivity,
                MyForegroundService::class.java
            )
        )

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
            text = " None: $name!",
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