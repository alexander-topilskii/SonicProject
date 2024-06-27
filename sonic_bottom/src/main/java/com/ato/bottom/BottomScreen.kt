package com.ato.bottom

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
