package com.example.screenshottesting

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import org.junit.Rule
import org.junit.Test

class MyActivityScreenshotTest : ScreenshotTest {

    @get:Rule
    var composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun theActivityIsShownProperly() {
        compareScreenshot(composeRule.activity)
    }
}