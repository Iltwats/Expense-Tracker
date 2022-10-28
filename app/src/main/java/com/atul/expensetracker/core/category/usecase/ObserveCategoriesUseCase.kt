package com.atul.expensetracker.core.category.usecase

import com.atul.expensetracker.core.category.entity.Category
import com.atul.expensetracker.core.category.entity.CategoryType
import com.atul.expensetracker.core.category.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ObserveCategoriesUseCase {
    suspend fun observe(
        type: CategoryType? = null
    ): Flow<List<Category>>
}

class ObserveCategoriesUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : ObserveCategoriesUseCase {
    override suspend fun observe(
        type: CategoryType?
    ): Flow<List<Category>> {
        return categoryRepository.observe(type)
    }
}