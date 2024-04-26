package com.ato.bottom

import android.app.Application
import com.ato.di.DiGraphInstance
import com.ato.di.Graph
import com.ato.sonic_presentetion.Navigation
import com.github.terrakok.modo.stack.StackScreen

internal class RootGraph(
    private val screenContainer: StackScreen
) : Graph {
    companion object {

        fun registerIn(
            screenContainer: StackScreen
        ): RootViewModel {
            return DiGraphInstance.registerGraph(name) {
                RootGraph(screenContainer)
            }.viewModel
        }

        val name: String = RootGraph::class.simpleName.orEmpty()
    }

    private lateinit var app: Application

    override fun putApp(a: Any) { // TODO: rename me?
        app = a as Application
    }


    private val navigation: Navigation by lazy {
        (app as Navigation).also {
            it.registerRootScreenContainer(screenContainer)
        }
    }

    val viewModel by lazy {
        RootViewModel(navigation)
    }
}