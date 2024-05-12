package com.garif.main_feature.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garif.main_feature.domain.entity.Offer
import com.garif.main_feature.domain.usecases.GetOffersUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getOffersUseCase: GetOffersUseCase,
) : ViewModel() {
    private var _offers: MutableLiveData<Result<List<Offer>>> = MutableLiveData()
    val offers: LiveData<Result<List<Offer>>> = _offers

    private var _error: MutableLiveData<Exception> = MutableLiveData()
    val error: LiveData<Exception> = _error

    fun onGetOffers() {
        viewModelScope.launch {
            try {
                val offers = getOffersUseCase() as MutableList<Offer>
                _offers.value = Result.success(offers)
            } catch (ex: Exception) {
                _offers.value = Result.failure(ex)
                _error.value = ex
            }
        }
    }
}