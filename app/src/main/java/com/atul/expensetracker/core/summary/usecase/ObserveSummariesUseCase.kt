package com.atul.expensetracker.core.summary.usecase

import com.atul.expensetracker.core.expense.usecase.ObserveExpensesUseCase
import com.atul.expensetracker.core.income.usecase.ObserveIncomesUseCase
import com.atul.expensetracker.core.summary.entity.Summary
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import java.math.BigDecimal
import javax.inject.Inject

interface ObserveSummariesUseCase {
    /**
     * Summaries are returned ordered from newest to oldest
     */
    suspend fun observe(
        range: DateRange = last12Months()
    ): Flow<List<Summary>>
}

class ObserveSummariesUseCaseImpl @Inject constructor(
    private val observeIncomesUseCase: ObserveIncomesUseCase,
    private val observeExpensesUseCase: ObserveExpensesUseCase,
) : ObserveSummariesUseCase {

    override suspend fun observe(
        range: DateRange
    ): Flow<List<Summary>> {
        return combine(
            observeIncomesUseCase.observe(range),
            observeExpensesUseCase.observe(range)
        ) { incomes, expenses ->
            val dates = (incomes.map { it.date } + expenses.map { it.date })
                .filter { date -> date.isInRange(range) }
                .map { it.toMonthFirst() }
                .toSet()
                .sortedDescending()

            val aggIncomes = incomes.groupBy { it.date.toMonthFirst() }
            val aggExpenses = expenses.groupBy { it.date.toMonthFirst() }

            val summaries = dates.map { date ->
                Summary(
                    date = date,
                    income = aggIncomes[date]?.sumOf { it.amount } ?: BigDecimal.ZERO,
                    expenses = aggExpenses[date]?.sumOf { it.amount } ?: BigDecimal.ZERO,
                    endingBalance = BigDecimal.ZERO,
                )
            }

            var endingBalance = BigDecimal.ZERO

            summaries.asReversed().map { summary ->
                summary.copy(endingBalance = endingBalance + summary.netSavings).also {
                    endingBalance = it.endingBalance
                }
            }.asReversed()
        }
    }

}