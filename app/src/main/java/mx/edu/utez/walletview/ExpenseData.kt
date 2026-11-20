package mx.edu.utez.walletview

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

data class ExpenseCategory(
    val name: String,
    val amount: Float,
    val color: Color,
    val icon: String
)

data class MonthlyExpense(
    val monthName: String,
    val amount: Float
)

data class ExpenseSummary(
    val categories: List<ExpenseCategory>,
    val monthlyExpenses: List<MonthlyExpense>
) {
    val totalCategoryExpense: Float
        get() = categories.sumOf { it.amount.toDouble() }.toFloat()

    val totalMonthlyExpense: Float
        get() = monthlyExpenses.sumOf { it.amount.toDouble() }.toFloat()
}

object ExpenseDataGenerator {
    private val categoryDefinitions = listOf(
        Triple("Comida 🍔", Color(0xFFFF6B6B), 1500f..4500f),
        Triple("Transporte 🚗", Color(0xFF4ECDC4), 800f..2500f),
        Triple("Vivienda 🏠", Color(0xFF45B7D1), 4000f..9000f),
        Triple("Entretenimiento 🎬", Color(0xFF96CEB4), 600f..2000f),
        Triple("Servicios 💡", Color(0xFFFFA726), 1000f..3000f),
        Triple("Compras 🛍️", Color(0xFFAB47BC), 1200f..4000f)
    )

    private val monthNames = listOf("Ene", "Feb", "Mar", "Abr", "May", "Jun")

    fun generateRandomSummary(): ExpenseSummary {
        val categories = categoryDefinitions.map { (name, color, range) ->
            val randomAmount = (Random.nextDouble(range.start.toDouble(), range.endInclusive.toDouble()) / 10.0).let {
                kotlin.math.round(it) * 10f
            }
            ExpenseCategory(
                name = name,
                amount = randomAmount.toFloat(),
                color = color,
                icon = name.takeLast(2)
            )
        }

        val monthlyExpenses = monthNames.map { month ->
            val randomAmount = (Random.nextDouble(8000.0, 22000.0) / 100.0).let {
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
