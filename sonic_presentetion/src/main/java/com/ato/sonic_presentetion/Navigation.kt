package com.ato.sonic_presentetion

import com.github.terrakok.modo.NavigationContainer
import com.github.terrakok.modo.multiscreen.MultiScreenState
import com.github.terrakok.modo.stack.StackScreen
import com.github.terrakok.modo.stack.StackState

interface Navigation {
    var rootNavigator: NavigationContainer<StackState>?
    var currentStackNavigator: NavigationContainer<StackState>?
    var multistackNavigator: NavigationContainer<MultiScreenState>?

    fun registerMultistackScreenContainer(screenContainer: NavigationContainer<MultiScreenState>)
    fun registerCurrentScreenContainer(screenContainer: StackScreen)
    fun registerRootScreenContainer(screenContainer: StackScreen)
}
