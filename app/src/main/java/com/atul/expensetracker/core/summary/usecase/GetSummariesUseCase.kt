package com.atul.expensetracker.core.summary.usecase

import com.atul.expensetracker.core.summary.entity.Summary
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

interface GetSummariesUseCase {
    /**
     * Summaries are returned ordered from newest to oldest
     */
    suspend fun getAll(
        range: DateRange = last12Months()
    ): List<Summary>
}

class GetSummariesUseCaseImpl @Inject constructor(
    private val observeSummariesUseCase: ObserveSummariesUseCase
) : GetSummariesUseCase {

    override suspend fun getAll(
        range: DateRange
    ): List<Summary> {
        return observeSummariesUseCase.observe(range).firstOrNull() ?: emptyList()
    }

}