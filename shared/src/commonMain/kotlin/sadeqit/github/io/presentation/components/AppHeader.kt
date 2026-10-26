package sadeqit.github.io.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import sadeqit.github.io.presentation.navigation.AppRoute
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun AppHeader(
    currentRoute: AppRoute,
    onNavigate: (AppRoute) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppDimensions.ContentPadding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppLogo()

        Row {
            NavigationItem(
                text = "Home",
                selected = currentRoute == AppRoute.Home,
                onClick = { onNavigate(AppRoute.Home) }
            )

            NavigationItem(
                text = "Projects",
                selected = currentRoute == AppRoute.Projects,
                onClick = { onNavigate(AppRoute.Projects) }
            )

            NavigationItem(
                text = "Articles",
                selected = currentRoute == AppRoute.Articles,
                onClick = { onNavigate(AppRoute.Articles) }
            )

            NavigationItem(
                text = "Resume",
                selected = currentRoute == AppRoute.Resume,
                onClick = { onNavigate(AppRoute.Resume) }
            )

            NavigationItem(
                text = "About",
                selected = currentRoute == AppRoute.About,
                onClick = { onNavigate(AppRoute.About) }
            )

            NavigationItem(
                text = "Contact",
                selected = currentRoute == AppRoute.Contact,
                onClick = { onNavigate(AppRoute.Contact) }
            )
        }
    }
}

@Composable
private fun NavigationItem(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick
    ) {
        Text(text = text)
    }
}