package com.midterm.securevpnproxy.presentation.main.profile

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.midterm.securevpnproxy.base.compose.HandleEffect
import com.midterm.securevpnproxy.databinding.LayoutComposeOnlyBinding
import com.midterm.securevpnproxy.presentation.StartActivity
import com.midterm.securevpnproxy.presentation.main.ui.MainHeaderUi
import com.midterm.securevpnproxy.presentation.main.ui.TanifyFeature
import com.midterm.securevpnproxy.presentation.ui_model.UiUserStatus
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow

@AndroidEntryPoint
class ProfileFragment :
    BaseComposeFragment<LayoutComposeOnlyBinding, ProfileViewModel>(layoutId2 = R.layout.layout_compose_only),
    HandleEffect<ProfileViewModel.ViewEffect> {

    override fun initData() {
    }

    override fun getMainComposeView(): ComposeView = binding.composeView

    override val provideEffectFlow: Flow<ProfileViewModel.ViewEffect>
        get() = viewModel.effect

    override fun onEffectTriggered(effect: ProfileViewModel.ViewEffect?) {
        when (effect) {
            is ProfileViewModel.ViewEffect.Error -> {
                Toast.makeText(
                    requireContext(),
                    effect.message,
                    Toast.LENGTH_LONG
                ).show()
            }

            is ProfileViewModel.ViewEffect.SignOutSuccess -> {
                startActivity(Intent(context, StartActivity::class.java))
                activity?.finish()
            }

            else -> {

            }
        }
    }

    override val loadingView: View
        get() = binding.loading

    override val loadingState: Flow<Boolean>
        get() = viewModel.loadingState

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
                onLogoutClicked = {
                    viewModel.onEvent(ProfileViewModel.ViewEvent.SignOut)
                },
            )
            Spacer(modifier = Modifier.height(18.dp))
            if (userStatus != UiUserStatus.Premium) {
                PremiumBenefitInfo()
            }
            Spacer(modifier = Modifier.height(6.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                item {
                    TanifyFeature(
                        contentText = stringResource(id = R.string.account),
                        onFeatureClicked = { gotoAccountScreen() }
                    )
                }
                item {
                    TanifyFeature(
                        contentText = stringResource(id = R.string.settings),
                        onFeatureClicked = { gotoSettingsScreen() }
                    )
                }
                item {
                    TanifyFeature(
                        contentText = stringResource(id = R.string.support),
                        onFeatureClicked = { gotoSupportScreen() }
                    )
                }
                item {
                    TanifyFeature(
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