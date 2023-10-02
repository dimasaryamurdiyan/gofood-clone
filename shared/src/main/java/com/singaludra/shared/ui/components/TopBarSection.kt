package com.singaludra.shared.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.singaludra.shared.ui.theme.GofoodTheme

@Composable
fun TopBarSection(
    modifier: Modifier = Modifier,
    title: String = "",
    subTitle: String = "",
    painter: Int = 0,
    onArrowClick: (() -> Unit)? = null,
    onIconClick: (() -> Unit) ? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        if (onArrowClick != null) {
            IconButton(
                modifier = Modifier
                    .size(32.dp)
                    .padding(end = 8.dp),
                onClick = onArrowClick
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(start = 6.dp),
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = subTitle,
                fontSize = 12.sp,
            )
        }

        if (onIconClick != null) {
            IconButton(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(
                        width = 8.dp,
                        color = Color.Gray,
                        shape = CircleShape
                    ),
                onClick = onIconClick
            ) {
                Icon(
                    painterResource(id = painter),
                    contentDescription = "icon",
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun TopBarSectionPreview(){
    GofoodTheme {
        TopBarSection(
            onArrowClick = {},
            title = "Login",
            subTitle = "login disini"
        )
    }
}
