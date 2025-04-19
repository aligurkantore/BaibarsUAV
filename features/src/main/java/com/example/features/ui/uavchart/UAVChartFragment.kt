package com.example.features.ui.uavchart

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import com.example.core.base.BaseFragment
import com.example.core.utils.navigateBack
import com.example.core.utils.navigateSafe
import com.example.features.R
import com.example.features.databinding.FragmentUAVChartBinding
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UAVChartFragment : BaseFragment<FragmentUAVChartBinding, UAVChartViewModel>() {

    override fun initViewModel(): Class<UAVChartViewModel> {
        return UAVChartViewModel::class.java
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUAVChartBinding {
        return FragmentUAVChartBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToBack()
    }

    override fun observeViewModel() {
        collectFlow(viewModel.uavData) { data ->
            data?.let {
                setupChart(it.gpsLatitude, it.gpsLongitude)
            }
        }
    }

    private fun setupChart(gps1: Double, gps2: Double) {
        val chart = binding.chart

        val values = ArrayList<Entry>()
        values.add(Entry(0f, gps1.toFloat()))
        values.add(Entry(1f, gps2.toFloat()))

        val dataSet = LineDataSet(values, getString(R.string.gps_data)).apply {
            color = "#D17842".toColorInt()
            valueTextColor = Color.WHITE
            setDrawValues(true)
            setDrawCircles(true)
            setDrawCircleHole(false)
            circleRadius = 5f
            setCircleColor(Color.WHITE)
            lineWidth = 2f
            chart.legend.textColor = Color.WHITE
        }

        val lineData = LineData(dataSet)
        chart.data = lineData

        chart.xAxis.apply {
            granularity = 1f
            valueFormatter = IndexAxisValueFormatter(
                listOf(
                    getString(R.string.latitude),
                    getString(R.string.longitude)
                )
            )
            textColor = Color.WHITE
        }

        chart.description.apply {
            isEnabled = true
            text = getString(R.string.uav_chart_desc)
            textColor = Color.WHITE
            textSize = 14f
        }

        chart.setTouchEnabled(true)
        chart.isDragEnabled = true
        chart.isScaleXEnabled = true
        chart.isScaleYEnabled = true

        chart.notifyDataSetChanged()
        chart.invalidate()
    }

    private fun navigateToBack(){
        binding.buttonBack.setOnClickListener {
            navigateBack()
        }
    }

}
