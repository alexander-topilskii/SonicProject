package com.ato.folder.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.ato.folder.component.TemplateComponent


@Composable
fun TemplateContent(
    component: TemplateComponent,
    modifier: Modifier = Modifier
) {
    val model by component.uiState.collectAsState(null)

    model?.let { data->
        Children(
            stack = component.stack,
            animation = stackAnimation(fade()),
        ) {
            when (val child = it.instance) {
//                is FollowingListChild -> FollowingListContent(child.component)
                else -> {

                }
            }
        }
    }
}
