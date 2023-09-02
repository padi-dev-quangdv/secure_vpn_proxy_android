package com.midterm.securevpnproxy.presentation.main.white_list

import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.BaseComposeFragment
import com.midterm.securevpnproxy.base.compose.AppTheme
import com.midterm.securevpnproxy.base.compose.LargeTextBold
import com.midterm.securevpnproxy.base.compose.LargeTextMedium
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.MediumTextBold
import com.midterm.securevpnproxy.databinding.LayoutComposeOnlyBinding
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
                .padding(horizontal = 24.dp)
        ) {
            Text(
                text = stringResource(id = R.string.description_whitelist_apps),
                style = MediumTextBold,
                color = LocalColors.current.neutral90,
                maxLines = 2,
                modifier = Modifier
                    .padding(vertical = 24.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = LocalColors.current.colorF8F8F8,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(16.dp)
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
                modifier = Modifier.padding(vertical = 24.dp)
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

    override fun initData() {

    }

    override fun initView() {
    }

}