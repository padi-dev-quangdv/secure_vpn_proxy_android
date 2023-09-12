package com.midterm.securevpnproxy.presentation.main.profile

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.compose.AppTheme
import com.midterm.securevpnproxy.base.compose.LargeTextBold
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.MediumTextRegular

@Composable
fun PremiumBenefitInfo(
    modifier: Modifier = Modifier,
    boldColor: Color = LocalColors.current.neutral90,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 6.dp)
            .background(
                color = LocalColors.current.colorF9F9F9,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Text(
            text = stringResource(id = R.string.sub_title_app),
            style = LargeTextBold,
            color = boldColor,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        )
        PremiumFeature(
            iconRes = R.drawable.ic_world,
            textRes = R.string.regional_servers_feature,
        )
        PremiumFeature(
            iconRes = R.drawable.ic_rocket,
            textRes = R.string.unlock_feature,
        )
        PremiumFeature(
            iconRes = R.drawable.ic_no_ad,
            textRes = R.string.no_ads_feature,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_crown),
                contentDescription = null,
                modifier = Modifier.padding(
                    end = 12.dp,
                )
            )
            Text(
                text = stringResource(id = R.string.more_about_premium),
                style = LargeTextBold,
                color = boldColor,
            )
        }
    }
}

@Composable
fun PremiumFeature(
    @DrawableRes iconRes: Int,
    @StringRes textRes: Int,
    modifier: Modifier = Modifier,
    regularColor: Color = LocalColors.current.neutral70,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.padding(
                start = 40.dp,
                end = 12.dp,
            )
        )
        Text(
            text = stringResource(id = textRes),
            style = MediumTextRegular,
            color = regularColor,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewPremiumBenefitInfo() {
    AppTheme {
        PremiumBenefitInfo()
    }
}