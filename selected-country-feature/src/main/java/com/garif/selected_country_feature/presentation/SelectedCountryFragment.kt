package com.garif.selected_country_feature.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.garif.core1.navigate
import com.garif.core1.navigationData
import com.garif.core1.showMessage
import com.garif.core1.util.AppViewModelFactory
import com.garif.selected_country_feature.R
import com.garif.selected_country_feature.databinding.FragmentSelectedCountryBinding
import com.garif.selected_country_feature.di.SelectedCountryFeatureComponentProvider
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class SelectedCountryFragment : Fragment(R.layout.fragment_selected_country) {
    @Inject
    lateinit var factory: AppViewModelFactory
    private lateinit var binding: FragmentSelectedCountryBinding
    private val viewModel: SelectedCountryViewModel by viewModels {
        factory
    }
    private var flightDate = ""

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as SelectedCountryFeatureComponentProvider)
            .getSelectedCountryFeatureComponent()
            .injectSelectedCountryFragment(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSelectedCountryBinding.bind(view)

        with(binding) {
            val navigationData = navigationData as? Pair<*, *>
            etFrom.setText(navigationData?.first as? String ?: return)
            etTo.setText(navigationData.second as? String ?: return)

            ivBack.setOnClickListener {
                findNavController().popBackStack()
            }

            ivChange.setOnClickListener {
                val etToString = etTo.text.toString()
                etTo.setText(etFrom.text.toString())
                etFrom.setText(etToString)
                saveEtFromValue()
            }

            ivClear.setOnClickListener {
                etTo.text.clear()
            }

            setDate(System.currentTimeMillis(), tvDate, tvDayOfWeek)

            etFrom.setOnFocusChangeListener { _, hasFocus ->
                if (!hasFocus) {
                    saveEtFromValue()
                }
            }

            btnDate.setOnClickListener {
                val datePicker =
                    MaterialDatePicker.Builder.datePicker()
                        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                        .build()
                datePicker.show(childFragmentManager, "tag")
                setDatePickerListenerForDispatch(datePicker)
            }

            btnBack.setOnClickListener {
                val datePicker =
                    MaterialDatePicker.Builder.datePicker()
                        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                        .build()
                datePicker.show(childFragmentManager, "tag")
                setDatePickerListenerForReturning(datePicker)
            }

            btnSeeAllTickets.setOnClickListener {
                navigate(
                    R.id.action_selectedCountryFragment_to_allTicketsFragment,
                    data = Pair(
                        etFrom.text.toString() + "-" + etTo.text.toString(),
                        flightDate + ", " + getString(com.garif.core1.R.string.one_passenger)
                    )
                )
            }
        }

        initObservers()
        viewModel.onGetTicketsOffer()
    }

    private fun setDatePickerListenerForReturning(datePicker: MaterialDatePicker<Long>) {
        with(binding) {
            datePicker.addOnPositiveButtonClickListener {
                defaultGroup.isVisible = false
                selectedDateGroup.isVisible = true
                setDate(it, tvReturningDate, tvReturningDayOfWeek)
            }

            datePicker.addOnNegativeButtonClickListener {
                defaultGroup.isVisible = true
                selectedDateGroup.isVisible = false
            }
        }
    }

    private fun setDatePickerListenerForDispatch(datePicker: MaterialDatePicker<Long>) {
        datePicker.addOnPositiveButtonClickListener {
            with(binding) {
                setDate(it, tvDate, tvDayOfWeek)
            }
        }
    }

    private fun setDate(timeMillis: Long, tvDate: TextView, tvDayOfWeek: TextView) {
        val dateLong = Date(timeMillis)
        var sdfdate = SimpleDateFormat("dd ", Locale.getDefault()).format(dateLong)
        val shortMonth = SimpleDateFormat("MMM", Locale.getDefault()).format(dateLong).take(3)
        flightDate = sdfdate + SimpleDateFormat("MMMM", Locale.getDefault()).format(dateLong)
        sdfdate = "$sdfdate$shortMonth"
        var dayOfWeek = ", "
        dayOfWeek += SimpleDateFormat("EE", Locale.getDefault()).format(dateLong)
        tvDate.text = sdfdate
        tvDayOfWeek.text = dayOfWeek
    }

    private fun initObservers() {
        viewModel.ticketsOffers.observe(viewLifecycleOwner) { it ->
            it.fold(onSuccess = {
                with(binding) {
                    tvFirstCompany.text = it[0].title
                    tvFirstCompanyPrice.text = it[0].price
                    tvTimeRangeInFirstCompany.text = it[0].timeRange
                    tvSecondCompany.text = it[1].title
                    tvSecondCompanyPrice.text = it[1].price
                    tvTimeRangeInSecondCompany.text = it[1].timeRange
                    tvThirdCompany.text = it[2].title
                    tvThirdCompanyPrice.text = it[2].price
                    tvTimeRangeInThirdCompany.text = it[2].timeRange
                }
            }, onFailure = {
                Log.e("e", it.message.toString())
            })
        }

        viewModel.error.observe(viewLifecycleOwner) {
            when (it) {
                is Exception -> {
                    showMessage(binding.root, com.garif.core1.R.string.error)
                }
            }
        }
    }

    private fun saveEtFromValue() {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
            ?: return
        with(sharedPref.edit()) {
            putString(
                getString(com.garif.core1.R.string.et_from_value),
                binding.etFrom.text.toString()
            )
            apply()
        }
    }
}