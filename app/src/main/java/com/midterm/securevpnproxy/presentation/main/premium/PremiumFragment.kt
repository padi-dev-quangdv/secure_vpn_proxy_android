package com.midterm.securevpnproxy.presentation.main.premium

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.fragment.findNavController
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.BaseComposeFragment
import com.midterm.securevpnproxy.databinding.LayoutComposeOnlyBinding
import com.midterm.securevpnproxy.presentation.main.premium.ui.BillSelectionLayout
import com.midterm.securevpnproxy.presentation.main.premium.ui.PremiumContent
import com.midterm.securevpnproxy.presentation.main.premium.ui.PremiumHeader
import com.midterm.securevpnproxy.presentation.main.ui.MainHeaderUi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PremiumFragment :
    BaseComposeFragment<LayoutComposeOnlyBinding, PremiumViewModel>(layoutId2 = R.layout.layout_compose_only) {
    override fun getMainComposeView(): ComposeView = binding.composeView

    @Composable
    override fun MainComposeViewContent(modifier: Modifier) {
        val viewState by viewModel.state.collectAsStateWithLifecycle(
            initialValue = PremiumViewModel.ViewState()
        )

        Column(modifier = modifier.fillMaxSize()) {
            MainHeaderUi(onBackClicked = {
                navigateBack()
            })
            LazyColumn(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = modifier.fillMaxWidth()
            ) {
                item {
                }
                item {
                    PremiumHeader()
                }
                item {
                    BillSelectionLayout(onSwitchSelection = {
                        // value equals true => switch on => annually premium
                        // value equals false => switch off => monthly premium
                        viewModel.onEvent(PremiumViewModel.ViewEvent.SwitchSub(it))
                    })
                }
                item {
                    if (viewState.isAnnuallySubscription) {
                        PremiumContent(
                            title = stringResource(id = R.string.annually_premium),
                            price = stringResource(id = R.string.annually_price),
                            subscriptionType = stringResource(id = R.string.year),
                        )
                    } else {
                        PremiumContent(
                            title = stringResource(id = R.string.monthly_premium),
                            price = stringResource(id = R.string.monthly_price),
                            subscriptionType = stringResource(id = R.string.month),
                        )
                    }
                }
            }
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