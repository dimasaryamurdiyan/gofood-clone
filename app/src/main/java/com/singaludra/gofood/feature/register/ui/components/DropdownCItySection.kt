package com.singaludra.gofood.feature.register.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownCitySection(
    modifier: Modifier = Modifier,
    title: String = "Label",
    placeholder: String = "Placeholder",
    value: String = "",
    dropDownList: List<String>,
    selectedItem: ((String) -> Unit)? = null,
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(value) }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Bold)

        Box(
            modifier = Modifier
                .padding(top = 6.dp)
        ) {
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                }
            ) {
                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    value = selectedText,
                    onValueChange = { selectedItem?.invoke(it) },
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp
                    ),
                    readOnly = true,
                    decorationBox = { innerTextField ->
                        Column(
                            modifier = Modifier
                                .border(
                                    BorderStroke(1.dp, color = Color.DarkGray),
                                    shape = RoundedCornerShape(30.dp)
                                )
                                .padding(horizontal = 6.dp, vertical = 6.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box {
                                    if (selectedText.isEmpty()) {
                                        Text(
                                            text = placeholder,
                                            color = Color.Gray,
                                            fontSize = 16.sp
                                        )
                                    }
                                    innerTextField()
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                IconButton(
                                    modifier = Modifier
                                        .size(16.dp),
                                    onClick = {}
                                ) {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                                }
                            }
                        }
                    },
                    singleLine = true,
                    maxLines = 1,
                )

                ExposedDropdownMenu(
                    modifier = Modifier.fillMaxWidth(),
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    dropDownList.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(text = item) },
                            onClick = {
                                selectedText = item
                                expanded = false
                            }
                        )
                    }
                }
            }
        }
    }
}