package com.atul.expensetracker.core.expense.usecase

import com.atul.expensetracker.core.expense.entity.Expense
import com.atul.expensetracker.core.expense.repository.ExpenseRepository
import javax.inject.Inject

interface GetExpensesUseCase {
    suspend fun getAll(
        range: DateRange = last12Months()
    ): List<Expense>
}

class GetExpensesUseCaseImpl @Inject constructor(
    private val expenseRepository: ExpenseRepository
) : GetExpensesUseCase {
    override suspend fun getAll(range: DateRange): List<Expense> {
        return expenseRepository.getAll(range)
    }
}