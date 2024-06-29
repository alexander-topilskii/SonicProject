package com.ato.sonic_ui.base.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ato.sonic_ui.ikirag.Display
import com.ato.sonic_ui.tinder.Direction
import com.ato.sonic_ui.tinder.rememberSwipeableCardState
import com.ato.sonic_ui.tinder.swipableCard
import com.ato.ui_state.ikirag.IkiragData
import org.jetbrains.compose.ui.tooling.preview.Preview

//  TODO: не законченные
@Composable
@Preview()
fun Display(modifier: Modifier = Modifier) {
    Surface {
        items.Display({}, {}, {})
    }
}

val onePice = IkiragData(
    text = """
            Не в силах нас ни смех,  ни грех 
            свернуть с пути отважного,
              мы  строим счастье сразу всех,  
            и нам плевать на каждого.
        """.trimIndent()
)
val onePice2 = IkiragData(
    text = """
            Нсе в силах нас ни смех,  ни грех 
            свернуть с пути отважного,
              мы  строим счастье сразу всех,  
            и нам плевать на каждого.
        """.trimIndent()
)
val onePice3 = IkiragData(
    text = """
            Нсе в силах нас ни смех,  ни грех 
            свернуть с пути отважного,
              мы  строим счастье сразу всех,  
            и нам плевать на каждого...
        """.trimIndent()
)
val onePice4 = IkiragData(
    text = """
            Нсе в силах нас ни смех,  ни грех 
            свернуть с пути отважного,
              мы  строим счастье сразу всех,  
            и нам плевать на каждого..
        """.trimIndent()
)

val items: List<IkiragData> = listOf(onePice, onePice2, onePice3, onePice4)

@Composable
fun List<IkiragData>.Display(
    onLiked: (IkiragData) -> Unit,
    onDisliked: (IkiragData) -> Unit,
    onNeutral: (IkiragData) -> Unit,
) {
    val itemss = this
    val states = this.map { it to rememberSwipeableCardState() }
    LazyColumn(
        Modifier
            .background(Color.Red)
            .padding(24.dp)
            .fillMaxSize()
    ) {
        items(itemss) { item ->
            val state = states.find { it.first == item }?.second!!
            if (state.swipedDirection == null) {
                item.Display(
                    modifier = Modifier
                        .fillMaxSize()
                        .swipableCard(
                            state = state,
                            blockedDirections = listOf(Direction.Down),
                            onSwiped = {
                                when (it) {
                                    Direction.Left -> onDisliked(item)
                                    Direction.Right -> onLiked(item)
                                    Direction.Up -> onNeutral(item)
                                    else -> {}
                                }
                            }
                        ),
                )
            }
        }
    }
}
