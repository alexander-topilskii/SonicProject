package com.ato.sonic_ui.base.circle

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ato.ui_state.base.circle.UiGradientCircle
import com.ato.ui_state.base.circle.UiSimpleFilledCircle
import com.ato.ui_state.base.circle.UiSimpleOutlinedCircle

@Composable
internal fun UiSimpleFilledCircle.Display(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier, onDraw = {
        drawCircle(
            color = Color(color)
        )
    })
}

@Composable
internal fun UiSimpleOutlinedCircle.Display(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier, onDraw = {
        drawCircle(
            color = Color(color),
            style = Stroke(width)
        )
    })
}

@Composable
internal fun UiGradientCircle.Display(
    brush: Brush,
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier,
        onDraw = {
            drawCircle(brush)
        }
    )
}

//---------------------------------
//------------Preview--------------
//---------------------------------

@Preview(showBackground = true)
@Composable
internal fun UiSimpleFilledCirclePreview() {
    UiSimpleFilledCircle(
        color = Color.Red.value.toLong()
    ).Display(
        Modifier.size(100.dp)
    )
}

@Preview(showBackground = true)
@Composable
internal fun UiSimpleOutlinedCirclePreview() {
    UiSimpleOutlinedCircle(
        color = Color.Red.value.toLong(),
        width = 12f
    ).Display(
        Modifier.size(100.dp)
    )
}

@Preview(showBackground = true)
@Composable
internal fun UiGradientCirclePreview() {
    val brush: Brush = getBrush(
        colors = listOf(
            Color.Yellow,
            Color.Red,
        ),
        size = 150.dp
    )

    UiGradientCircle(
        colors = listOf(
            Color.Yellow.value.toLong(),
            Color.Red.value.toLong(),
        )
    ).Display(
        brush,
        Modifier
            .size(150.dp)
            .padding(24.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun Deemi(fontSize: TextUnit = 16.sp) = Column(
    Modifier.verticalScroll(rememberScrollState())
) {
//    Text(
//        fontSize = 64.sp,
//        text = LoremIpsum(32).values.joinToString(" "),
//        style = TextStyle(
//            brush = getBrush(
//                listOf(
//                    Color.Yellow,
//                    Color.Red,
//                )
//            )
//        )
//    )
}

@Composable
fun getBrush(colors: List<Color>, size: Dp): Brush {
    val currentFontSizePx = with(LocalDensity.current) { size.toPx() }
    val currentFontSizeDoublePx = currentFontSizePx * 2

    val infiniteTransition = rememberInfiniteTransition(label = "")
    val offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = currentFontSizeDoublePx,
        animationSpec = infiniteRepeatable(tween(5000, easing = FastOutSlowInEasing)),
        label = ""
    )

    return Brush.linearGradient(
        colors = colors,
        start = Offset(offset, offset),
        end = Offset(offset + currentFontSizePx, offset + currentFontSizePx),
        tileMode = TileMode.Mirror
    )
}