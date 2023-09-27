package com.singaludra.gofood.feature.register.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.singaludra.gofood.shared.components.FilledButtonSection
import com.singaludra.gofood.shared.components.InputPasswordTextFieldSection
import com.singaludra.gofood.shared.components.TextFieldSection
import com.singaludra.gofood.shared.components.TopBarSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    onArrowClick: () -> Unit,
    onButtonClick: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopBarSection(
                title = "Register",
                subTitle = "Register disini",
                onArrowClick = onArrowClick,
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(0.2f))
            //add input photo section

            Spacer(modifier = Modifier.weight(0.2f))

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
               TextFieldSection(
                    title = "Nama",
                    placeholder = "Masukan Nama",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    onValueChange = {}
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                TextFieldSection(
                    title = "Email",
                    placeholder = "Masukan email",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    onValueChange = {}
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                InputPasswordTextFieldSection(
                    title = "Password",
                    placeholder = "Masukan Password",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    onValueChange = {}
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            FilledButtonSection(
                modifier = Modifier.padding(16.dp),
                buttonText = "Lanjutkan",
                onClick = onButtonClick,
            )
        }
    }
}