package com.garif.main_feature.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.garif.core1.navigate
import com.garif.main_feature.R
import com.garif.main_feature.databinding.ModalWindowBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalBottomSheet(
    from: String,
) : BottomSheetDialogFragment() {
    private val _from = from
    private lateinit var binding: ModalWindowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? = inflater.inflate(R.layout.modal_window, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ModalWindowBinding.bind(view)
        dialog?.setOnShowListener { dialog ->
            val d = dialog as BottomSheetDialog
            val bottomSheet = d.findViewById<View>(R.id.modal_window) as ConstraintLayout
            val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        with(binding) {
            etFrom.setText(_from)

            ivClear.setOnClickListener {
                etTo.text.clear()
            }

            cvDifficultRoute.setOnClickListener {
                navigate(R.id.action_mainFragment_to_blankFragment)
            }

            cvAnywhere.setOnClickListener {
                etTo.setText(getString(com.garif.core1.R.string.anywhere))
                navigate(
                    R.id.action_mainFragment_to_selectedCountryFragment,
                    data = Pair(etFrom.text.toString(), etTo.text.toString())
                )
            }

            cvWeekend.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_blankFragment)
            }

            cvHotTickets.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_blankFragment)
            }

            cvIstanbul.setOnClickListener {
                etTo.setText(getString(com.garif.core1.R.string.Istanbul))
                navigate(
                    R.id.action_mainFragment_to_selectedCountryFragment,
                    data = Pair(etFrom.text.toString(), etTo.text.toString())
                )
            }

            cvSochi.setOnClickListener {
                etTo.setText(getString(com.garif.core1.R.string.Sochi))
                navigate(
                    R.id.action_mainFragment_to_selectedCountryFragment,
                    data = Pair(etFrom.text.toString(), etTo.text.toString())
                )
            }

            cvPhuket.setOnClickListener {
                etTo.setText(getString(com.garif.core1.R.string.phuket))
                navigate(
                    R.id.action_mainFragment_to_selectedCountryFragment,
                    data = Pair(etFrom.text.toString(), etTo.text.toString())
                )
            }

            etTo.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    navigate(
                        R.id.action_mainFragment_to_selectedCountryFragment,
                        data = Pair(etFrom.text.toString(), etTo.text.toString())
                    )
                }
                false
            }
        }
    }


    companion object {
        const val TAG = "ModalBottomSheet"
    }
}