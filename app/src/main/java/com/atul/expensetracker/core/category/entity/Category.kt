package com.atul.expensetracker.core.category.entity

data class Category(
    val id: Long,
    val label: String,
    val type: CategoryType
)

enum class CategoryType { INCOME, EXPENSE }
