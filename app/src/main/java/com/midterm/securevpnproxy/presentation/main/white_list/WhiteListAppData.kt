package com.midterm.securevpnproxy.presentation.main.white_list

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.midterm.securevpnproxy.R

enum class WhiteListAppData(
    @DrawableRes val imageTitle: Int,
    @StringRes val content: Int,
    var isEnabled: Boolean = false
) {
    Facebook(imageTitle = R.drawable.icon_facebook, content = R.string.facebook, isEnabled = true),
    Instagram(imageTitle = R.drawable.icon_instagram, content = R.string.instagram, isEnabled = true),
    Twitter(imageTitle = R.drawable.icon_twitter, content = R.string.twitter),
    Spotify(imageTitle = R.drawable.icon_spotify, content = R.string.spotify),
    Youtube(imageTitle = R.drawable.icon_youtube, content = R.string.youtube),
    Gmail(imageTitle = R.drawable.icon_gmail, content = R.string.gmail),
    Chrome(imageTitle = R.drawable.icon_chrome, content = R.string.chrome, isEnabled = true),
    Notion(imageTitle = R.drawable.icon_notion, content = R.string.notion),
    Tiktok(imageTitle = R.drawable.icon_tiktok, content = R.string.tiktok),
}