package com.midterm.securevpnproxy.presentation.main.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.fragment.findNavController
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.BaseComposeFragment
import com.midterm.securevpnproxy.databinding.LayoutComposeOnlyBinding
import com.midterm.securevpnproxy.presentation.main.about.ui.ListAboutFeature
import com.midterm.securevpnproxy.presentation.main.ui.MainHeaderUi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment :
    BaseComposeFragment<LayoutComposeOnlyBinding, AboutViewModel>(layoutId2 = R.layout.layout_compose_only) {
    override fun getMainComposeView(): ComposeView = binding.composeView

    @Composable
    override fun MainComposeViewContent(modifier: Modifier) {
        Column(modifier = modifier.fillMaxSize()) {
            MainHeaderUi(
                titleText = stringResource(id = R.string.about),
                onBackClicked = {
                    navigateBack()
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            ListAboutFeature(
                onAboutAppClick = {
                    /* navigate to About */
                },
                onTermsOfServiceClick = {
                    /* navigate to Terms */
                },
                onPolicyClick = {
                    /* navigate to Policy */
                })
        }
    }

    private fun navigateBack() {
        findNavController().navigateUp()
    }

    override fun initData() {
    }

    override fun initView() {
    }


}