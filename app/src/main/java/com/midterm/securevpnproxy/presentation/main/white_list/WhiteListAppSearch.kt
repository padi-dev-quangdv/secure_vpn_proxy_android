package com.midterm.securevpnproxy.presentation.main.white_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.compose.LargeTextMedium
import com.midterm.securevpnproxy.base.compose.LocalColors

@Composable
fun WhiteListAppSearch(
    searchText: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 4.dp)
            .background(
                color = LocalColors.current.colorF8F8F8,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        TextField(
            value = searchText,
            onValueChange = { newValue ->
                onTextChanged(newValue)
            },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_app),
                    style = LargeTextMedium,
                    color = LocalColors.current.neutral70,
                )
            },
            textStyle = LargeTextMedium.copy(color = LocalColors.current.neutral70),
            modifier = Modifier
                .fillMaxWidth(),
            trailingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search",
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                backgroundColor = LocalColors.current.colorF8F8F8,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}