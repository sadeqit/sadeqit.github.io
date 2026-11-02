@file:OptIn(kotlin.js.ExperimentalWasmJsInterop::class)

package sadeqit.github.io.presentation.navigation

import web.events.addEventListener
import web.events.removeEventListener
import web.history.POP_STATE
import web.history.PopStateEvent
import web.history.history
import web.window.window

object BrowserHistory : BrowserRouter {

    private var popStateListener: ((PopStateEvent) -> Unit)? = null
    private var hasNavigated = false

    override fun currentPath(): String =
        window.location.pathname

    override fun navigate(path: String) {
        history.pushState(null, "", path)
        hasNavigated = true
    }

    override fun back(fallbackPath: String) {
        if (hasNavigated) {
            history.back()
        } else {
            navigate(fallbackPath)
        }
    }

    override fun listen(onPathChanged: (String) -> Unit) {
        clearListener()

        val listener: (PopStateEvent) -> Unit = {
            onPathChanged(currentPath())
        }

        popStateListener = listener
        window.addEventListener(PopStateEvent.POP_STATE, listener)
    }

    override fun clearListener() {
        popStateListener?.let { listener ->
            window.removeEventListener(PopStateEvent.POP_STATE, listener)
        }

        popStateListener = null
    }
}