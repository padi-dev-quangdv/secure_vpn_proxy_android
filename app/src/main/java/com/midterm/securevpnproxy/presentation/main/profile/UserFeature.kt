package com.midterm.securevpnproxy.presentation.main.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.midterm.securevpnproxy.base.compose.LargeTextBold
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.SmallTextRegular

@Composable
fun UserFeature(
    contentText: String,
    onFeatureClicked: () -> Unit,
    modifier: Modifier = Modifier,
    canShowOption: Boolean = false,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp, horizontal = 24.dp)
            .background(
                color = LocalColors.current.colorF9F9F9,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable {
                onFeatureClicked()
            }
    ) {
        Text(
            text = contentText,
            style = LargeTextBold,
            color = LocalColors.current.neutral90,
            modifier = Modifier.padding(24.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        if (canShowOption) {
            Text(
                text = stringResource(id = R.string.account_status),
                style = SmallTextRegular,
                color = LocalColors.current.infoMain
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_next),
            contentDescription = "Next",
            modifier = Modifier
                .size(56.dp)
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewUserFeature() {
    AppTheme {
        UserFeature(
            contentText = "Account",
            onFeatureClicked = {},
            canShowOption = false
        )
    }
}