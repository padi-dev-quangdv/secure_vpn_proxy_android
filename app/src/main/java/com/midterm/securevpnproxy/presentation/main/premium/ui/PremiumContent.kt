package com.midterm.securevpnproxy.presentation.main.premium.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.midterm.securevpnproxy.base.PremiumFeature
import com.midterm.securevpnproxy.base.compose.AppTheme
import com.midterm.securevpnproxy.base.compose.ButtonColors
import com.midterm.securevpnproxy.base.compose.LargeTextBold
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.MediumTextMedium
import com.midterm.securevpnproxy.base.compose.MediumTextRegular
import com.midterm.securevpnproxy.base.compose.customview.LargeSolidButton

@Composable
fun PremiumContent(
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.monthly_premium),
    titleColor: Color = LocalColors.current.infoMain,
    descColor: Color = LocalColors.current.neutral70,
    backgroundColor: Color = LocalColors.current.colorF5F5F5,
) {
    Column(
        modifier = modifier
            .padding(
                vertical = 16.dp,
                horizontal = 24.dp
            )
            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .padding(16.dp)
    ) {
        Text(
            text = title,
            style = LargeTextBold,
            fontSize = 24.sp,
            color = titleColor
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.unlimited_access),
            style = MediumTextMedium,
            color = descColor
        )
        Spacer(modifier = Modifier.height(16.dp))
        PremiumPackagePrice()
        Spacer(modifier = Modifier.height(32.dp))
        LargeSolidButton(
            text = stringResource(id = R.string.start_free_trial),
            color = ButtonColors.buttonColorBlue(),
            onClick = {

            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        ListPremiumFeature()
    }
}

@Composable
private fun PremiumPackagePrice(
    modifier: Modifier = Modifier,
    price: String = stringResource(id = R.string.monthly_price),
    subscriptionType: String = stringResource(id = R.string.month),
    priceTextColor: Color = LocalColors.current.black,
    subTextColor: Color = LocalColors.current.neutral70,
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = modifier
    ) {
        Text(
            text = price,
            style = LargeTextBold,
            fontSize = 40.sp,
            color = priceTextColor,
            modifier = Modifier.padding(end = 6.dp)
        )
        Text(
            text = subscriptionType,
            style = MediumTextRegular,
            color = subTextColor,
            modifier = Modifier.padding(bottom = 4.dp)
        )
    }
}

@Composable
private fun ListPremiumFeature(
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
    ) {
        PremiumFeature(
            iconRes = R.drawable.ic_world,
            textRes = R.string.regional_servers_feature,
            endPaddingIcon = 16.dp,
        )
        PremiumFeature(
            iconRes = R.drawable.ic_rocket,
            textRes = R.string.unlock_feature,
            endPaddingIcon = 16.dp,
        )
        PremiumFeature(
            iconRes = R.drawable.ic_no_ad,
            textRes = R.string.no_ads_feature,
            endPaddingIcon = 16.dp,
        )
        PremiumFeature(
            iconRes = R.drawable.ic_protect_browser,
            textRes = R.string.more_secure_feature,
            endPaddingIcon = 16.dp,
        )
        PremiumFeature(
            iconRes = R.drawable.ic_no_limit,
            textRes = R.string.unlimited_access,
            endPaddingIcon = 16.dp,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewPremiumContent() {
    AppTheme {
        PremiumContent()
    }
}