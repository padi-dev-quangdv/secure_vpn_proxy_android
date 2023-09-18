package com.midterm.securevpnproxy.presentation.main.white_list

import android.graphics.drawable.Drawable
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import com.midterm.securevpnproxy.base.compose.AppTheme
import com.midterm.securevpnproxy.base.compose.LargeTextMedium
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.customview.TanifySwitch

@Composable
fun WhiteListAppFeature(
    drawable: Drawable,
    contentText: String,
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
        DrawableImage(
            drawable = drawable,
        )
        Text(
            text = contentText,
            style = LargeTextMedium,
            color = LocalColors.current.neutral90,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(3f)
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
private fun DrawableImage(drawable: Drawable) {
    val density = LocalDensity.current.density
    val bitmap = remember(drawable) {
        drawable.toBitmap(
            width = (drawable.intrinsicWidth * density).toInt(),
            height = (drawable.intrinsicHeight * density).toInt()
        )
    }

    Image(
        bitmap = bitmap.asImageBitmap(),
        contentDescription = null, // Provide a content description if needed
        modifier = Modifier.size(40.dp) // Set the size as needed
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewWhiteListAppFeature() {
    AppTheme {
//        WhiteListAppFeature(
//            drawable = ,
//            contentTextRes = R.string.facebook,
//            onSwitchButtonClicked = {},
//        )
    }
}