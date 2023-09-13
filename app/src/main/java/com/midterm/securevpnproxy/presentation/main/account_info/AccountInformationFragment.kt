package com.midterm.securevpnproxy.presentation.main.account_info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.fragment.findNavController
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.BaseComposeFragment
import com.midterm.securevpnproxy.base.compose.AppTheme
import com.midterm.securevpnproxy.base.compose.ButtonColors
import com.midterm.securevpnproxy.base.compose.customview.LargeOutlinedButton
import com.midterm.securevpnproxy.databinding.LayoutComposeOnlyBinding
import com.midterm.securevpnproxy.presentation.main.ui.MainHeaderUi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountInformationFragment :
    BaseComposeFragment<LayoutComposeOnlyBinding, AccountInformationViewModel>(layoutId2 = R.layout.layout_compose_only) {
    override fun getMainComposeView(): ComposeView = binding.composeView

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
                    backToLogin()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )
        }
    }

    @Composable
    @Preview(showBackground = true)
    fun PreviewAccountInformationFragment() {
        AppTheme {
            MainComposeViewContent(modifier = Modifier.fillMaxWidth())
        }
    }

    private fun navigateBack() {
        findNavController().navigateUp()
    }

    private fun backToLogin() {
        viewModel.checkLogout()
        activity?.finish()
    }

    override fun initData() {

    }

    override fun initView() {

    }
}