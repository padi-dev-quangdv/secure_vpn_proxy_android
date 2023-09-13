package com.midterm.securevpnproxy.presentation.main.white_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.fragment.findNavController
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.BaseComposeFragment
import com.midterm.securevpnproxy.base.compose.AppTheme
import com.midterm.securevpnproxy.base.compose.LargeTextMedium
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.MediumTextBold
import com.midterm.securevpnproxy.databinding.LayoutComposeOnlyBinding
import com.midterm.securevpnproxy.presentation.main.ui.MainHeaderUi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WhiteListAppsFragment :
    BaseComposeFragment<LayoutComposeOnlyBinding, WhiteListViewModel>(layoutId2 = R.layout.layout_compose_only) {

    override fun getMainComposeView(): ComposeView = binding.composeView

    @Composable
    override fun MainComposeViewContent(modifier: Modifier) {
        val viewState by viewModel.state.collectAsStateWithLifecycle(initialValue = WhiteListViewModel.ViewState())
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            MainHeaderUi(
                titleText = stringResource(id = R.string.whitelist_apps),
                onBackClicked = {
                    navigateBack()
                })
            Text(
                text = stringResource(id = R.string.description_whitelist_apps),
                style = MediumTextBold,
                color = LocalColors.current.neutral90,
                maxLines = 2,
                modifier = Modifier
                    .padding(vertical = 24.dp, horizontal = 24.dp)
            )
            Row(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth()
                    .background(
                        color = LocalColors.current.colorF8F8F8,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(vertical = 16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.search_app),
                    style = LargeTextMedium,
                    color = LocalColors.current.neutral70,
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search",
                )
            }
            LazyColumn(
                modifier = Modifier.padding(24.dp)
            ) {
                items(viewState.currentAppPackageNames) {
                    WhiteListAppFeature(
                        drawable = it.appIcon ?: return@items,
                        contentText = it.appName,
                        onSwitchButtonClicked = {},
                    )
                }
            }

        }
    }

    @Composable
    @Preview(showBackground = true)
    fun PreviewWhiteListAppsFragment() {
        AppTheme {
            MainComposeViewContent(modifier = Modifier)
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