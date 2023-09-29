package com.singaludra.gofood.shared.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.singaludra.gofood.ui.theme.GofoodTheme

@Composable
fun InputPasswordTextFieldSection(
    modifier: Modifier = Modifier,
    value: String = "",
    title: String = "Label",
    placeholder: String = "Placeholder",
    isShowPassword: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onValueChange: (String) -> Unit,
) {
    val textValue = remember { mutableStateOf(value) }

    Column(modifier = modifier) {
        Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Bold)
        PasswordBottomOutlineTextField(
            placeholder = placeholder,
            value = textValue.value,
            onValueChange = {
                textValue.value = it
                onValueChange.invoke(it)
            },
            initialIsShowPassword = isShowPassword,
            keyboardOptions = keyboardOptions,
        )
    }
}

@Composable
fun PasswordBottomOutlineTextField(
    modifier: Modifier = Modifier,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    initialIsShowPassword: Boolean = false,
    keyboardOptions: KeyboardOptions,
) {
    val focusManager = LocalFocusManager.current
    val isShowPassword = remember { mutableStateOf(initialIsShowPassword) }
    val trailingIcon = remember { mutableStateOf(Icons.Filled.VisibilityOff) }

    BasicTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 16.sp,
            letterSpacing = if (!isShowPassword.value) 3.sp else TextUnit.Unspecified
        ),
        decorationBox = { innerTextField ->
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 6.dp, bottom = 6.dp, end = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box {
                        if (value.isEmpty()) {
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
                        onClick = {
                            isShowPassword.value = !isShowPassword.value
                            trailingIcon.value = if (isShowPassword.value) Icons.Filled.Visibility
                            else Icons.Filled.VisibilityOff
                        }) {
                        Icon(
                            imageVector = trailingIcon.value,
                            contentDescription = "Visibility",
                        )
                    }
                }
                Divider(color = Color.Gray, thickness = 1.dp)
            }
        },
        visualTransformation = if (isShowPassword.value) VisualTransformation.None else {
            PasswordVisualTransformation()
        },
        singleLine = true,
        maxLines = 1,
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        ),
        keyboardOptions = keyboardOptions,
    )
}


@Composable
@Preview(showBackground = true)
private fun PasswordInputComponentPreview() {
    GofoodTheme {
        InputPasswordTextFieldSection(
            title = "Kata Sandi",
            placeholder = "Berupa huruf / angka",
            onValueChange = {}
        )
    }
}