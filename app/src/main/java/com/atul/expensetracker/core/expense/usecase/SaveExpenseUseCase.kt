package com.atul.expensetracker.core.expense.usecase

import com.atul.expensetracker.core.expense.dto.EditExpenseData
import com.atul.expensetracker.core.expense.repository.ExpenseRepository
import javax.inject.Inject

interface SaveExpenseUseCase {
    suspend fun save(expense: EditExpenseData)
}

class SaveExpenseUseCaseImpl @Inject constructor(
    private val saveExpenseRepository: ExpenseRepository
) : SaveExpenseUseCase {
    override suspend fun save(expense: EditExpenseData) {
        saveExpenseRepository.save(expense)
    }
}