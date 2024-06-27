package com.ato.sonic_ui.mood.today_mood

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ato.ui_state.mood.today_mood.UiMoodItem

@Composable
fun UiMoodItem.UiOldMoodItem.Display(onClicked: (UiMoodItem) -> Unit, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
            .clickable { onClicked.invoke(this) },
        colors = CardDefaults.cardColors().copy(
            containerColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Box {
            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(4.dp)
                    .align(Alignment.TopEnd),
                colors = CardDefaults.cardColors().copy(
                    containerColor = MaterialTheme.colorScheme.onSecondaryContainer
                )
            ) {
                Text(
                    maxLines = 1,
                    fontSize = 14.sp,
                    text = timeText,
                    color = Color.White,
                    textAlign = TextAlign.End,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 2.dp, bottom = 2.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Canvas(
                    modifier = Modifier.size(80.dp),
                    onDraw = {
                        drawCircle(
                            Brush.radialGradient(
                                colors = circleColors.map { Color(it) }
                            )
                        )
                    }
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    moodText,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
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
    UiMoodItem.UiOldMoodItem(
        moodText = "Нормальное",
        timeText = "Утро 4:00 AM",
        circleColors = listOf(
            0xFFDDB093,
            0xFFC578E6,
        )
    ).Display({})
}
