package com.ato.sonic_ui.ikirag

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ato.sonic_ui.base.Display
import com.ato.ui_state.base.UiIcon
import com.ato.ui_state.ikirag.IkiragData


@Composable
fun IkiragData.Display(
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            val icon = remember(isLiked) {
                when (isLiked) {
                    true -> Icons.Filled.Favorite
                    false -> Icons.Filled.Clear
                    else -> null
                }
            }
            val scroll = rememberScrollState(0)
            Text(
                text = text,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Center)
                    .verticalScroll(scroll)
            )

            if (icon != null) {
                UiIcon(icon).Display(
                    Modifier
                        .padding(16.dp)
                        .align(Alignment.BottomEnd)
                )
            }
        }
    }
}

// ------------------------------------------------------------------------
// ------------------------------------------------------------------------
// ------------------------------------------------------------------------

@Preview(showBackground = true)
@Composable
private fun Preview() {
    IkiragData(
        text = """
            Не в силах нас ни смех,  ни грех 
            свернуть с пути отважного,
              мы  строим счастье сразу всех,  
            и нам плевать на каждого.
        """.trimIndent()
    ).Display()
}