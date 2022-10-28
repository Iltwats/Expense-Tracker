package com.atul.expensetracker.core.transaction.repository

import com.atul.expensetracker.core.transaction.entity.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {
    suspend fun observe(): Flow<List<Transaction>>
}
