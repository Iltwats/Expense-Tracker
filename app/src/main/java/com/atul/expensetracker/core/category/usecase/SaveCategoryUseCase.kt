package com.atul.expensetracker.core.category.usecase

import com.atul.expensetracker.core.category.dto.EditCategoryData
import com.atul.expensetracker.core.category.repository.CategoryRepository
import javax.inject.Inject

interface SaveCategoryUseCase {
    suspend fun save(category: EditCategoryData)
}

class SaveCategoryUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : SaveCategoryUseCase {
    override suspend fun save(category: EditCategoryData) {
        categoryRepository.save(category)
    }
}