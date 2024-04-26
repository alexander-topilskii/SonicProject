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
import com.github.terrakok.modo.Screen
import com.github.terrakok.modo.multiscreen.MultiScreen
import com.github.terrakok.modo.multiscreen.MultiScreenNavModel
import kotlinx.parcelize.Parcelize

@Parcelize
class BottomScreen(
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
        val viewModel: BottomViewModel = remember { BottomGraph.registerIn(this) }

        val state by viewModel.state.collectAsState(null)
        Scaffold(
            bottomBar = {
                state?.bottomBar?.Display(viewModel::onItemClicked)
            },
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                SelectedScreen()
            }
        }

    }
}
