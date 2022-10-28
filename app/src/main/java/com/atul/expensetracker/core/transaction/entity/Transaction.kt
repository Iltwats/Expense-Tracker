package com.atul.expensetracker.core.transaction.entity

import com.atul.expensetracker.core.category.entity.Category
import java.math.BigDecimal
import java.util.*
import com.atul.expensetracker.core.expense.entity.Expense as ExpenseEntity
import com.atul.expensetracker.core.income.entity.Income as IncomeEntity

sealed interface Transaction {
    data class Income(val income: IncomeEntity) : Transaction
    data class Expense(val expense: ExpenseEntity) : Transaction

    val amount: BigDecimal
        get() = when (this) {
            is Expense -> expense.amount
            is Income -> income.amount
        }
    val category: Category
        get() = when (this) {
            is Expense -> expense.category
            is Income -> income.category
        }
    val date: Date
        get() = when (this) {
            is Expense -> expense.date
            is Income -> income.date
        }
}