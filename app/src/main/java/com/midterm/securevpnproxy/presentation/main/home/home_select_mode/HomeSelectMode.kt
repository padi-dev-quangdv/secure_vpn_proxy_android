package com.midterm.securevpnproxy.presentation.main.home.home_select_mode

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.compose.ButtonColors
import com.midterm.securevpnproxy.base.compose.LargeTextBold
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.customview.LargeSolidButton
import com.tanify.library.dns.domain.model.server_list.ServerGroupType

@Composable
fun HomeSelectModeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeSelectModeViewModel = viewModel(),
    onBackClicked: () -> Unit,
) {
    val modeOptions = mapOf(
        Pair(ServerGroupType.Standard.id, ServerGroupType.Standard.name),
        Pair(ServerGroupType.Intense.id, ServerGroupType.Intense.name),
        Pair(ServerGroupType.Ultimate.id, ServerGroupType.Ultimate.name)
    )
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(
            text = stringResource(id = R.string.select_mode),
            style = LargeTextBold,
            color = LocalColors.current.neutral90,
            modifier = Modifier.padding(start = 24.dp, top = 24.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        HomeSelectModeContent(modeOptions = modeOptions, viewModel = viewModel)
        Spacer(modifier = Modifier.weight(1f))
        LargeSolidButton(
            text = stringResource(id = R.string.back),
            color = ButtonColors.buttonColorBlue(),
            onClick = onBackClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        )
    }
}