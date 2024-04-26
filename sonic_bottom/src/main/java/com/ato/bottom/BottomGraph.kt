package com.ato.bottom

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.ato.di.DiGraphInstance
import com.ato.di.Graph
import com.ato.sonic_presentetion.Navigation
import com.ato.sonic_repository.Database
import com.ato.sonic_repository.RepositoryDependencies
import com.github.terrakok.modo.NavigationContainer
import com.github.terrakok.modo.multiscreen.MultiScreenState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

internal class BottomGraph(private val screenContainer: NavigationContainer<MultiScreenState>) : Graph {
    companion object {

        fun registerIn(screenContainer: NavigationContainer<MultiScreenState>): BottomViewModel {
            return DiGraphInstance
                .registerGraph(name)
                { BottomGraph(screenContainer) }.viewModel
        }

        const val name: String = "BottomGraph"
    }

    private lateinit var app: Application

    override fun putApp(a: Any) { // TODO: rename me?
        app = a as Application
    }

    // common
    private val coroutineContext by lazy { Dispatchers.IO }
    val coroutineScope by lazy { CoroutineScope(coroutineContext) }

    // repository
    private val driver: SqlDriver by lazy { AndroidSqliteDriver(Database.Schema, app, "test.db") }
    private val repositoryDependencies by lazy { RepositoryDependencies(driver) }
    private val database by lazy { repositoryDependencies.database }

    private val repository: BottomRepository by lazy {
        BottomRepository(
            database = database,
            coroutineContext = coroutineContext
        )
    }

    private val navigation: Navigation by lazy {
        (app as Navigation).also {
            it.registerMultistackScreenContainer(screenContainer)
        }
    }

    val viewModel by lazy {
        BottomViewModel(
            coroutineContext = coroutineContext,
            repository = repository,
            navigation = navigation
        )
    }
}