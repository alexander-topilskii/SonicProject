package com.ato.bottom

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import com.ato.sonic_repository.Database
import com.ato.ui_state.base.UiBottomBar
import com.ato.ui_state.base.UiIconText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlin.coroutines.CoroutineContext

internal class BottomRepository(
    private val database: Database,
    private val coroutineContext: CoroutineContext
) {

    fun getState(): Flow<UiBottomState> {
        return flowOf(
            UiBottomState(
                bottomBar = UiBottomBar(
                    listOf(
                        UiIconText(
                            icon = Icons.Filled.Home,
                            text = "Главная"
                        ),
                        UiIconText(
                            icon = Icons.Filled.Info,
                            text = "График"
                        ),
                        UiIconText(
                            icon = Icons.Filled.AccountCircle,
                            text = "История"
                        ),
                        UiIconText(
                            icon = Icons.Filled.DateRange,
                            text = "Календарь"
                        )
                    )
                )
            )
        )
    }
}


