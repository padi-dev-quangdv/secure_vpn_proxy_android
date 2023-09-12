package com.midterm.securevpnproxy.presentation.auth.reset_password

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.fragment.findNavController
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.BaseComposeFragment
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.MediumTextSemiBold
import com.midterm.securevpnproxy.databinding.LayoutComposeOnlyBinding

class CheckEmailFragment :
    BaseComposeFragment<LayoutComposeOnlyBinding, CheckEmailViewModel>(layoutId2 = R.layout.layout_compose_only){

    override fun getMainComposeView(): ComposeView = binding.composeView

    @Composable
    override fun MainComposeViewContent(modifier: Modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(24.dp)
        ) {
            Spacer(modifier = Modifier.weight(0.34f))
            ResetPasswordHeader(
                imageTitle = R.drawable.icon_large_mail,
                titleSrc = R.string.title_check_email,
                descSrc = R.string.description_check_email,
            )
            Spacer(modifier = Modifier.weight(0.08f))
            Text(
                text = stringResource(id = R.string.forgot_password_navigate_to_login),
                style = MediumTextSemiBold,
                color = LocalColors.current.neutral90,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .clickable {
                        gotoLogin()
                    }
            )
            Spacer(modifier = Modifier.weight(0.23f))
        }
    }

    override fun initData() {
    }

    private fun gotoLogin() {
        val action = CheckEmailFragmentDirections.actionCheckEmailFragmentToLoginFragment()
        findNavController().navigate(action)
    }


    override fun initView() {
    }
}