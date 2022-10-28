package com.atul.expensetracker.core.income.usecase

import com.atul.expensetracker.core.income.entity.Income
import com.atul.expensetracker.core.income.repository.IncomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ObserveIncomesUseCase {
    suspend fun observe(range: DateRange = last12Months()): Flow<List<Income>>
}

class ObserveIncomesUseCaseImpl @Inject constructor(
    private val incomeRepository: IncomeRepository
) : ObserveIncomesUseCase {
    override suspend fun observe(range: DateRange): Flow<List<Income>> {
        return incomeRepository.observe(range)
    }
}