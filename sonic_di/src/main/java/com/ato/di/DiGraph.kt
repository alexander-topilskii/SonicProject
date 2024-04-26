package com.ato.di

interface DiGraph {

    val graphes: MutableMap<String, Graph>

    /*
override val graphes = mutableMapOf<String, Graph>()
val set = mutableSetOf<Any>()
init {DiGraphInstance.graphHolder = this}
     */
}

interface Graph {
    fun putApp(a: Any)
}

// TODO: сделать наследником + делегирование
object DiGraphInstance {
    lateinit var graphHolder: DiGraph

    fun <T : Graph> registerGraph(name: String, graphFactory: () -> T): T {
        val graph = graphHolder.graphes[name]
        if (graph == null) {
            graphHolder.graphes[name] = graphFactory()
            val graph = graphHolder.graphes[name] as T
            graph.putApp(graphHolder)
            return graph
        }
        return graph as T
    }
}