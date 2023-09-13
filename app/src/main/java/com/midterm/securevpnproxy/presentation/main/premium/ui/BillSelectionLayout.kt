package com.midterm.securevpnproxy.presentation.main.premium.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.compose.AppTheme
import com.midterm.securevpnproxy.base.compose.LargeTextBold
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.customview.TanifySwitch

@Composable
fun BillSelectionLayout(
    onSwitchSelection: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color = LocalColors.current.neutral90,
) {
    Box(
        modifier = modifier
            .padding(24.dp)
            .fillMaxWidth()
            .background(
                color = LocalColors.current.colorF5F5F5,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .padding(
                vertical = 12.dp,
                horizontal = 16.dp
            )
    ) {
        Text(
            text = stringResource(id = R.string.billed_monthly),
            maxLines = 2,
            style = LargeTextBold,
            color = textColor,
            modifier = Modifier.align(Alignment.CenterStart)
        )
        TanifySwitch(
            onSwitch = onSwitchSelection,
            modifier = Modifier.align(Alignment.Center)
        )
        Text(
            text = stringResource(id = R.string.billed_annually),
            maxLines = 2,
            style = LargeTextBold,
            color = textColor,
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewBillSelectionLayout() {
    AppTheme {
        BillSelectionLayout(onSwitchSelection = {})
    }
}
