package com.midterm.securevpnproxy.presentation.auth.on_boarding

import com.midterm.securevpnproxy.R

enum class OnBoardingPages(
    val imageRes: Int,
    val titleRes: Int,
    val descRes: Int,
    val buttonText: Int,
) {
    PageOne(
        imageRes = R.drawable.ic_product_launch,
        titleRes = R.string.title_on_boarding_1,
        descRes = R.string.description_on_boarding_1,
        buttonText = R.string.btn_continue_text,
    ),
    PageTwo(
        imageRes = R.drawable.ic_coding,
        titleRes = R.string.title_on_boarding_2,
        descRes = R.string.description_on_boarding_2,
        buttonText = R.string.btn_continue_text,
    ),
    PageThree(
        imageRes = R.drawable.ic_location,
        titleRes = R.string.title_on_boarding_3,
        descRes = R.string.description_on_boarding_3,
        buttonText = R.string.btn_get_started_text,
    ),
}