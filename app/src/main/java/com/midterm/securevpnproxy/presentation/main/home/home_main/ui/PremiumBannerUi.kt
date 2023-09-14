package com.midterm.securevpnproxy.presentation.main.home.home_main.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
fun PremiumBannerUi(
    actionOnClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = LocalColors.current.infoMain,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .clickable {
                actionOnClick()
            }
            .padding(
                horizontal = 16.dp,
                vertical = 14.dp
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_crown),
            contentDescription = null,
            colorFilter = ColorFilter.tint(LocalColors.current.white),
            modifier = Modifier
                .background(
                    color = LocalColors.current.warningMain,
                    shape = CircleShape
                )
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = stringResource(id = R.string.go_premium),
                style = LargeTextBold,
                color = LocalColors.current.white
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = R.string.sub_desc_go_premium),
                style = SmallTextRegular,
                color = LocalColors.current.white
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.ic_next),
            contentDescription = "Next",
            colorFilter = ColorFilter.tint(LocalColors.current.white)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewPremiumBannerUi() {
    AppTheme {
        PremiumBannerUi(actionOnClick = {})
    }
}