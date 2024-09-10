import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.screenshottesting.Greeting
import com.example.screenshottesting.ui.theme.ScreenshotTestingTheme

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScreenshotTestingTheme {
        Greeting("Android")
    }
}