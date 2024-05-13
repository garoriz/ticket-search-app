package com.garif.all_tickets_feature.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garif.all_tickets_feature.domain.entity.Ticket
import com.garif.all_tickets_feature.domain.usecases.GetTicketsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class AllTicketsViewModel @Inject constructor(
    private val getTicketsUseCase: GetTicketsUseCase,
) : ViewModel() {
    private var _tickets: MutableLiveData<Result<List<Ticket>>> = MutableLiveData()
    val tickets: LiveData<Result<List<Ticket>>> = _tickets

    private var _error: MutableLiveData<Exception> = MutableLiveData()
    val error: LiveData<Exception> = _error

    fun onGetTickets() {
        viewModelScope.launch {
            try {
                val tickets = getTicketsUseCase() as MutableList<Ticket>
                _tickets.value = Result.success(tickets)
            } catch (ex: Exception) {
                _tickets.value = Result.failure(ex)
                _error.value = ex
            }
        }
    }
}