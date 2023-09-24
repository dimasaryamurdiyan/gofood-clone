package com.singaludra.gofood.shared.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.singaludra.gofood.ui.theme.GofoodTheme

@Composable
fun TextFieldSection(
    modifier: Modifier = Modifier,
    title: String = "",
    placeholder: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onValueChange: (String) -> Unit,
) {
    val textValue = remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Column(modifier = modifier) {
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        BasicTextField(
            modifier = modifier
                .fillMaxWidth(),
            value = textValue.value,
            onValueChange = onValueChange,
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 14.sp
            ),
            decorationBox = { innerTextField ->
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 6.dp, bottom = 6.dp, end = 6.dp)
                    ) {
                        if (textValue.value.isEmpty()) {
                            Text(
                                text = placeholder,
                                color = Color.Gray,
                                fontSize = 16.sp
                            )
                        }
                        innerTextField()
                    }
                    Divider(color = Color.Gray, thickness = 1.dp)
                }
            },
            singleLine = true,
            maxLines = 1,
            keyboardOptions = keyboardOptions,
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowTextField(){
    GofoodTheme {
        TextFieldSection(title = "Email", placeholder = "tes", onValueChange = {})
    }
}