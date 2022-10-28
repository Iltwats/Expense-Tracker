package com.atul.expensetracker.core.income.repository

import com.atul.expensetracker.core.income.dto.EditIncomeData
import com.atul.expensetracker.core.income.entity.Income
import kotlinx.coroutines.flow.Flow

interface IncomeRepository {
    suspend fun getAll(): List<Income>
    suspend fun observe(range: DateRange): Flow<List<Income>>

    suspend fun save(income: EditIncomeData)
}