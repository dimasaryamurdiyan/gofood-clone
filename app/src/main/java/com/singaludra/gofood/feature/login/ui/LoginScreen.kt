package com.singaludra.gofood.feature.login.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.singaludra.login.presentation.LoginUIState
import com.singaludra.shared.ui.components.FilledButtonSection
import com.singaludra.shared.ui.components.InputPasswordTextFieldSection
import com.singaludra.shared.ui.components.OutlineButtonSection
import com.singaludra.shared.ui.components.TextFieldSection
import com.singaludra.shared.ui.components.TopBarSection
import com.singaludra.shared.ui.theme.GofoodTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    loginUIState: com.singaludra.login.presentation.LoginUIState,
    onBtnRegisterClick: () -> Unit,
    snackbarHostState: SnackbarHostState = SnackbarHostState(),
    onBtnLoginClick: (email: String, password: String) -> Unit
) {
    val emailValueState = remember { mutableStateOf("") }
    val passwordValueState = remember { mutableStateOf("") }

    LaunchedEffect(snackbarHostState) {
        when(loginUIState){
            is com.singaludra.login.presentation.LoginUIState.Success ->{
                snackbarHostState.showSnackbar("Login sukses")
            }
            is com.singaludra.login.presentation.LoginUIState.Error ->{
                snackbarHostState.showSnackbar(loginUIState.errorMessage ?: "unknown error")
            }
            else -> {

            }
        }
    }

    Scaffold (
        modifier = modifier,
        snackbarHost = { SnackbarHost (hostState = snackbarHostState)},
        topBar = {
            TopBarSection(
                title = "Login",
                subTitle = "Kalo udah punya akun langsung masuk aja gan"
            )
        }
    ){
        Column (
            modifier = Modifier.padding(it)
        ) {
            Spacer(Modifier.padding(top = 100.dp))

            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                TextFieldSection(
                    title = "Email",
                    placeholder = "Cth: name@email.com",
                    onValueChange = { value -> emailValueState.value = value },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                InputPasswordTextFieldSection(
                    title = "Password",
                    placeholder = "Input Password",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    onValueChange = { value -> passwordValueState.value = value }
                )

                Spacer(modifier = Modifier.weight(1f))

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    FilledButtonSection(
                        buttonText = "Login",
                        onClick = {
                            onBtnLoginClick(
                                emailValueState.value,
                                passwordValueState.value
                            )
                        },
                    )
                    OutlineButtonSection(
                        buttonText = "Register",
                        onClick = onBtnRegisterClick,
                    )
                }
            }
        }
    }
}

@Preview(device = Devices.PIXEL_4_XL ,showSystemUi = true)
@Composable
private fun PreviewLoginScreen(){
    GofoodTheme {
        LoginScreen(
            onBtnRegisterClick = {},
            loginUIState = com.singaludra.login.presentation.LoginUIState.Success
        ) { _ , _ -> }
    }

}
