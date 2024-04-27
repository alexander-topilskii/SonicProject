package com.ato.ui_state.tinder

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ato.sonic_ui.tinder.rememberSwipeableCardState
import com.ato.sonic_ui.tinder.swipableCard

@Composable
private fun ProfileCard(
    modifier: Modifier,
) {
    AsyncImage(
        model = "https://example.com/image.jpg",
        contentDescription = "Translated description of what the image contains"
    )

    Card(modifier) {
        Box {
            Column(Modifier.align(Alignment.BottomStart)) {
                Text(
                    text = "name",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun display() {
    val states = listOf("aaa", "vvvv", "cccc").reversed()
        .map { it to rememberSwipeableCardState() }
    var hint by remember {
        mutableStateOf("Swipe a card or press a button below")
    }

    Box(
        Modifier
            .padding(24.dp)
            .fillMaxSize()
            .aspectRatio(1f)
    ) {

        states.forEach { (matchProfile, state) ->
            if (state.swipedDirection == null) {
                ProfileCard(
                    modifier = Modifier
                        .fillMaxSize()
                        .swipableCard(
                            state = state,
                            blockedDirections = listOf(com.ato.sonic_ui.tinder.Direction.Down),
                            onSwiped = {
                                // swipes are handled by the LaunchedEffect
                                // so that we track button clicks & swipes
                                // from the same place
                            },
                            onSwipeCancel = {
                                Log.d("Swipeable-Card", "Cancelled swipe")
                                hint = "You canceled the swipe"
                            }
                        ),
                )
            }
            LaunchedEffect(matchProfile, state.swipedDirection) {
                if (state.swipedDirection != null) {
                    hint = "You swiped ${(state.swipedDirection!!)}"
                }
            }
        }
    }
}