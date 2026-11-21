package mx.edu.utez.walletview.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val MinimalistDarkColorScheme = darkColorScheme(
    primary = AccentBlue,
    onPrimary = OnPrimaryWhite,
    primaryContainer = PrimaryContainerNavy,
    onPrimaryContainer = OnPrimaryContainerWhite,
    background = DarkNavyBackground,
    surface = DarkNavySurface,
    onSurface = TextWhite,
    surfaceVariant = DarkNavySurfaceVariant,
    onSurfaceVariant = TextGray
)

@Composable
fun WalletViewTheme(
    darkTheme: Boolean = true,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = MinimalistDarkColorScheme,
        typography = Typography,
        content = content
    )
}
