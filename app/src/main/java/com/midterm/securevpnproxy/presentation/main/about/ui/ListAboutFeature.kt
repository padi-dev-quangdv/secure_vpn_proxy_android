package com.midterm.securevpnproxy.presentation.main.about.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.compose.AppTheme
import com.midterm.securevpnproxy.presentation.main.ui.TanifyFeature

@Composable
fun ListAboutFeature(
    onAboutAppClick: () -> Unit,
    onTermsOfServiceClick: () -> Unit,
    onPolicyClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        TanifyFeature(
            contentText = stringResource(id = R.string.about_app),
            onFeatureClicked = onAboutAppClick
        )
        TanifyFeature(
            contentText = stringResource(id = R.string.terms_of_service),
            onFeatureClicked = onTermsOfServiceClick
        )
        TanifyFeature(
            contentText = stringResource(id = R.string.privacy_policy),
            onFeatureClicked =onPolicyClick
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewListAboutFeature() {
    AppTheme {
        ListAboutFeature(
            onAboutAppClick = {  },
            onTermsOfServiceClick = {  },
            onPolicyClick = {  })
    }
}