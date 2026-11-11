package sadeqit.github.io.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import sadeqit.github.io.presentation.theme.AppDimensions


@Composable
fun SkillList(skills: List<String>) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space8),
        verticalArrangement = Arrangement.spacedBy(AppDimensions.Space8),
    ) {
        skills.forEach { skill ->
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                ),
            ) {
                Text(
                    text = skill,
                    modifier = Modifier.padding(
                        horizontal = AppDimensions.Space12,
                        vertical = AppDimensions.Space8,
                    ),
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.W400,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
        }
    }
}
