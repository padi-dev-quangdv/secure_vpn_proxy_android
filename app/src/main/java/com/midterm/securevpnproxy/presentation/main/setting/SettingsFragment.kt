package com.midterm.securevpnproxy.presentation.main.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.fragment.findNavController
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.BaseComposeFragment
import com.midterm.securevpnproxy.databinding.LayoutComposeOnlyBinding
import com.midterm.securevpnproxy.presentation.main.ui.MainHeaderUi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment :
    BaseComposeFragment<LayoutComposeOnlyBinding, SettingsViewModel>(layoutId2 = R.layout.layout_compose_only) {
    override fun getMainComposeView(): ComposeView = binding.composeView

    @Composable
    override fun MainComposeViewContent(modifier: Modifier) {
        val viewState by viewModel.state.collectAsStateWithLifecycle(
            initialValue = SettingsViewModel.ViewState()
        )

        Column(modifier = modifier.fillMaxSize()) {
            MainHeaderUi(
                titleText = getString(R.string.settings),
                onBackClicked = {
                    navigateBack()
                }
            )
            ListFeatureSettings(
                pinProtectClick = {
                    /* navigate to Pin Protect*/
                },
                appsLockClick = {
                    /* navigate to apps lock*/
                },
                customBlockListClick = {
                    /* navigate to custom block list*/
                },
                whiteListAppClick = {
                    navigateToWhiteListApp()
                },
                whiteListAppSize = viewState.whiteListAppSize)
        }
    }

    private fun navigateBack() {
        findNavController().navigateUp()
    }

    private fun navigateToWhiteListApp() {
        val action = SettingsFragmentDirections.actionSettingsFragmentToWhiteListAppsFragment()
        findNavController().navigate(action)
    }

    override fun initData() {

    }

    override fun initView() {

    }


}