package com.midterm.securevpnproxy.presentation.main.premium

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.BaseComposeFragment
import com.midterm.securevpnproxy.databinding.LayoutComposeOnlyBinding
import com.midterm.securevpnproxy.presentation.main.premium.ui.BillSelectionLayout
import com.midterm.securevpnproxy.presentation.main.premium.ui.PremiumContent
import com.midterm.securevpnproxy.presentation.main.premium.ui.PremiumHeader

class PremiumFragment :
    BaseComposeFragment<LayoutComposeOnlyBinding, PremiumViewModel>(layoutId2 = R.layout.layout_compose_only) {
    override fun getMainComposeView(): ComposeView = binding.composeView

    @Composable
    override fun MainComposeViewContent(modifier: Modifier) {
        LazyColumn(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier.fillMaxSize()) {
            item {
                PremiumHeader()
            }
            item {
                BillSelectionLayout(onSwitchSelection = {
                    //todo: Switch selection
                })
            }
            item {
                PremiumContent()
            }
        }
    }

    override fun initData() {
    }

    override fun initView() {
    }
}