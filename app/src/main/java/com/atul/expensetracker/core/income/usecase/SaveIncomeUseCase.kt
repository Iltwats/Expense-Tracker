package com.atul.expensetracker.core.income.usecase

import com.atul.expensetracker.core.income.dto.EditIncomeData
import com.atul.expensetracker.core.income.repository.IncomeRepository
import javax.inject.Inject

interface SaveIncomeUseCase {
    suspend fun save(income: EditIncomeData)
}

class SaveIncomeUseCaseImpl @Inject constructor(
    private val incomeRepository: IncomeRepository
) : SaveIncomeUseCase {
    override suspend fun save(income: EditIncomeData) {
        incomeRepository.save(income)
    }
}