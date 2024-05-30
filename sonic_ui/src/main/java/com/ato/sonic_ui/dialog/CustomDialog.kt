package com.ato.sonic_ui.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Preview(showBackground = true)
@Composable
fun CustomDialog(show: Boolean, content: @Composable ((Boolean) -> Unit) -> Unit) {
    var showDialog by remember { mutableStateOf(show) }

    // Обновляем showDialog, если параметр show изменяется
    LaunchedEffect(show) { showDialog = show }

    // Проверяем, нужно ли показывать диалог
    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            // Дизайн для диалога
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp), // Скругленные углы
                shadowElevation = 8.dp // Тень под диалогом
            ) {
                val onShow: (Boolean) -> Unit = { showDialog = it }

                content(onShow)
            }
        }
    }
}

@Composable
fun SampleDialogContent(onShow: (Boolean) -> Unit) {

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Custom Dialog", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(20.dp))
        Text("This is a custom-designed dialog in Jetpack Compose.")
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextButton(
                onClick = { onShow(false) }
            ) {
                Text("Cancel")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { onShow(false) }
            ) {
                Text("OK")
            }
        }
    }

}
