package com.example.screenshottesting

import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import org.junit.Rule
import org.junit.Test

class ComposeScreenshotTest : ScreenshotTest {

    @get:Rule
    var composeRule = createComposeRule()

    @Test
    fun rendersGreetingMessageForTheSpecifiedPerson() {
        composeRule.setContent { Greeting("Hi Android") }
        compareScreenshot(composeRule)
    }
}