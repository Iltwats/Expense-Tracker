package com.atul.expensetracker.core.category.usecase

import com.atul.expensetracker.core.category.entity.Category
import com.atul.expensetracker.core.category.entity.CategoryType
import com.atul.expensetracker.core.category.repository.CategoryRepository
import javax.inject.Inject

interface GetCategoriesUseCase {
    suspend fun getAll(
        type: CategoryType? = null
    ): List<Category>
}

class GetCategoriesUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : GetCategoriesUseCase {
    override suspend fun getAll(
        type: CategoryType?
    ): List<Category> {
        return categoryRepository.getAll(type = type)
    }
}