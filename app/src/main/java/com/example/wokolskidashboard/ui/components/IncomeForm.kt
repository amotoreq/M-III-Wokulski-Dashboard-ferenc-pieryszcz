package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun IncomeForm(
    name: String,
    amount: String,
    onNameChange: (String) -> Unit,
    onAmountChange: (String) -> Unit,
    onSave: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Przychód", style = MaterialTheme.typography.titleMedium)

        Spacer(Modifier.height(8.dp))

        WokolskiTextField(
            value = name,
            onValueChange = onNameChange,
            label = "Nazwa towaru",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        WokolskiTextField(
            value = amount,
            onValueChange = onAmountChange,
            label = "Kwota (rub.)",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        WokolskiButton(
            onClick = onSave,
            text = "Zapisz przychód",
            modifier = Modifier.fillMaxWidth()
        )
    }
}
