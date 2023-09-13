package com.midterm.securevpnproxy.presentation.main.premium.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.compose.AppTheme
import com.midterm.securevpnproxy.base.compose.LargeTextSemiBold
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.SmallTextRegular

@Composable
fun PremiumHeader(
    modifier: Modifier = Modifier,
    textHeaderColor: Color = LocalColors.current.infoMain,
    descTextColor: Color = LocalColors.current.neutral70,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = LargeTextSemiBold,
            fontSize = 24.sp,
            color = textHeaderColor,

            )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.description_premium),
            style = SmallTextRegular,
            color = descTextColor,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewPremiumHeader() {
    AppTheme {
        PremiumHeader()
    }
}