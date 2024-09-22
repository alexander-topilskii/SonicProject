package com.ato.sonic_ui.date

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import com.ato.sonic_ui.base.button.DisplayButton
import com.ato.ui_state.base.date.UiDatePicker


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayDatePicker(
    state: UiDatePicker,
    onDismiss: () -> Unit,
    onDateChosen: (Long?) -> Unit
) {
    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = state.date)

    if (state.isShown) {
        DatePickerDialog(
            onDismissRequest = onDismiss,
            confirmButton = {
                DisplayButton(
                    state.okButton,
                    onClick = {
                        val selectedDateMillis = datePickerState.selectedDateMillis
                        selectedDateMillis?.let { millis ->
                            onDateChosen.invoke(millis)
                        }
                    }
                )
            },
            dismissButton = {
                DisplayButton(
                    state = state.cancelButton,
                    onClick = onDismiss
                )
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}