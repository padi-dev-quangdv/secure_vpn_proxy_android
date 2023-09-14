package com.midterm.securevpnproxy.presentation.main.account_info

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.fragment.findNavController
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.BaseComposeFragment
import com.midterm.securevpnproxy.base.compose.ButtonColors
import com.midterm.securevpnproxy.base.compose.HandleEffect
import com.midterm.securevpnproxy.base.compose.customview.LargeOutlinedButton
import com.midterm.securevpnproxy.databinding.LayoutComposeOnlyBinding
import com.midterm.securevpnproxy.presentation.StartActivity
import com.midterm.securevpnproxy.presentation.main.ui.MainHeaderUi
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow

@AndroidEntryPoint
class AccountInformationFragment :
    BaseComposeFragment<LayoutComposeOnlyBinding, AccountInformationViewModel>(layoutId2 = R.layout.layout_compose_only),
    HandleEffect<AccountInformationViewModel.ViewEffect> {
    override fun getMainComposeView(): ComposeView = binding.composeView

    override val provideEffectFlow: Flow<AccountInformationViewModel.ViewEffect>
        get() = viewModel.effect

    override fun onEffectTriggered(effect: AccountInformationViewModel.ViewEffect?) {
        when (effect) {
            is AccountInformationViewModel.ViewEffect.Error -> {
                Toast.makeText(
                    requireContext(),
                    effect.message,
                    Toast.LENGTH_LONG
                ).show()
            }

            is AccountInformationViewModel.ViewEffect.SignOutSuccess -> {
                startActivity(Intent(context, StartActivity::class.java))
                activity?.finish()
            }

            else -> {

            }
        }
    }

    @Composable
    override fun MainComposeViewContent(modifier: Modifier) {
        Column(modifier = modifier.fillMaxSize()) {
            MainHeaderUi(
                titleText = getString(R.string.title_account_information),
                onBackClicked = {
                    navigateBack()
                })
            AccountFields(
                manageAccountFeatureOnClick = {
                    //  navigate to manage account
                })
            LargeOutlinedButton(
                text = stringResource(id = R.string.logout),
                outlinedColor = ButtonColors.outlinedButtonColorBlue(),
                onClick = {
                    viewModel.onEvent(AccountInformationViewModel.ViewEvent.SignOut)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )
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