package com.midterm.securevpnproxy.presentation.main.account_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.compose.AppTheme
import com.midterm.securevpnproxy.base.compose.LargeTextSemiBold
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.MediumTextRegular

@Composable
fun AccountFields(
    manageAccountFeatureOnClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        SingleAccountField(
            fieldText = stringResource(id = R.string.email),
            subText = stringResource(id = R.string.email_hint),
        )
        SingleAccountField(
            fieldText = stringResource(id = R.string.linked_devices),
        )
        SingleAccountField(
            fieldText = stringResource(id = R.string.manage_account),
            hasSubText = false,
            onItemClicked = manageAccountFeatureOnClick,
        )
    }
}

@Composable
fun SingleAccountField(
    fieldText: String,
    modifier: Modifier = Modifier,
    subText: String = "",
    hasSubText: Boolean = true,
    textColor: Color = LocalColors.current.neutral90,
    subTextColor: Color = LocalColors.current.neutral70,
    onItemClicked: () -> Unit = {},
) {
    Row(modifier = modifier
        .padding(horizontal = 24.dp, vertical = 5.dp)
        .fillMaxWidth()
        .background(
            color = LocalColors.current.colorF9F9F9,
            shape = RoundedCornerShape(8.dp)
        )
        .padding(horizontal = 24.dp, vertical = 20.dp)
        .clickable {
            onItemClicked()
        }) {
        Text(
            text = fieldText,
            style = LargeTextSemiBold,
            color = textColor
        )
        Spacer(modifier = Modifier.weight(1f))
        if (hasSubText) {
            Text(
                text = subText,
                style = MediumTextRegular,
                color = subTextColor
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.ic_next),
                contentDescription = null
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewAccountFields() {
    AppTheme {
        AccountFields(
            manageAccountFeatureOnClick = { })
    }
}