package com.mzazi.testingappyxnavigation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import com.bumble.appyx.navigation.integration.NodeActivity
import com.bumble.appyx.navigation.integration.NodeHost
import com.bumble.appyx.navigation.platform.AndroidLifecycle
import com.mzazi.testingappyxnavigation.ui.theme.TestingAppyxNavigationTheme

class MainActivity : NodeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestingAppyxNavigationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NodeHost(
                        lifecycle = AndroidLifecycle(LocalLifecycleOwner.current.lifecycle),
                        integrationPoint = appyxV2IntegrationPoint
                    ){
                        RootNode(buildContext = it)
                    }
                }
            }
        }
    }
}