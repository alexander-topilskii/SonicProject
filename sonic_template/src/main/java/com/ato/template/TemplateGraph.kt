package com.ato.template

import android.app.Application
import com.ato.di.DiGraphInstance
import com.ato.di.Graph
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

internal class TemplateGraph() : Graph {
    companion object {

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


}