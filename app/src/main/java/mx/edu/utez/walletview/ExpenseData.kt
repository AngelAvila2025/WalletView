package mx.edu.utez.walletview

import androidx.compose.ui.graphics.Color
import mx.edu.utez.walletview.ui.theme.MinimalistBlueDeep
import mx.edu.utez.walletview.ui.theme.MinimalistBluePrimary
import mx.edu.utez.walletview.ui.theme.MinimalistBlueSecondary
import mx.edu.utez.walletview.ui.theme.MinimalistGrayLight
import mx.edu.utez.walletview.ui.theme.MinimalistGrayMedium
import mx.edu.utez.walletview.ui.theme.MinimalistIndigo
import kotlin.random.Random

data class ExpenseCategory(
    val name: String,
    val amount: Float,
    val color: Color
)

data class MonthlyExpense(
    val monthName: String,
    val amount: Float
)

data class ExpenseSummary(
    val categories: List<ExpenseCategory>,
    val monthlyExpenses: List<MonthlyExpense>
) {
    val totalExpense: Float
        get() = categories.sumOf { it.amount.toDouble() }.toFloat()
}

object ExpenseDataGenerator {
    private val categoryDefinitions = listOf(
        Pair("Comida", MinimalistBluePrimary),
        Pair("Transporte", MinimalistBlueSecondary),
        Pair("Vivienda", MinimalistBlueDeep),
        Pair("Entretenimiento", MinimalistIndigo),
        Pair("Servicios", MinimalistGrayLight),
        Pair("Compras", MinimalistGrayMedium)
    )

    private val monthNames = listOf("Ene", "Feb", "Mar", "Abr", "May", "Jun")

    fun generateRandomSummary(): ExpenseSummary {
        val categories = categoryDefinitions.map { (name, color) ->
            val randomAmount = (Random.nextDouble(1500.0, 5000.0) / 10.0).let {
                kotlin.math.round(it) * 10f
            }
            ExpenseCategory(
                name = name,
                amount = randomAmount.toFloat(),
                color = color
            )
        }

        val monthlyExpenses = monthNames.map { month ->
            val randomAmount = (Random.nextDouble(8000.0, 20000.0) / 10.0).let {
                kotlin.math.round(it) * 100f
            }
            MonthlyExpense(
                monthName = month,
                amount = randomAmount.toFloat()
            )
        }

        return ExpenseSummary(categories, monthlyExpenses)
    }
}
