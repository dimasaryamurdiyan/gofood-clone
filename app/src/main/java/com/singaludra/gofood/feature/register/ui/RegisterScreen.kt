package com.singaludra.gofood.feature.register.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.singaludra.presentation.RegisterUIState
import com.singaludra.presentation.RegistrationFormState
import com.singaludra.gofood.feature.register.ui.components.AddPhotoSection
import com.singaludra.shared.ui.components.FilledButtonSection
import com.singaludra.shared.ui.components.InputPasswordTextFieldSection
import com.singaludra.shared.ui.components.TextFieldSection
import com.singaludra.shared.ui.components.TopBarSection
import com.singaludra.shared.ui.theme.GofoodTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    registerUIState: com.singaludra.presentation.RegisterUIState = com.singaludra.presentation.RegisterUIState(),
    snackbarHostState: SnackbarHostState = SnackbarHostState(),
    onArrowClick: () -> Unit,
    onButtonClick: (com.singaludra.presentation.RegistrationFormState) -> Unit,
) {

    val registerDataState = remember { mutableStateOf(registerUIState.registrationFormState) }

    Scaffold(
        modifier = modifier,
        snackbarHost = { SnackbarHost (hostState = snackbarHostState) },
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
            AddPhotoSection( onclick =  {})

            Spacer(modifier = Modifier.weight(0.2f))

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
               TextFieldSection(
                   title = "Nama",
                   placeholder = "Huruf alfabet, tanpa emoji/simbol",
                   keyboardOptions = KeyboardOptions.Default.copy(
                       keyboardType = KeyboardType.Text,
                       imeAction = ImeAction.Next
                   ),
                   onValueChange = {
                       registerDataState.value = registerDataState.value.copy(
                           name = it
                       )
                   }
               )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                TextFieldSection(
                    title = "Email",
                    placeholder = "Cth: nama@email.com",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    onValueChange = {
                        registerDataState.value = registerDataState.value.copy(
                            email = it
                        )
                    }
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                InputPasswordTextFieldSection(
                    title = "Kata Sandi",
                    placeholder = "Berupa huruf/angka",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    onValueChange = {
                        registerDataState.value = registerDataState.value.copy(
                            password = it
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            FilledButtonSection(
                modifier = Modifier.padding(16.dp),
                buttonText = "Lanjutkan",
                onClick = { onButtonClick(registerDataState.value) },
            )
        }
    }
}

@Preview(device = Devices.PIXEL_4_XL ,showSystemUi = true)
@Composable
fun RegisterScreenPreview(){
    GofoodTheme {
        RegisterScreen(registerUIState = com.singaludra.presentation.RegisterUIState(), onArrowClick = { }, onButtonClick = {})
    }
}