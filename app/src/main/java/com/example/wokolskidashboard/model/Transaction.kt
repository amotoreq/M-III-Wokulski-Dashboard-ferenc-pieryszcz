package com.example.wokolskidashboard.model

data class Transaction(
    val name: String,
    val amount: Double,
    val isExpense: Boolean,
    val category: String? = null,
    val isOptional: Boolean = false
)

