package com.atul.expensetracker.core.expense.repository

import com.atul.expensetracker.core.expense.dto.EditExpenseData
import com.atul.expensetracker.core.expense.entity.Expense
import kotlinx.coroutines.flow.Flow

interface ExpenseRepository {
    suspend fun getAll(range: DateRange = last12Months()): List<Expense>
    suspend fun observe(range: DateRange = last12Months()): Flow<List<Expense>>

    suspend fun save(expense: EditExpenseData)
}