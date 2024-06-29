package com.ato.sonic_ui.base

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.ato.ui_state.base.drop_down_menu.UiDropDownMenu
import com.ato.ui_state.base.drop_down_menu.UiDropDownMenuSamples
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview()
@Composable
fun DisplayDemo() {
    UiDropDownMenuSamples.item.Display()
}

@Composable
fun UiDropDownMenu.Display(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableIntStateOf(0) }
    Box(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier.align(Alignment.Center),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    expanded = !expanded
                }
            ) {
                Text(
                    text = items[selectedIndex],
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                )
                Icon(
                    imageVector = if (expanded) {
                        Icons.Default.KeyboardArrowUp
                    } else {
                        Icons.Default.KeyboardArrowDown
                    },
                    contentDescription = "More"
                )

            }

            DropdownMenu(
                modifier = Modifier.align(Alignment.Center),
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                items.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        modifier = Modifier.fillMaxWidth(),
                        text = {
                            Text(
                                text = text,
                                textAlign = TextAlign.Center,
                                fontWeight = if (index == selectedIndex) FontWeight.Bold else null,
                            )
                        },
                        onClick = {
                            selectedIndex = index
                            expanded = !expanded
                        }
                    )
                }
            }
        }
    }
}
