package com.atul.expensetracker.core.category.dto

import com.atul.expensetracker.core.category.entity.CategoryType

data class EditCategoryData(
    val id: Long?,
    val label: String,
    val type: CategoryType
)
