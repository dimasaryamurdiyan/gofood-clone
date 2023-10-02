package com.singaludra.shared.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.singaludra.shared.ui.theme.Green

@Composable
fun FilledButtonSection(
    modifier: Modifier = Modifier,
    buttonText: String = "",
    onClick: () -> Unit = {},
) {

    Button(
        modifier = modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Green),
        onClick = onClick,
    ) {
        Text(text = buttonText)
    }
}

@Composable
fun OutlineButtonSection(
    modifier: Modifier = Modifier,
    buttonText: String = "",
    onClick: () -> Unit = {},
) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth(),
        border = BorderStroke(1.dp, Green),
        onClick = onClick,
    ) {
        Text(text = buttonText, color = Green)
    }
}