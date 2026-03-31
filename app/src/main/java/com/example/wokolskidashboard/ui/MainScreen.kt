package com.example.wokolskidashboard.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.ui.components.BalanceHeader
import com.example.wokolskidashboard.ui.components.IncomeForm
import com.example.wokolskidashboard.ui.components.TransactionCard

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val transactions = remember { mutableStateListOf<Transaction>() }
    var incomeName by rememberSaveable { mutableStateOf("") }
    var incomeAmount by rememberSaveable { mutableStateOf("") }

    val balance = transactions.sumOf { tx ->
        if (tx.isExpense) -tx.amount else tx.amount
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        BalanceHeader(balance = balance)

        IncomeForm(
            name = incomeName,
            amount = incomeAmount,
            onNameChange = { incomeName = it },
            onAmountChange = { incomeAmount = it },
            onSave = {
                val amountDouble = incomeAmount.toDoubleOrNull()
                if (incomeName.isBlank() || amountDouble == null || amountDouble <= 0.0) return@IncomeForm

                transactions.add(
                    Transaction(
                        name = incomeName.trim(),
                        amount = amountDouble,
                        isExpense = false
                    )
                )

                incomeName = ""
                incomeAmount = ""
            }
        )

        LazyColumn(modifier = Modifier.padding(top = 8.dp)) {
            items(transactions) { tx ->
                TransactionCard(transaction = tx)
            }
        }
    }
}
