package com.midterm.securevpnproxy.presentation.auth.reset_password

import android.view.View
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.fragment.findNavController
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.BaseComposeFragment
import com.midterm.securevpnproxy.base.compose.ButtonColors
import com.midterm.securevpnproxy.base.compose.HandleEffect
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.MediumTextSemiBold
import com.midterm.securevpnproxy.base.compose.customview.LargeSolidButton
import com.midterm.securevpnproxy.base.compose.customview.text_field.AppEditText
import com.midterm.securevpnproxy.databinding.LayoutComposeOnlyBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow

@AndroidEntryPoint
class ForgotPasswordFragment :
    BaseComposeFragment<LayoutComposeOnlyBinding, ForgotPasswordViewModel>(layoutId2 = R.layout.layout_compose_only),
    HandleEffect<ForgotPasswordViewModel.ViewEffect> {

    override fun getMainComposeView(): ComposeView = binding.composeView

    override val provideEffectFlow: Flow<ForgotPasswordViewModel.ViewEffect>
        get() = viewModel.effect

    override val loadingView: View
        get() = binding.loading

    override val loadingState: Flow<Boolean>
        get() = viewModel.loadingState

    @Composable
    override fun MainComposeViewContent(modifier: Modifier) {
        val viewState by viewModel.state.collectAsStateWithLifecycle(initialValue = ForgotPasswordViewModel.ViewState())
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(24.dp)
        ) {
            ResetPasswordHeader(
                imageTitle = R.drawable.ic_unlock,
                titleSrc = R.string.forgot_password,
                descSrc = R.string.description_forgot_password,
            )
            ForgotPasswordForm(
                email = viewState.email,
                emailError = viewState.emailError,
                emailPlaceholder = viewState.emailPlaceHolder,
                onEmailChange = { viewModel.onEvent(ForgotPasswordViewModel.ViewEvent.UpdateEmail(it)) },
                onSendClicked = { viewModel.onEvent(ForgotPasswordViewModel.ViewEvent.ResetPasswordEvent) },
                onBackToLoginClicked = { gotoLogin() },
            )
        }
    }

    @Composable
    fun ForgotPasswordForm(
        email: String,
        emailError: String?,
        emailPlaceholder: String,
        onEmailChange: (String) -> Unit,
        onSendClicked: () -> Unit,
        onBackToLoginClicked: () -> Unit,
        modifier: Modifier = Modifier,
    ) {
        Column(modifier = modifier) {
            AppEditText(
                label = stringResource(id = R.string.email),
                error = emailError,
                onValueChange = onEmailChange,
                placeHolder = emailPlaceholder,
                text = email,
            )
            Spacer(modifier = Modifier.height(16.dp))
            LargeSolidButton(
                text = stringResource(id = R.string.send),
                color = ButtonColors.buttonColorBlue(),
                onClick = onSendClicked,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            )
            Text(
                text = stringResource(id = R.string.forgot_password_navigate_to_login),
                style = MediumTextSemiBold,
                color = LocalColors.current.neutral90,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .clickable {
                    onBackToLoginClicked()
                }
            )
        }
    }

    override fun initData() {}

    private fun gotoLogin() {
        val action =
            ForgotPasswordFragmentDirections.actionForgotPasswordFragmentToLoginFragment()
        findNavController().navigate(action)
    }

    private fun gotoCheckEmailScreen() {
        val action =
            ForgotPasswordFragmentDirections.actionForgotPasswordFragmentToCheckEmailFragment()
        findNavController().navigate(action)
    }


    override fun initViewListener() {
    }

    override fun initView() {
    }

    override fun onEffectTriggered(effect: ForgotPasswordViewModel.ViewEffect?) {
        when (effect) {
            is ForgotPasswordViewModel.ViewEffect.Error -> {
                Toast.makeText(
                    requireContext(),
                    effect.message,
                    Toast.LENGTH_LONG
                ).show()
            }

            is ForgotPasswordViewModel.ViewEffect.SendSuccess -> {
                gotoCheckEmailScreen()
            }
        }
    }
}