package com.singaludra.gofood.feature.register.ui

import android.util.Log
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.singaludra.gofood.feature.register.presentation.RegisterUIState
import com.singaludra.gofood.feature.register.presentation.RegistrationFormState
import com.singaludra.gofood.feature.register.ui.components.DropdownCitySection
import com.singaludra.gofood.shared.ui.components.FilledButtonSection
import com.singaludra.gofood.shared.ui.components.TextFieldSection
import com.singaludra.gofood.shared.ui.components.TopBarSection
import com.singaludra.gofood.ui.theme.GofoodTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddressScreen(
    modifier: Modifier = Modifier,
    registerUIState: RegisterUIState,
    snackbarHostState: SnackbarHostState = SnackbarHostState(),
    dropDownList: List<String> = listOf("Bali","Jakarta", "Bandung", "Cilacap", "Jogja"),
    onArrowClick: () -> Unit,
    onRegisterClick: (RegistrationFormState) -> Unit
) {

    val registerDataState = remember { mutableStateOf(registerUIState.registrationFormState) }

    LaunchedEffect(snackbarHostState) {
        if(registerUIState.isSuccess == true){
            Log.d("register ui state", registerUIState.toString())
            snackbarHostState.showSnackbar("Register sukses")
        }
        if(registerUIState.isSuccess == false){
            snackbarHostState.showSnackbar(registerUIState.errorMessage ?: "unknown error")
        }
    }

    Scaffold(
        modifier = modifier,
        snackbarHost = { SnackbarHost (hostState = snackbarHostState) },
        topBar = {
            TopBarSection(
                title = "Alamat",
                subTitle = "Lengkapin alamat kamu buat daftar akunnya.",
                onArrowClick = onArrowClick,
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Spacer(modifier = Modifier.weight(0.2f))

            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                TextFieldSection(
                    title = "Nomor HP",
                    placeholder = "08xxxxxxxxx",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    onValueChange = {
                        registerDataState.value = registerDataState.value.copy(
                            phoneNumber = it
                        )
                    }
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                TextFieldSection(
                    title = "Alamat",
                    placeholder = "Alamat kamu",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    onValueChange = {
                        registerDataState.value = registerDataState.value.copy(
                            address = it
                        )
                    }
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                TextFieldSection(
                    title = "Nomor Rumah",
                    placeholder = "Nomor rumah kamu",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    onValueChange = {
                        registerDataState.value = registerDataState.value.copy(
                            houseNumber = it
                        )
                    }
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))

                DropdownCitySection(
                    title = "Kota",
                    placeholder = "Pilih kota",
                    dropDownList = dropDownList,
                    selectedItem = {
                        registerDataState.value = registerDataState.value.copy(
                            city = it
                        )
                    },
                    value = registerDataState.value.city,
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            FilledButtonSection(
                modifier = Modifier.padding(16.dp),
                buttonText = "Submit",
                onClick = {onRegisterClick.invoke(registerDataState.value)}
            )
        }
    }
}

@Preview(device = Devices.PIXEL_4_XL ,showSystemUi = true)
@Composable
fun AddressScreenPreview(){
    GofoodTheme {
        AddressScreen(registerUIState = RegisterUIState(), onArrowClick = { }, onRegisterClick = {})
    }
}