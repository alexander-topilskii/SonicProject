package com.ato.bottom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.github.terrakok.modo.Screen
import com.github.terrakok.modo.stack.StackNavModel
import com.github.terrakok.modo.stack.StackScreen
import kotlinx.parcelize.Parcelize

@Parcelize
class RootStack(
    private val stackNavModel: StackNavModel
) : StackScreen(stackNavModel) {

    constructor(rootScreen: Screen) : this(StackNavModel(rootScreen))

    @Composable
    override fun Content() {
        val viewModel: RootViewModel = remember {
            RootGraph.registerIn(this)
        }
        TopScreenContent()
    }
}