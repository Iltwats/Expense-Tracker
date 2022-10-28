package com.atul.expensetracker.core.transaction.usecase

import com.atul.expensetracker.core.transaction.entity.Transaction
import com.atul.expensetracker.core.transaction.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ObserveTransactionsUseCase {
    suspend fun observe(): Flow<List<Transaction>>
}

class ObserveTransactionsUseCaseImpl @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ObserveTransactionsUseCase {
    override suspend fun observe(): Flow<List<Transaction>> {
        return transactionRepository.observe()
    }
}