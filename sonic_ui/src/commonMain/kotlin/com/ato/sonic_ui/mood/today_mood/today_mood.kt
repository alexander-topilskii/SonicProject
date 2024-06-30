package com.ato.sonic_ui.mood.today_mood

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ato.ui_state.mood.today_mood.UiMoodItem
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun UiMoodItem.UiAddMissedMoodItem.Display(
    onClicked: (UiMoodItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
            .clickable { onClicked.invoke(this) },
        colors = CardDefaults.cardColors().copy(
            containerColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Box {
            Row(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
                verticalAlignment = CenterVertically
            ) {
                OutlinedButton(
                    onClick = { },
                    modifier = Modifier.size(80.dp),  //avoid the oval shape
                    shape = CircleShape,
                    border = BorderStroke(1.dp, Color(circleColor)),
                    contentPadding = PaddingValues(0.dp),  //avoid the little icon
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(circleColor))
                ) {
                    Icon(Icons.Default.Add, contentDescription = "content description")
                }
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    addMoodText,
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

@Preview()
@Composable
private fun Preview() {
    UiMoodItem.UiAddMissedMoodItem(
        addMoodText = "Добавить настроение",
        circleColor = Color.White.value.toLong(),
    ).Display(onClicked = {})
}
