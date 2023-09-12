package com.mzazi.testingappyxnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.components.backstack.BackStackModel
import com.bumble.appyx.components.backstack.operation.pop
import com.bumble.appyx.components.backstack.operation.push
import com.bumble.appyx.components.backstack.ui.slider.BackStackSlider
import com.bumble.appyx.navigation.composable.AppyxComponent
import com.bumble.appyx.navigation.modality.BuildContext
import com.bumble.appyx.navigation.node.Node
import com.bumble.appyx.navigation.node.ParentNode
import com.bumble.appyx.navigation.node.node

class RootNode(
    buildContext: BuildContext,
    private val backStack: BackStack<NavTarget> = BackStack(
        model = BackStackModel(
            initialTarget = NavTarget.Child1,
            savedStateMap = buildContext.savedStateMap,
        ),
        motionController = { BackStackSlider(it) }
    )) : ParentNode<NavTarget>(
    buildContext = buildContext,
    appyxComponent = backStack // pass it here
) {
    @Composable
    override fun View(modifier: Modifier) {
        Column {
            Text("Hello World!")
            // Let's also add some controls so we can test it
            Row {
                TextButton(onClick = { backStack.push(NavTarget.Child1) }) {
                    Text(text = "Push child 1")
                }
                TextButton(onClick = { backStack.push(NavTarget.Child2) }) {
                    Text(text = "Push child 2")
                }
                TextButton(onClick = { backStack.push(NavTarget.Child3) }) {
                    Text(text = "Push child 3")
                }
                TextButton(onClick = { backStack.pop() }) {
                    Text(text = "Pop")
                }
            }
            // Lets add some children to the composition
            AppyxComponent(
                appyxComponent = backStack
            )
        }
    }

    override fun resolve(interactionTarget: NavTarget, buildContext: BuildContext): Node =
        when(interactionTarget){
            NavTarget.Child1 ->{
                node(buildContext){ Text(text = "Placeholder for child 1") }
            }
            NavTarget.Child2 ->{
                node(buildContext){ Text(text = "Placeholder for child 2") }
            }
            NavTarget.Child3 ->{
                SomeChildNode(buildContext , "Mzazi")
            }
        }
}
