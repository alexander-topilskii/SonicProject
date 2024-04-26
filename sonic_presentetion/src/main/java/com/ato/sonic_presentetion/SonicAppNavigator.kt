package com.ato.sonic_presentetion

import com.github.terrakok.modo.NavigationContainer
import com.github.terrakok.modo.multiscreen.MultiScreenState
import com.github.terrakok.modo.stack.StackScreen
import com.github.terrakok.modo.stack.StackState

class SonicAppNavigator : Navigation {
    override var rootNavigator: NavigationContainer<StackState>? = null
    override var currentStackNavigator: NavigationContainer<StackState>? = null
    override var multistackNavigator: NavigationContainer<MultiScreenState>? = null

    override fun registerCurrentScreenContainer(screenContainer: StackScreen) {
        currentStackNavigator = screenContainer
    }

    override fun registerRootScreenContainer(screenContainer: StackScreen) {
        rootNavigator = screenContainer
    }

    override fun registerMultistackScreenContainer(screenContainer: NavigationContainer<MultiScreenState>) {
        multistackNavigator = screenContainer
    }
}