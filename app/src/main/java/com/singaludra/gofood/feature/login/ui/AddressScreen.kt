package com.singaludra.gofood.feature.login.ui

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
import com.singaludra.gofood.shared.components.TextFieldSection
import com.singaludra.gofood.shared.components.TopBarSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddressScreen(
    modifier: Modifier = Modifier,
    dropDownList: List<String>,
    onArrowClick: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopBarSection(
                title = "Alamat",
                subTitle = "Masukan Alamatmu",
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
                    title = "No.Hp",
                    placeholder = "Masukan nomor hp",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    onValueChange = {}
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                TextFieldSection(
                    title = "Alamat lengkap",
                    placeholder = "Alamat lengkapmu",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    onValueChange = {}
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                TextFieldSection(
                    title = "Nomor rumah",
                    placeholder = "Nomor rumahmu",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    onValueChange = {}
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))

            }

            Spacer(modifier = Modifier.weight(1f))

            FilledButtonSection(
                modifier = Modifier.padding(16.dp),
                buttonText = "Submit",
                onClick = {}
            )
        }
    }
}