package com.midterm.securevpnproxy.presentation.main.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.midterm.securevpnproxy.base.compose.SmallTextRegular

@Composable
fun ListFeatureSettings(
    pinProtectClick: () -> Unit,
    appsLockClick: () -> Unit,
    customBlockListClick: () -> Unit,
    whiteListAppClick: () -> Unit,
    modifier: Modifier = Modifier,
    whiteListAppSize: Int = 0,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        SettingFeature(
            text = stringResource(id = R.string.pin_protect),
            subText = stringResource(id = R.string.pin_protect_status),
            onItemClick = pinProtectClick
        )
        SettingFeature(
            text = stringResource(id = R.string.apps_lock),
            subText = stringResource(id = R.string.apps_lock_status),
            onItemClick = appsLockClick
        )
        SettingFeature(
            text = stringResource(id = R.string.custom_block_list),
            subText = stringResource(id = R.string.custom_block_list_status),
            onItemClick = customBlockListClick
        )
        SettingFeature(
            text = stringResource(id = R.string.whitelist_apps),
            subText = stringResource(id = R.string.whitelist_apps_status, whiteListAppSize),
            isUserPremium = false,
            onItemClick = whiteListAppClick
        )
    }
}

@Composable
fun SettingFeature(
    text: String,
    subText: String,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color = LocalColors.current.neutral90,
    subTextColor: Color = LocalColors.current.infoMain,
    isUserPremium: Boolean = true,
) {
    Row(modifier = modifier
        .fillMaxWidth()
        .padding(
            horizontal = 24.dp,
            vertical = 5.dp
        )
        .background(
            color = LocalColors.current.colorF9F9F9,
            shape = RoundedCornerShape(size = 8.dp)
        )
        .padding(
            horizontal = 24.dp,
            vertical = 20.dp
        )
        .clickable {
            onItemClick()
        }
    ) {
        Text(
            text = text,
            style = LargeTextSemiBold,
            color = textColor
        )
        if (isUserPremium) {
            Spacer(modifier = Modifier.width(6.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_crown),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = subText,
            style = SmallTextRegular,
            color = subTextColor
        )
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_next),
            contentDescription = "Next"
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewSettingFeature() {
    AppTheme {
        ListFeatureSettings(
            pinProtectClick = {  },
            appsLockClick = {  },
            customBlockListClick = {  },
            whiteListAppClick = {  })
    }
}

