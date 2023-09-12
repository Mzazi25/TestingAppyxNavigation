package com.mzazi.testingappyxnavigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.navigation.modality.BuildContext
import com.bumble.appyx.navigation.node.Node

class SomeChildNode(
    buildContext: BuildContext,
    private val name: String
) : Node(
    buildContext = buildContext
) {
    @Composable
    override fun View(modifier: Modifier) {
        Text("This is SomeChildNode $name")
    }
}