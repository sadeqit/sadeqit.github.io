package sadeqit.github.io.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import sadeqit.shared.generated.resources.JetBrainsMono_Bold
import sadeqit.shared.generated.resources.JetBrainsMono_Regular
import sadeqit.shared.generated.resources.Res
import sadeqit.shared.generated.resources.Vazirmatn_Bold
import sadeqit.shared.generated.resources.Vazirmatn_Regular

internal object AppTypography {

    @Composable
    private fun vazirmatn(): FontFamily {
        return FontFamily(
            Font(
                resource = Res.font.Vazirmatn_Regular,
                weight = FontWeight.Normal
            ),
            Font(
                resource = Res.font.Vazirmatn_Bold,
                weight = FontWeight.Bold
            )
        )
    }

    @Composable
    private fun jetBrainsMono(): FontFamily {
        return FontFamily(
            Font(
                resource = Res.font.JetBrainsMono_Regular,
                weight = FontWeight.Normal
            ),
            Font(
                resource = Res.font.JetBrainsMono_Bold,
                weight = FontWeight.Bold
            )
        )
    }

    @Composable
    fun typography(): Typography {
        val vazirmatn = vazirmatn()
        val jetBrainsMono = jetBrainsMono()

        return Typography(
            displayLarge = TextStyle(
                fontFamily = vazirmatn,
                fontSize = 57.sp,
                lineHeight = 64.sp,
                letterSpacing = (-0.25).sp
            ),
            displayMedium = TextStyle(
                fontFamily = vazirmatn,
                fontSize = 45.sp,
                lineHeight = 52.sp
            ),
            displaySmall = TextStyle(
                fontFamily = vazirmatn,
                fontSize = 36.sp,
                lineHeight = 44.sp
            ),
            headlineLarge = TextStyle(
                fontFamily = vazirmatn,
                fontSize = 32.sp,
                lineHeight = 40.sp
            ),
            headlineMedium = TextStyle(
                fontFamily = vazirmatn,
                fontSize = 28.sp,
                lineHeight = 36.sp
            ),
            headlineSmall = TextStyle(
                fontFamily = vazirmatn,
                fontSize = 24.sp,
                lineHeight = 32.sp
            ),
            titleLarge = TextStyle(
                fontFamily = vazirmatn,
                fontSize = 22.sp,
                lineHeight = 28.sp
            ),
            titleMedium = TextStyle(
                fontFamily = vazirmatn,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.15.sp
            ),
            titleSmall = TextStyle(
                fontFamily = vazirmatn,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.1.sp
            ),
            bodyLarge = TextStyle(
                fontFamily = vazirmatn,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
            ),
            bodyMedium = TextStyle(
                fontFamily = vazirmatn,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp
            ),
            bodySmall = TextStyle(
                fontFamily = vazirmatn,
                fontSize = 12.sp,
                lineHeight = 18.sp,
                letterSpacing = 0.4.sp
            ),
            labelLarge = TextStyle(
                fontFamily = vazirmatn,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.1.sp
            ),
            labelMedium = TextStyle(
                fontFamily = vazirmatn,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp
            ),
            labelSmall = TextStyle(
                fontFamily = vazirmatn,
                fontSize = 11.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp
            )
        )
    }

    @Composable
    fun code(): TextStyle {
        return TextStyle(
            fontFamily = jetBrainsMono(),
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.sp
        )
    }
}
