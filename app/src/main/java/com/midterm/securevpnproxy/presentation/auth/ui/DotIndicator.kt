package com.midterm.securevpnproxy.presentation.auth.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.midterm.securevpnproxy.base.compose.AppTheme
import com.midterm.securevpnproxy.base.compose.LocalColors

@Composable
fun DotIndicator(
    currentPage: Int,
    pageCount: Int = 3,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        repeat(pageCount) {
            Dot(isSelected = it == currentPage)
        }
    }
}

@Composable
private fun Dot(
    isSelected: Boolean = false,
    color: Color =
        if (isSelected) LocalColors.current.infoMain
        else LocalColors.current.infoSurface,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(24.dp)
            .padding(8.dp)
    ) {
        Spacer(
            modifier = Modifier
                .size(8.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(color, color),
                        radius = 5f
                    ),
                    shape = CircleShape
                )
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewDot() {
    AppTheme {
        DotIndicator(currentPage = 1)
    }
}