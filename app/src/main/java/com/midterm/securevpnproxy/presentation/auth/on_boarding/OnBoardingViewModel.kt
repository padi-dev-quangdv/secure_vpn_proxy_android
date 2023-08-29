package com.midterm.securevpnproxy.presentation.auth.on_boarding


import android.content.Context
import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.base.BaseViewEffect
import com.midterm.securevpnproxy.base.BaseViewEvent
import com.midterm.securevpnproxy.base.BaseViewModel
import com.midterm.securevpnproxy.base.BaseViewState
import com.tanify.library.localdb.tanify.UserDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val userDataStore: UserDataStore,
): BaseViewModel<OnBoardingViewModel.ViewState, OnBoardingViewModel.ViewEvent, OnBoardingViewModel.ViewEffect>(
    ViewState()
) {

    private var sharedPreferences: SharedPreferences? = null

    fun savePrefData(fragment: Fragment) {
        sharedPreferences = fragment.activity?.applicationContext?.getSharedPreferences(
            "pref",
            Context.MODE_PRIVATE
        )
        val editor: SharedPreferences.Editor = sharedPreferences!!.edit()
        editor.putBoolean("isFirstTimeRun", true)
        editor.apply()
    }

    fun restorePrefData(fragment: Fragment): Boolean {
        sharedPreferences = fragment.activity?.applicationContext?.getSharedPreferences(
            "pref",
            Context.MODE_PRIVATE
        )
        return sharedPreferences!!.getBoolean("isFirstTimeRun", false)
    }

    override fun onEvent(event: ViewEvent) {
        when(event) {
            is ViewEvent.MoveToFirstPage -> moveToFirstPage()
            is ViewEvent.MoveToSecondPage -> moveToSecondPage()
            is ViewEvent.MoveToThirdPage -> moveToThirdPage()
            is ViewEvent.ClickButtonStarted -> {}
        }
    }

    private fun moveToFirstPage() {
        setState(currentState.copy(
            imageRes = R.drawable.ic_product_launch,
            titleRes = R.string.title_on_boarding_1,
            descRes = R.string.description_on_boarding_1,
            buttonText = R.string.btn_continue_text
        ))
    }

    private fun moveToSecondPage() {
        setState(currentState.copy(
            imageRes = R.drawable.ic_coding,
            titleRes = R.string.title_on_boarding_2,
            descRes = R.string.description_on_boarding_2,
            buttonText = R.string.btn_continue_text
        ))
    }

    private fun moveToThirdPage() {
        setState(currentState.copy(
            imageRes = R.drawable.ic_location,
            titleRes = R.string.title_on_boarding_3,
            descRes = R.string.description_on_boarding_3,
            buttonText = R.string.btn_get_started_text
        ))
    }

    data class ViewState(
        val imageRes: Int = R.drawable.ic_product_launch,
        val titleRes: Int = R.string.title_on_boarding_1,
        val descRes: Int = R.string.description_on_boarding_1,
        val buttonText: Int = R.string.btn_continue_text,
    ): BaseViewState

    sealed interface ViewEvent: BaseViewEvent {
        object MoveToFirstPage: ViewEvent
        object MoveToSecondPage: ViewEvent
        object MoveToThirdPage: ViewEvent
        object ClickButtonStarted: ViewEvent
    }

    sealed interface ViewEffect: BaseViewEffect


}