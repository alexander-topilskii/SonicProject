package com.ato.bottom

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.ato.sonic_ui.base.Display
import com.github.terrakok.modo.NavigationContainer
import com.github.terrakok.modo.Screen
import com.github.terrakok.modo.multiscreen.MultiScreen
import com.github.terrakok.modo.multiscreen.MultiScreenNavModel
import com.github.terrakok.modo.multiscreen.MultiScreenState
import kotlinx.parcelize.Parcelize

abstract class BottomScreen(
    private val navModel: MultiScreenNavModel
) : MultiScreen(navModel) {

    constructor(rootScreens: List<Screen>) : this(
        MultiScreenNavModel(
            containers = rootScreens.map { RootStack(it) },
            selected = 0
        )
    )

    @Composable
    override fun Content() {
        Scaffold(
            bottomBar = displayBottomBar(),
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                SelectedScreen()
            }
        }
    }

    @Composable
    abstract fun displayBottomBar(): @Composable () -> Unit
}
