package mx.edu.utez.walletview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import mx.edu.utez.walletview.ui.theme.WalletViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WalletViewTheme {
                ExpenseChartsScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExpenseChartsScreenPreview() {
    WalletViewTheme {
        ExpenseChartsScreen()
    }
}
