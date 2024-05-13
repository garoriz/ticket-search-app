package com.garif.main_feature.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.garif.core1.showMessage
import com.garif.core1.util.AppViewModelFactory
import com.garif.core1.util.HorizontalSpacesItemDecoration
import com.garif.main_feature.R
import com.garif.main_feature.databinding.FragmentMainBinding
import com.garif.main_feature.di.MainFeatureComponentProvider
import com.garif.main_feature.domain.entity.Offer
import com.garif.main_feature.presentation.adapter.OfferListAdapter
import javax.inject.Inject


class MainFragment : Fragment(R.layout.fragment_main) {
    @Inject
    lateinit var factory: AppViewModelFactory
    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels {
        factory
    }
    private var offersListAdapter: OfferListAdapter? = null
    private val spaceInRV = 100

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as MainFeatureComponentProvider)
            .getMainFeatureComponent()
            .injectMainFragment(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        with(binding) {
            etTo.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    val modalBottomSheet = ModalBottomSheet(etFrom.text.toString())
                    modalBottomSheet.show(childFragmentManager, ModalBottomSheet.TAG)
                }
            }

            etTo.setOnClickListener {
                val modalBottomSheet = ModalBottomSheet(etFrom.text.toString())
                modalBottomSheet.show(childFragmentManager, ModalBottomSheet.TAG)
            }
        }

        initObservers()
        viewModel.onGetOffers()
    }

    private fun initObservers() {
        viewModel.offers.observe(viewLifecycleOwner) { it ->
            it.fold(onSuccess = {
                offersListAdapter = OfferListAdapter(this@MainFragment)

                binding.offers.run {
                    adapter = offersListAdapter
                }

                offersListAdapter?.submitList(it as MutableList<Offer>)
                val spacesItemDecoration = HorizontalSpacesItemDecoration(
                    spaceInRV
                )
                binding.offers.addItemDecoration(spacesItemDecoration)
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
}