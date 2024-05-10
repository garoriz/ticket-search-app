package com.garif.ticketsearchapp.presentation.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.garif.core1.util.AppViewModelFactory
import com.garif.core1.util.SpacesItemDecoration
import com.garif.ticketsearchapp.R
import com.garif.ticketsearchapp.databinding.FragmentMainBinding
import com.garif.ticketsearchapp.di.MainFeatureComponentProvider
import com.garif.ticketsearchapp.domain.entity.Offer
import com.garif.ticketsearchapp.presentation.main.adapter.OfferListAdapter
import com.google.android.material.snackbar.Snackbar
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
                ivClear.isVisible = hasFocus
                tvMusicallyFly.isVisible = !hasFocus
                offers.isVisible = !hasFocus
                modalWindow.isVisible = hasFocus
            }

            ivClear.setOnClickListener {
                etTo.text.clear()
            }

            cvDifficultRoute.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_airline_tickets_to_blank_fragment)
            }

            cvAnywhere.setOnClickListener {
                etTo.setText(getString(R.string.anywhere))
            }

            cvWeekend.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_airline_tickets_to_blank_fragment)
            }

            cvHotTickets.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_airline_tickets_to_blank_fragment)
            }

            cvIstanbul.setOnClickListener {
                etTo.setText(getString(R.string.Istanbul))
            }

            cvSochi.setOnClickListener {
                etTo.setText(getString(R.string.Sochi))
            }

            cvPhuket.setOnClickListener {
                etTo.setText(getString(R.string.phuket))
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
                val spacesItemDecoration = SpacesItemDecoration(
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
                    showMessage(com.garif.core1.R.string.error)
                }
            }
        }
    }

    private fun showMessage(stringId: Int) {
        Snackbar.make(
            binding.root,
            stringId,
            Snackbar.LENGTH_LONG
        ).show()
    }
}