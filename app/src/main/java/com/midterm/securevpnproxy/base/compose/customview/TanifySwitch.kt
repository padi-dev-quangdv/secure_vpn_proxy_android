package com.midterm.securevpnproxy.base.compose.customview

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.midterm.securevpnproxy.base.compose.AppTheme
import com.midterm.securevpnproxy.base.compose.LocalColors

@Composable
fun TanifySwitch(
    onSwitch: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    scale: Float = 2f,
    width: Dp = 24.dp,
    height: Dp = 13.dp,
    checkedTrackColor: Color = LocalColors.current.infoMain,
    unCheckedTrackColor: Color = LocalColors.current.neutral60,
    circleColor: Color = LocalColors.current.white,
    gapBetweenThumbAndTrackEdge: Dp = 2.dp,
    isEnabled: Boolean = false,
) {

    var switchOn by remember {
        mutableStateOf(isEnabled)
    }

    val thumbRadius = (height / 2) - gapBetweenThumbAndTrackEdge

    val animatePosition = animateFloatAsState(
        targetValue = if (switchOn) {
            with(LocalDensity.current) { (width - thumbRadius - gapBetweenThumbAndTrackEdge).toPx() }
        } else {
            with(LocalDensity.current) { (thumbRadius + gapBetweenThumbAndTrackEdge).toPx() }
        }, label = ""
    )

    Canvas(modifier = modifier
        .size(width = width, height = height)
        .scale(scale)
        .pointerInput(Unit) {
            detectTapGestures(
                onTap = {
                    switchOn = !switchOn
                    onSwitch(switchOn)
                }
            )
        }
    ) {
        drawRoundRect(
            color = if (switchOn) checkedTrackColor else unCheckedTrackColor,
            cornerRadius = CornerRadius(x = 10.dp.toPx(), y = 10.dp.toPx()),
        )
        drawCircle(
            color = circleColor,
            radius = thumbRadius.toPx(),
            center = Offset(
                x = animatePosition.value,
                y = size.height / 2
            )

        )
    }

}

@Composable
@Preview(showBackground = true)
fun PreviewTanifySwitch() {
    AppTheme {
        TanifySwitch(
            onSwitch = {},
        )
    }
}