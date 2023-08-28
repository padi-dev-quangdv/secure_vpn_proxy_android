package com.midterm.securevpnproxy.presentation.auth.reset_password

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.compose.AppTheme
import com.midterm.securevpnproxy.base.compose.LargeTextBold
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.SmallTextRegular

@Composable
fun ResetPasswordHeader(
    @DrawableRes imageTitle: Int,
    @StringRes titleSrc: Int,
    @StringRes descSrc: Int,
    modifier: Modifier = Modifier,
    textColor: Color = LocalColors.current.neutral90
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Image(
            painter = painterResource(id = imageTitle),
            contentDescription = "image",
        )
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            text = stringResource(id = titleSrc),
            style = LargeTextBold,
            fontSize = 24.sp,
            color = textColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = descSrc),
            style = SmallTextRegular,
            color = LocalColors.current.neutral70,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewResetPasswordHeader() {
    AppTheme {
        ResetPasswordHeader(
            imageTitle = R.drawable.ic_unlock,
            titleSrc = R.string.forgot_password,
            descSrc = R.string.description_forgot_password,
        )
    }
}