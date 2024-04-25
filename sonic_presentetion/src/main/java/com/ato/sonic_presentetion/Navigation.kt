package com.ato.sonic_presentetion

import com.github.terrakok.modo.NavigationContainer
import com.github.terrakok.modo.multiscreen.MultiScreenState
import com.github.terrakok.modo.stack.StackScreen
import java.util.Calendar

interface Navigation {
    fun registerMultistackScreenContainer(screenContainer: NavigationContainer<MultiScreenState>)
    fun registerCurrentScreenContainer(screenContainer: StackScreen)
    fun registerRootScreenContainer(screenContainer: StackScreen)

    fun forwardMoodEnergyItem(moodId: Long)
    fun openTab(index: Int)
    fun forwardAddMood(time: Calendar)
    fun back()
}