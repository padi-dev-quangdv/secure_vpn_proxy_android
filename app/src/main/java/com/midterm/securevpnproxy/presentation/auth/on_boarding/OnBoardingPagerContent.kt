package com.midterm.securevpnproxy.presentation.auth.on_boarding

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
fun OnBoardingPagerContent(
    modifier: Modifier = Modifier,
    @DrawableRes imageRes: Int = R.drawable.ic_product_launch,
    @StringRes titleRes: Int = R.string.title_on_boarding_1,
    @StringRes descRes: Int = R.string.description_on_boarding_1,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "image",
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = stringResource(id = titleRes),
            color = LocalColors.current.neutral90,
            style = LargeTextBold,
            fontSize = 16.sp,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = stringResource(id = descRes),
            color = LocalColors.current.neutral70,
            style = SmallTextRegular,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 58.dp)
        )
    }

}

@Composable
@Preview(showBackground = true)
fun PreviewOnBoardingPagerContent() {
    AppTheme {
        OnBoardingPagerContent()
    }
}