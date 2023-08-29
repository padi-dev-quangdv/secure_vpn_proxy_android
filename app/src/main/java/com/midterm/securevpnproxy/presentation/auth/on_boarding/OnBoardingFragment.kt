package com.midterm.securevpnproxy.presentation.auth.on_boarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.fragment.findNavController
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.BaseComposeFragment
import com.midterm.securevpnproxy.base.compose.ButtonColors
import com.midterm.securevpnproxy.base.compose.LargeTextMedium
import com.midterm.securevpnproxy.base.compose.LargeTextSemiBold
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.customview.LargeSolidButton
import com.midterm.securevpnproxy.databinding.LayoutComposeOnlyBinding
import com.midterm.securevpnproxy.presentation.auth.ui.DotIndicator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OnBoardingFragment :
    BaseComposeFragment<LayoutComposeOnlyBinding, OnBoardingViewModel>(layoutId2 = R.layout.layout_compose_only) {

    override fun getMainComposeView(): ComposeView = binding.composeView

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun MainComposeViewContent(modifier: Modifier) {
        val viewState by viewModel.state.collectAsStateWithLifecycle(initialValue = OnBoardingViewModel.ViewState())
        val pagerState = rememberPagerState()
        val coroutineScope  = rememberCoroutineScope()
        LaunchedEffect(pagerState) {
            snapshotFlow { pagerState.currentPage }.collect { page ->
                when (page) {
                    0 -> viewModel.onEvent(OnBoardingViewModel.ViewEvent.MoveToFirstPage)
                    1 -> viewModel.onEvent(OnBoardingViewModel.ViewEvent.MoveToSecondPage)
                    2 -> viewModel.onEvent(OnBoardingViewModel.ViewEvent.MoveToThirdPage)
                }
            }
        }
        Column(
            horizontalAlignment = Alignment.End,
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Spacer(modifier = Modifier.weight(0.5f))
            Text(
                text = stringResource(id = R.string.skip),
                style = LargeTextMedium,
                fontSize = 16.sp,
                color = LocalColors.current.neutral90,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        gotoLogin()
                    }
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(id = R.string.app_name),
                style = LargeTextSemiBold,
                fontSize = 24.sp,
                color = LocalColors.current.infoMain,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))
            HorizontalPager(
                pageCount = 3,
                state = pagerState,
                modifier = Modifier.weight(7f)
            ) {
                OnBoardingPagerContent(
                    imageRes = viewState.imageRes,
                    titleRes = viewState.titleRes,
                    descRes = viewState.descRes,
                )
            }
            DotIndicator(currentPage = pagerState.currentPage)
            Spacer(modifier = Modifier.weight(2f))
            LargeSolidButton(
                text = stringResource(id = viewState.buttonText),
                color = ButtonColors.buttonColorBlue(),
                onClick = {
                    when (pagerState.currentPage) {
                        0,1 -> {
                            coroutineScope.launch {
                                pagerState.scrollToPage(pagerState.currentPage + 1)
                            }
                        }
                        2 -> {
                            gotoLogin()
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }

    override fun initData() {

    }

    private fun gotoLogin() {
        val action = OnBoardingFragmentDirections.actionOnboardingFragmentToLoginFragment()
        findNavController().navigate(action)
    }

    override fun initView() {

    }

}
