package com.midterm.securevpnproxy.login

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.forEachIndexed
import androidx.core.view.indices
import androidx.navigation.fragment.findNavController
import com.midterm.securevpnproxy.OnBoardingData
import com.midterm.securevpnproxy.R
import com.midterm.securevpnproxy.databinding.FragmentOnboardingBinding


class OnBoardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!
    var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(restorePrefData()) {
            val action = OnBoardingFragmentDirections.actionOnboardingFragmentToLoginFragment()
            findNavController().navigate(action)
        }

         val onBoardingDataList = listOf(
            OnBoardingData(
                R.drawable.ic_product_launch,
                resources.getString(R.string.title_on_boarding_1),
                resources.getString(R.string.description_on_boarding_1)
            ),
            OnBoardingData(
                R.drawable.ic_coding,
                resources.getString(R.string.title_on_boarding_2),
                resources.getString(R.string.description_on_boarding_2)
            ),
            OnBoardingData(
                R.drawable.ic_location,
                resources.getString(R.string.title_on_boarding_3),
                resources.getString(R.string.description_on_boarding_3)
            )
        )
        val adapter = ViewPagerAdapter(onBoardingDataList)

        binding.apply {
            viewPagerOnBoarding.adapter = adapter
            indicator.setViewPager(binding.viewPagerOnBoarding)
            var position = viewPagerOnBoarding.currentItem
            setButtonText(position,btnContinue)

            tvSkip.setOnClickListener {
                val action = OnBoardingFragmentDirections.actionOnboardingFragmentToLoginFragment()
                findNavController().navigate(action)
            }
            btnContinue.setOnClickListener {
                if (position < onBoardingDataList.size) {
                    position++
                    viewPagerOnBoarding.currentItem = position
                    setButtonText(position,btnContinue)
                }
                if(position == onBoardingDataList.size) {
                    savePrefData()
                    setButtonText(position,btnContinue)
                    val action = OnBoardingFragmentDirections.actionOnboardingFragmentToLoginFragment()
                    findNavController().navigate(action)
                }
            }
        }

    }

    private fun setButtonText(position: Int, btnContinue: Button) {
        when(position) {
            0,1 -> btnContinue.setText(R.string.btn_continue_text)
            2 -> btnContinue.setText(R.string.btn_get_started_text)
            else -> btnContinue.setText(R.string.btn_get_started_text)
        }
    }

    private fun savePrefData() {
        sharedPreferences = activity?.applicationContext?.getSharedPreferences("pref",Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences!!.edit()
        editor.putBoolean("isFirstTimeRun",true)
        editor.apply()
    }

    private fun restorePrefData(): Boolean {
        sharedPreferences = activity?.applicationContext?.getSharedPreferences("pref",Context.MODE_PRIVATE)
        return sharedPreferences!!.getBoolean("isFirstTimeRun",false)
    }


}
