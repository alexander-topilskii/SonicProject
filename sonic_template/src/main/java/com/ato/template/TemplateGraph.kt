package com.ato.template

import android.app.Application
import com.ato.di.DiGraphInstance
import com.ato.di.Graph
import com.ato.sonic_presentetion.Navigation
import com.github.terrakok.modo.stack.StackScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

internal class TemplateGraph(private val screenContainer: StackScreen) : Graph {
    companion object {

        fun registerIn(screenContainer: StackScreen): TemplateViewModel {
           return DiGraphInstance
                .registerGraph(name)
                { TemplateGraph(screenContainer) }.viewModel
        }

        val name: String = TemplateGraph::class.simpleName.orEmpty()
    }

    private lateinit var app: Application

    override fun putApp(a: Any) { // TODO: rename me?
        app = a as Application
    }

    // common
    private val coroutineContext by lazy { Dispatchers.IO }
    val coroutineScope by lazy { CoroutineScope(coroutineContext) }

    // repository

    private val repository: TemplateRepository by lazy {
        TemplateRepository(
            coroutineContext = coroutineContext
        )
    }


    private val navigation: Navigation by lazy {
        (app as Navigation).also {
            it.registerCurrentScreenContainer(screenContainer)
        }
    }

    val viewModel by lazy {
        TemplateViewModel(
            coroutineContext = coroutineContext,
            repository = repository,
            navigation = navigation
        )
    }
}