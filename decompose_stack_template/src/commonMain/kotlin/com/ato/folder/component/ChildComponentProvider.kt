package com.ato.folder.component

import com.arkivanov.decompose.ComponentContext

internal class ChildComponentProvider(
) {

    fun child(
        config: TemplateComponent.Config,
        componentContext: ComponentContext
    ): TemplateComponent.Child =
        when (config) {
//            is FollowingList -> FollowingListChild(
//                followingListComponent(
//                    componentContext,
//                    config
//                )
//            )
            else -> TODO()
        }


//    private fun followingListComponent(
//        componentContext: ComponentContext,
//        config: FollowingList
//    ): FollowingListComponent = DefaultFollowingListComponent(
//        componentContext = componentContext,
//        appContainer = appContainer,
//        onFollowingClicked = onFollowingClicked,
//        onSearchClicked = onSearchClicked
//    )
}