
package sadeqit.github.io.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import sadeqit.github.io.domain.model.ResumeSocialLink
import sadeqit.github.io.domain.repository.ResumeRepository
import sadeqit.github.io.presentation.components.AppFooter
import sadeqit.github.io.presentation.components.rememberHoverEffect
import sadeqit.github.io.presentation.screens.home.HomeReveal
import sadeqit.github.io.presentation.theme.AppBreakpoints
import sadeqit.github.io.presentation.theme.AppDimensions
import sadeqit.shared.generated.resources.Res
import sadeqit.shared.generated.resources.gmail
import sadeqit.shared.generated.resources.ic_github
import sadeqit.shared.generated.resources.instagram
import sadeqit.shared.generated.resources.linkedin
import sadeqit.shared.generated.resources.telegram



@Composable
fun ContactScreen() {
    val resumeRepository = koinInject<ResumeRepository>()
    val resume = remember {
        resumeRepository.getResume()
    }
    val uriHandler = LocalUriHandler.current

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val isMobile = maxWidth < AppBreakpoints.Mobile

        val contentModifier = Modifier
            .widthIn(max = 1000.dp)
            .fillMaxWidth()
            .padding(horizontal = if (isMobile) 16.dp else 0.dp)

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                top = AppDimensions.Space32,
                bottom = 0.dp
            ),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item(key = "contact-content") {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(
                        AppDimensions.Space8
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    HomeReveal {
                        ContactSection(
                            title = "در ارتباط باشیم",
                            modifier = contentModifier
                        ) {
                            Text(
                                text = "خوشحال می شوم با شما در ارتباط باشم. اگر درباره پروژه هایم سؤالی دارید، به دنبال همکاری در پروژه ای هستید یا می خواهید درباره توسعه نرم افزار گفت وگو کنیم، می توانید از طریق راه های ارتباطی زیر با من در تماس باشید.",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.Justify
                            )
                        }
                    }

                    Box(
                        modifier = contentModifier.padding(
                            vertical = AppDimensions.Space16
                        )
                    ) {
                        HorizontalDivider(
                            color = MaterialTheme.colorScheme.outlineVariant,
                            thickness = 2.dp
                        )
                    }

                    HomeReveal {
                        ContactSection(
                            title = "راه‌های ارتباطی",
                            modifier = contentModifier
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                resume.socialLinks.forEach { link ->
                                    ContactSocialLinkItem(
                                        link = link,
                                        onClick = {
                                            uriHandler.openUri(link.url)
                                        },
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                            }
                        }
                    }
                }
            }
            item {
                Spacer(
                    modifier = Modifier.height(AppDimensions.Space24)
                )
            }

            item(key = "app-footer") {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CompositionLocalProvider(
                        LocalLayoutDirection provides LayoutDirection.Ltr
                    ) {
                        AppFooter()
                    }
                }
            }
        }
    }
}

@Composable
private fun ContactSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable androidx.compose.foundation.layout.ColumnScope.() -> Unit
) {
    val hoverEffect = rememberHoverEffect(enableScale = false)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Card(
            modifier = Modifier.hoverable(hoverEffect.interactionSource),
            border = BorderStroke(
                width = AppDimensions.BorderThin,
                brush = hoverEffect.borderBrush
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                content = content
            )
        }
    }
}

@Composable
private fun ContactSocialLinkItem(
    link: ResumeSocialLink,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val icon = when (link.title) {
        "Email" -> Res.drawable.gmail
        "GitHub" -> Res.drawable.ic_github
        "LinkedIn" -> Res.drawable.linkedin
        "Telegram" -> Res.drawable.telegram
        "Instagram" -> Res.drawable.instagram
        else -> Res.drawable.ic_github
    }

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
                shape = RoundedCornerShape(12.dp),
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(30.dp),
        )

        Spacer(Modifier.width(8.dp))

        Text(
            text = link.title,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}