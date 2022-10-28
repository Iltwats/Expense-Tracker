package com.atul.expensetracker.core.expense.usecase

import com.atul.expensetracker.core.expense.entity.Expense
import com.atul.expensetracker.core.expense.repository.ExpenseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ObserveExpensesUseCase {
    suspend fun observe(range: DateRange = last12Months()): Flow<List<Expense>>
}

class ObserveExpensesUseCaseImpl @Inject constructor(
    private val expenseRepository: ExpenseRepository
) : ObserveExpensesUseCase {
    override suspend fun observe(range: DateRange): Flow<List<Expense>> {
        return expenseRepository.observe(range)
    }
}