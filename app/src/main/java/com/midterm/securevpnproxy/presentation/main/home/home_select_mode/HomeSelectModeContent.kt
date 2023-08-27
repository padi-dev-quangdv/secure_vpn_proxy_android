package com.midterm.securevpnproxy.presentation.main.home.home_select_mode

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.compose.AppTheme
import com.midterm.securevpnproxy.base.compose.LocalColors
import com.midterm.securevpnproxy.base.compose.MediumTextSemiBold
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tanify.library.dns.domain.model.server_list.ServerGroupType

@Composable
fun HomeSelectModeContent(
    serverGroupTypes: List<ServerGroupType>,
    modifier: Modifier = Modifier,
    viewModel: HomeSelectModeViewModel = viewModel(),
) {
    val viewState by
    viewModel.state.collectAsStateWithLifecycle(initialValue = HomeSelectModeViewModel.ViewState())
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        serverGroupTypes.forEach {
            ItemSelectMode(contentText = it.displayName,
                isSelected = viewState.currentGroupType?.id == it.id, onItemSelected = {
                    viewModel.onEvent(
                        HomeSelectModeViewModel.ViewEvent.SwitchServerGroupType(
                            it.id
                        )
                    )
                }, onInfoClicked = {})
        }
    }
}

@Composable
fun ItemSelectMode(
    contentText: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    onItemSelected: () -> Unit,
    onInfoClicked: () -> Unit,
    textColor: Color = LocalColors.current.neutral90,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .border(
                border = ButtonDefaults.outlinedBorder,
                shape = RoundedCornerShape(50.dp)
            )
    ) {
        ItemSelected(
            isSelected = isSelected,
            onItemClicked = onItemSelected,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp, bottom = 20.dp)
                .clickable {
                    onItemSelected()
                }
        )
        Text(
            text = contentText,
            color = textColor,
            style = MediumTextSemiBold,
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.ic_status),
            contentDescription = "Status",
        )
        Image(
            painter = painterResource(id = R.drawable.ic_information),
            contentDescription = "Information",
            modifier = Modifier
                .padding(start = 10.dp, end = 20.dp)
                .clickable { onInfoClicked() }
        )
    }
}

@Composable
fun ItemSelected(
    onItemClicked: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
) {
    val iconRes = if (isSelected) {
        R.drawable.ic_mode_select
    } else {
        R.drawable.ic_mode_unselect
    }
    Image(painter = painterResource(id = iconRes), contentDescription = "",
        modifier.clickable {
            onItemClicked()
        })
}

@Preview(showBackground = true)
@Composable
fun PreviewItemSelectMode() {
    AppTheme {
        ItemSelectMode(contentText = "Security filter", onItemSelected = { }, onInfoClicked = {})
    }
}