package com.example.screenshottesting

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.absoluteValue


@Composable
fun EndlessPager(items: List<String>) {

    val max_number_of_rounds = Int.MAX_VALUE / items.size
    val first_page_index = (max_number_of_rounds / 2) * items.size

    val pageCount = Int.MAX_VALUE
    val pagerState =
        rememberPagerState(initialPage = first_page_index, pageCount = { pageCount })

    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(all = 64.dp), // Add padding for partial visibility
        modifier = Modifier.fillMaxWidth().aspectRatio(1f).background(Color.Red),
    ) { page ->
        val pageOffset = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
        val scale = remember(pageOffset) { 1f - 0.25f * pageOffset.absoluteValue }

        // Display your content for each page
        PagerItem(
            content = items[page % items.size],
            modifier = Modifier
//                .fillMaxWidth(0.4f) // Control item size
//                .aspectRatio(1f) // Ensure square items
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                },
        )
    }
}

@Composable
fun PagerItem(content: String, modifier: Modifier) {
    // Customize your page item here
    Log.i("algarzam", "PagerItemCreated: $content")
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Text(
            text = content,
            fontSize = 50.sp
        )
    }

}