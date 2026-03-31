package com.example.wokulskidashboard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun IncomeForm(
    name: String,
    amount: String,
    onNameChange: (String) -> Unit,
    onAmountChange: (String) -> Unit,
    onSave: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Przychód", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        WokulskiTextField(
            value = name,
            onValueChange = onNameChange,
            label = "Nazwa towaru",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        WokulskiTextField(
            value = amount,
            onValueChange = onAmountChange,
            label = "Kwota (rub.)",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

        WokulskiButton(
            onClick = onSave,
            text = "Zapisz przychód",
            modifier = Modifier.fillMaxWidth()
        )
    }
}
