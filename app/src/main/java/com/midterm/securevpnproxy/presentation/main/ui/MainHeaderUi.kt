package com.midterm.securevpnproxy.presentation.main.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.compose.LargeTextSemiBold
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.customview.ImageButton

@Composable
fun MainHeaderUi(
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier,
    titleText: String = "",
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        ImageButton(
            drawableRes = R.drawable.ic_back,
            modifier = Modifier
                .padding(16.dp)
        ) {
            onBackClicked()
        }
        Text(
            text = titleText,
            style = LargeTextSemiBold,
            fontSize = 16.sp,
            color = LocalColors.current.neutral90,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }

}

@Composable
@Preview(showBackground = true)
fun PreviewMainHeaderUi() {
    MainHeaderUi(
        titleText = "Account Information",
        onBackClicked = {}
    )
}