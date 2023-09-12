package com.midterm.securevpnproxy.presentation.main.profile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.compose.AppTheme
import com.midterm.securevpnproxy.base.compose.ButtonColors
import com.midterm.securevpnproxy.base.compose.LargeTextBold
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.customview.LargeSolidButton

@Composable
fun UserInfoContent(
    userName: String,
    onLogoutClicked: () -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes imageDefaultRes: Int = R.drawable.ic_default_user,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = imageDefaultRes),
            contentDescription = "User",
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.welcome),
                style = LargeTextBold,
                color = LocalColors.current.neutral90,
            )
            Text(
                text = " $userName",
                style = LargeTextBold,
                color = LocalColors.current.neutral90,
            )
        }
        LargeSolidButton(
            text = stringResource(id = R.string.logout),
            color = ButtonColors.buttonColorBlue(),
            onClick = onLogoutClicked,
            modifier = Modifier
                .fillMaxWidth(0.6f)
        )
    }

}

@Composable
@Preview(showBackground = true)
fun PreviewUserInfoContent() {
    AppTheme {
        UserInfoContent(
            userName = "User",
            onLogoutClicked = {}
        )
    }
}