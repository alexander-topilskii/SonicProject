package com.ato.sonic_ui.playground

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun MatrixEffect() {
    val rows = 20
    val cols = 20
    val symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%&*"
    val matrixState = remember { Array(cols) { mutableStateListOf<Int>() } }

    LaunchedEffect(Unit) {
        while (true) {
            for (col in 0 until cols) {
                if (matrixState[col].isEmpty() || Random.nextFloat() > 0.9f) {
                    matrixState[col].add(0)
                }
            }
            for (col in 0 until cols) {
                for (i in 0 until matrixState[col].size) {
                    matrixState[col][i] += 1
                }
                if (matrixState[col].isNotEmpty() && matrixState[col][0] > rows) {
                    matrixState[col].removeAt(0)
                }
            }
            delay(100)
        }
    }

    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val cellWidth = canvasWidth / cols
        val cellHeight = canvasHeight / rows

        drawIntoCanvas { canvas ->
            val paint = android.graphics.Paint().apply {
                color = android.graphics.Color.GREEN
                textSize = 12.sp.toPx()
                typeface = android.graphics.Typeface.MONOSPACE
            }
            for (col in 0 until cols) {
                for (row in matrixState[col]) {
                    val x = col * cellWidth
                    val y = row * cellHeight
                    val symbol = symbols.random()
                    canvas.nativeCanvas.drawText(symbol.toString(), x, y, paint)
                }
            }
        }
    }
}

@Composable
@Preview
fun MatrixScreen() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ) {
            MatrixEffect()
        }
    }
}
