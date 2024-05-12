package com.garif.selected_country_feature.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garif.selected_country_feature.domain.entity.TicketOffer
import com.garif.selected_country_feature.domain.usecases.GetTicketsOfferUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SelectedCountryViewModel @Inject constructor(
    private val getTicketsOfferUseCase: GetTicketsOfferUseCase,
) : ViewModel() {
    private var _ticketsOffer: MutableLiveData<Result<List<TicketOffer>>> = MutableLiveData()
    val ticketsOffers: LiveData<Result<List<TicketOffer>>> = _ticketsOffer

    private var _error: MutableLiveData<Exception> = MutableLiveData()
    val error: LiveData<Exception> = _error

    fun onGetTicketsOffer() {
        viewModelScope.launch {
            try {
                val offers = getTicketsOfferUseCase() as MutableList<TicketOffer>
                _ticketsOffer.value = Result.success(offers)
            } catch (ex: Exception) {
                _ticketsOffer.value = Result.failure(ex)
                _error.value = ex
            }
        }
    }
}