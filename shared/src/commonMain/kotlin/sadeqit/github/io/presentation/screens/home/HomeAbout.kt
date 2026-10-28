package sadeqit.github.io.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun HomeAbout(
    isMobile: Boolean,
    onAboutClick: () -> Unit,
) {
    HomeContainer(
        modifier = Modifier.padding(
            vertical = AppDimensions.Space48
        )
    ) {
        if (isMobile) {
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    AppDimensions.Space24
                )
            ) {
                HomeReveal {
                    SectionHeader(
                        eyebrow = "ABOUT ME",
                        title = "کد فقط بخشی از کاری است که انجام می‌دهم.",
                        description = "تمرکز من روی ساخت محصولاتی است که علاوه بر ظاهر مناسب، " +
                                "ساختار فنی سالم و قابلیت توسعه داشته باشند."
                    )
                }

                HomeRevealItem(
                    index = 1,
                    isMobile = true,
                    modifier = Modifier.align(Alignment.Start)
                ) {
                    OutlinedButton(
                        onClick = onAboutClick,
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text("بیشتر درباره من")
                    }
                }
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    AppDimensions.Space64
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    HomeReveal {
                        SectionHeader(
                            eyebrow = "ABOUT ME",
                            title = "کد فقط بخشی از کاری است که انجام می‌دهم.",
                            description = "تمرکز من روی ساخت محصولاتی است که علاوه بر ظاهر مناسب، " +
                                    "ساختار فنی سالم و قابلیت توسعه داشته باشند."
                        )
                    }
                }

                Box(
                    modifier = Modifier.weight(0.55f)
                ) {
                    HomeRevealItem(
                        index = 1,
                        isMobile = false
                    ) {
                        OutlinedButton(
                            onClick = onAboutClick,
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Text("بیشتر درباره من")
                        }
                    }
                }
            }
        }
    }
}

