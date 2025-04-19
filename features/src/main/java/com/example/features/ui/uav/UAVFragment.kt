package com.example.features.ui.uav

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.core.base.BaseFragment
import com.example.core.utils.navigateSafe
import com.example.core.utils.visible
import com.example.features.R
import com.example.features.databinding.FragmentUAVBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UAVFragment : BaseFragment<FragmentUAVBinding, UAVViewModel>() {

    private var previousAltitude: Double? = null
    private var previousLatitude: Double? = null
    private var previousLongitude: Double? = null

    override fun initViewModel(): Class<UAVViewModel> {
        return UAVViewModel::class.java
    }

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentUAVBinding {
        return FragmentUAVBinding.inflate(inflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        setupCardViewClickListener()
        return view
    }


    override fun observeViewModel() {
        lifecycleScope.launch {
            collectFlow(viewModel.uavData) { _data ->
                Log.d("agt", "observeViewModel: $_data")
                binding.apply {
                    textBatteryValue.text =
                        getString(R.string.battery_voltage_value, _data?.batteryVoltage)
                    textAltitudeValue.text = getString(R.string.altitude_value, _data?.altitude)
                    textGpsValue.text = getString(
                        R.string.gps_value,
                        _data?.gpsLatitude ?: 0.0,
                        _data?.gpsLongitude ?: 0.0
                    )

                    textFlightTimeValue.text =
                        getString(R.string.flight_time_value, _data?.flightTime)
                    lvDroneAnim.visible()

                    _data?.let { data ->
                        moveLottieBasedOnData(
                            newAltitude = data.altitude.toDouble(),
                            newLatitude = data.gpsLatitude,
                            newLongitude = data.gpsLongitude
                        )
                    }
                }
            }
        }
    }

    private fun moveLottieBasedOnData(
        newLatitude: Double?,
        newLongitude: Double?,
        newAltitude: Double?
    ) {
        if (newLatitude == null || newLongitude == null || newAltitude == null) return

        if (previousLatitude == null || previousLongitude == null || previousAltitude == null) {
            previousLatitude = newLatitude
            previousLongitude = newLongitude
            previousAltitude = newAltitude
            return
        }

        val animView = binding.lvDroneAnim

        val deltaLong = newLongitude - previousLongitude!!
        val deltaAlt = newAltitude - previousAltitude!!

        if (deltaLong > 0.0001) {
            animView.animate().translationXBy(50f).setDuration(500).start()
        } else if (deltaLong < -0.0001) {
            animView.animate().translationXBy(-50f).setDuration(500).start()
        }

        if (deltaAlt > 1) {
            animView.animate().translationYBy(-30f).setDuration(500).start()
        } else if (deltaAlt < -1) {
            animView.animate().translationYBy(30f).setDuration(500).start()
        }

        previousLatitude = newLatitude
        previousLongitude = newLongitude
        previousAltitude = newAltitude
    }


    private fun setupCardViewClickListener() {
        binding.infoCardView.setOnClickListener {
            navigateSafe(R.id.action_UAVFragment_to_UAVChartFragment)
        }
    }

}
