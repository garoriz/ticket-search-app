package com.garif.all_tickets_feature.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.garif.all_tickets_feature.R
import com.garif.all_tickets_feature.databinding.FragmentAllTicketsBinding
import com.garif.all_tickets_feature.di.AllTicketsFeatureComponentProvider
import com.garif.all_tickets_feature.domain.entity.Ticket
import com.garif.all_tickets_feature.presentation.adapter.TicketListAdapter
import com.garif.core1.navigationData
import com.garif.core1.showMessage
import com.garif.core1.util.AppViewModelFactory
import com.garif.core1.util.VerticalSpacesItemDecoration
import javax.inject.Inject

class AllTicketsFragment : Fragment(R.layout.fragment_all_tickets) {
    @Inject
    lateinit var factory: AppViewModelFactory
    private lateinit var binding: FragmentAllTicketsBinding
    private val viewModel: AllTicketsViewModel by viewModels {
        factory
    }
    private var ticketListAdapter: TicketListAdapter? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as AllTicketsFeatureComponentProvider)
            .getAllTicketsFeatureComponent()
            .injectAllTicketsFragment(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAllTicketsBinding.bind(view)

        with(binding) {
            ivBack.setOnClickListener {
                findNavController().popBackStack()
            }

            val navigationData = navigationData as? Pair<*, *>
            tvRoute.text = (navigationData?.first as? String ?: return)
            tvRouteInfo.text = (navigationData.second as? String ?: return)
        }

        initObservers()
        viewModel.onGetTickets()
    }

    private fun initObservers() {
        viewModel.tickets.observe(viewLifecycleOwner) { it ->
            it.fold(onSuccess = {
                ticketListAdapter = TicketListAdapter()

                binding.tickets.run {
                    adapter = ticketListAdapter
                }

                ticketListAdapter?.submitList(it as MutableList<Ticket>)

                val spacesItemDecoration = VerticalSpacesItemDecoration()
                binding.tickets.addItemDecoration(spacesItemDecoration)
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