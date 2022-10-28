package com.atul.expensetracker.core.expense.dto

import com.atul.expensetracker.core.category.entity.Category
import java.math.BigDecimal
import java.util.*

data class EditExpenseData(
    val id: Long?,
    val description: String,
    val category: Category,
    val date: Date,
    val amount: BigDecimal
)