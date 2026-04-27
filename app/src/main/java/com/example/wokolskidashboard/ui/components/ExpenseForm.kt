package com.example.wokolskidashboard.ui.components

import android.service.autofill.OnClickAction
import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ExpenseForm(
    name: String,
    amount: String,
    isOptional: Boolean,
    category: String,
    onNameChange: (String) -> Unit,
    onAmountChange: (String) -> Unit,
    onOptionalChange: (Boolean) -> Unit,
    onCategoryChange: (String) -> Unit,
    onSave: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Wydatek", style = MaterialTheme.typography.titleMedium)

        Spacer(Modifier.height(8.dp))

        WokolskiTextField(
            value = name,
            onValueChange = onNameChange,
            label = "Cel wydatku",
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

        Text("Kategoria")

        val categories = listOf(
            "Sklep",
            "Kamienica",
            "Wydatki osobiste"
        )

        categories.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = category == item,
                    onClick = { onCategoryChange(item)}
                )
                Text(text = item)
            }
        }

        Spacer(Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Wydatek zbyteczny")
            Switch(
                checked = isOptional,
                onCheckedChange = onOptionalChange
            )
        }

        Spacer(Modifier.height(12.dp))

        WokolskiButton(
            onClick = onSave,
            text = "Zapisz wydatek",
            modifier = Modifier.fillMaxWidth()
        )
    }
}