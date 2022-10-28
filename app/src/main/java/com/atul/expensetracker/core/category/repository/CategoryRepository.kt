package com.atul.expensetracker.core.category.repository

import com.atul.expensetracker.core.category.dto.EditCategoryData
import com.atul.expensetracker.core.category.entity.Category
import com.atul.expensetracker.core.category.entity.CategoryType
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getAll(
        type: CategoryType? = null
    ): List<Category>

    suspend fun observe(
        type: CategoryType? = null
    ): Flow<List<Category>>

    suspend fun save(expense: EditCategoryData)
}