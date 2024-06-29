package com.ato.sonic_ui.base.card

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

//  TODO: не законченные
@Composable
@Preview
fun CardStackScreen() {
    val cardItems =
        remember { mutableStateListOf("Card 1", "Card 2", "Card 3", "Card 4", "Card 5") }
    var topCardIndex by remember { mutableStateOf(0) }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        if (topCardIndex < cardItems.size) {
            itemsIndexed(cardItems.subList(topCardIndex, cardItems.size)) { index, item ->
                if (index == 0) {
                    TopCard(item) {
                        topCardIndex++
                    }
                } else {
//                    CardItem(item)
                }
            }
        }
    }
}

@Composable
fun TopCard(item: String, onSwiped: () -> Unit) {
    var offsetX by remember { mutableStateOf(0f) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.Red)
            .height(200.dp)
            .offset { IntOffset(offsetX.toInt(), 0) }
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragEnd = {
                        if (offsetX > 300 || offsetX < -300) {
                            onSwiped()
                        }
                        offsetX = 0f
                    }
                ) { change, dragAmount ->
                    offsetX += dragAmount.x
                    change.consume()
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(text = item, color = Color.White, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun CardItem(item: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.Blue)
            .height(200.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = item, color = Color.White, style = MaterialTheme.typography.bodyMedium)
    }
}