package com.midterm.securevpnproxy.presentation.main.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.fragment.findNavController
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.BaseComposeFragment
import com.midterm.securevpnproxy.databinding.LayoutComposeOnlyBinding
import com.midterm.securevpnproxy.presentation.main.ui.MainHeaderUi
import com.midterm.securevpnproxy.presentation.ui_model.UiUserStatus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment :
    BaseComposeFragment<LayoutComposeOnlyBinding, ProfileViewModel>(layoutId2 = R.layout.layout_compose_only) {

    override fun initData() {
    }

    override fun getMainComposeView(): ComposeView = binding.composeView

    @Composable
    override fun MainComposeViewContent(modifier: Modifier) {
        val viewState by viewModel.state.collectAsStateWithLifecycle(initialValue = ProfileViewModel.ViewState())
        val userStatus = viewState.userModel?.status ?: UiUserStatus.FreeTrial

        Column(modifier = modifier.fillMaxSize()) {
            MainHeaderUi(onBackClicked = {
                navigateBack()
            })
            UserInfoContent(
                userName = viewState.userModel?.fullName ?: "",
                onLogoutClicked = { /*TODO*/ },
            )
            Spacer(modifier = Modifier.height(18.dp))
            if(userStatus != UiUserStatus.Premium) {
                PremiumBenefitInfo()
            }
            Spacer(modifier = Modifier.height(6.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                item {
                    UserFeature(
                        contentText = stringResource(id = R.string.account),
                        onFeatureClicked = { gotoAccountScreen() }
                    )
                }
                item {
                    UserFeature(
                        contentText = stringResource(id = R.string.settings),
                        onFeatureClicked = { gotoSettingsScreen() }
                    )
                }
                item {
                    UserFeature(
                        contentText = stringResource(id = R.string.support),
                        onFeatureClicked = { gotoSupportScreen() }
                    )
                }
                item {
                    UserFeature(
                        contentText = stringResource(id = R.string.about),
                        onFeatureClicked = { gotoAboutScreen() }
                    )
                }
            }
        }
    }

    private fun navigateBack() {
        findNavController().navigateUp()
    }

    private fun gotoAccountScreen() {
        val action = ProfileFragmentDirections.actionProfileFragmentToAccountInformationFragment()
        findNavController().navigate(action)
    }

    private fun gotoSettingsScreen() {
        val action = ProfileFragmentDirections.actionProfileFragmentToSettingsFragment()
        findNavController().navigate(action)
    }

    private fun gotoSupportScreen() {
    }

    private fun gotoAboutScreen() {
        val action = ProfileFragmentDirections.actionProfileFragmentToAboutFragment()
        findNavController().navigate(action)
    }

    override fun initView() {
    }
}