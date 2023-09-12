package com.midterm.securevpnproxy.presentation.main.home.home_select_mode

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.compose.ButtonColors
import com.midterm.securevpnproxy.base.compose.LargeTextSemiBold
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.MediumTextRegular
import com.midterm.securevpnproxy.base.compose.customview.LargeSolidButton

@Composable

fun DialogShowInfoMessage(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    color: Color = LocalColors.current.neutral90
) {
    val openDialog = remember {
        mutableStateOf(true)
    }

    if (!openDialog.value) return
    AlertDialog(onDismissRequest = { openDialog.value = false },
        title = {
            Text(text = title, style = LargeTextSemiBold, color = color)
        },
        text = {
            Text(text = description, style = MediumTextRegular, color = color)
        }, confirmButton = {
            LargeSolidButton(modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
                text = stringResource(id = R.string.got_it),
                color = ButtonColors.buttonColorBlue(),
                onClick = { openDialog.value = false }) {
            }
        })
}