package sadeqit.github.io

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import sadeqit.github.io.presentation.navigation.BrowserHistory

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport {
        App(browserRouter = BrowserHistory)
    }
}