package sadeqit.github.io.presentation.components.article

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sadeqit.github.io.domain.model.ArticleBlock

@Composable
fun ArticleCodeBlock(
    block: ArticleBlock.CodeBlock,
    modifier: Modifier = Modifier
) {
    val clipboardManager = LocalClipboardManager.current
    val colorScheme = MaterialTheme.colorScheme

    val codeLines = block.code.split('\n')
    val lineNumbers = codeLines.indices.joinToString("\n") { "${it + 1}" }

    val highlightedCode = highlightCode(
        code = block.code,
        keywordColor = colorScheme.primary,
        stringColor = colorScheme.tertiary,
        commentColor = colorScheme.onSurfaceVariant,
        numberColor = colorScheme.secondary
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colorScheme.surface)
            .border(
                width = 1.dp,
                color = colorScheme.outlineVariant,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorScheme.surfaceVariant)
                .padding(horizontal = 14.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color(0xFFFF5F57), CircleShape)
                )
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color(0xFFFFBD2E), CircleShape)
                )
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color(0xFF28C840), CircleShape)
                )
            }

            Spacer(Modifier.size(12.dp))

            Text(
                text = block.fileName ?: block.title ?: "Code",
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.labelMedium,
                color = colorScheme.onSurfaceVariant,
                maxLines = 1
            )

            Text(
                text = block.language.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(Modifier.size(12.dp))

            Text(
                text = "Copy",
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .clickable {
                        clipboardManager.setText(AnnotatedString(block.code))
                    }
                    .padding(horizontal = 8.dp, vertical = 5.dp),
                style = MaterialTheme.typography.labelMedium,
                color = colorScheme.primary
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorScheme.surface)
                .padding(vertical = 14.dp)
        ) {
            if (block.showLineNumbers) {
                Text(
                    text = lineNumbers,
                    modifier = Modifier.padding(
                        start = 14.dp,
                        end = 14.dp
                    ),
                    color = colorScheme.onSurfaceVariant.copy(alpha = 0.65f),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 13.sp,
                    lineHeight = 22.sp
                )
            }

            Text(
                text = highlightedCode,
                modifier = Modifier
                    .weight(1f)
                    .horizontalScroll(rememberScrollState())
                    .padding(end = 14.dp),
                color = colorScheme.onSurface,
                fontFamily = FontFamily.Monospace,
                fontSize = 13.sp,
                lineHeight = 22.sp,
                softWrap = false
            )
        }
    }
}

private fun highlightCode(
    code: String,
    keywordColor: Color,
    stringColor: Color,
    commentColor: Color,
    numberColor: Color
): AnnotatedString {
    val tokenRegex = Regex(
        """//[^\n]*|"(?:\\.|[^"\\])*"|'(?:\\.|[^'\\])*'|@[A-Za-z_][A-Za-z0-9_]*|\b(?:fun|val|var|class|object|interface|data|sealed|enum|override|private|public|internal|protected|suspend|inline|operator|infix|return|if|else|when|for|while|do|try|catch|finally|throw|is|as|in|this|super|null|true|false|import|package|typealias|companion|const|lateinit|abstract|open|final|expect|actual)\b|\b\d+(?:\.\d+)?\b"""
    )

    return buildAnnotatedString {
        var currentIndex = 0

        tokenRegex.findAll(code).forEach { match ->
            append(code.substring(currentIndex, match.range.first))

            val token = match.value
            val tokenColor = when {
                token.startsWith("//") -> commentColor
                token.startsWith("\"") || token.startsWith("'") -> stringColor
                token.startsWith("@") -> keywordColor
                token.firstOrNull()?.isDigit() == true -> numberColor
                else -> keywordColor
            }

            pushStyle(
                SpanStyle(
                    color = tokenColor,
                    fontWeight = if (
                        token.startsWith("@") ||
                        token.firstOrNull()?.isLetter() == true
                    ) {
                        FontWeight.Medium
                    } else {
                        FontWeight.Normal
                    }
                )
            )
            append(token)
            pop()

            currentIndex = match.range.last + 1
        }

        append(code.substring(currentIndex))
    }
}
