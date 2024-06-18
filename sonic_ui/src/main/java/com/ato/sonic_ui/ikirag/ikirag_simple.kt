package com.ato.sonic_ui.ikirag

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ato.ui_state.ikirag.IkiragData

@Composable
fun IkiragData.DisplaySimple(
    modifier: Modifier = Modifier,
    onClick: (IkiragData) -> Unit = { }
) {
    Card(
        modifier = modifier.clickable { onClick.invoke(this) },
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = text,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Center)
            )
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
    ).DisplaySimple()
}