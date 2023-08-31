package com.midterm.securevpnproxy.presentation.main.white_list

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Switch
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
import com.midterm.securevpnproxy.base.compose.LargeTextMedium
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.customview.TanifySwitch

@Composable
fun WhiteListAppFeature(
    @DrawableRes imageRes: Int,
    @StringRes contentTextRes: Int,
    onSwitchButtonClicked: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = false,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 10.dp
            )
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
         )
        Text(
            text = stringResource(id = contentTextRes),
            style = LargeTextMedium,
            color = LocalColors.current.neutral90,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        TanifySwitch(
            onSwitch = onSwitchButtonClicked,
            isEnabled = isEnabled,
            modifier = Modifier.padding(end = 16.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewWhiteListAppFeature() {
    AppTheme {
        WhiteListAppFeature(
            imageRes = R.drawable.icon_facebook,
            contentTextRes = R.string.facebook,
            onSwitchButtonClicked = {},
        )
    }
}