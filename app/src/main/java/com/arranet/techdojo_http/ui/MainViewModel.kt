package com.arranet.techdojo_http.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arranet.techdojo_http.data.model.Articles
import com.arranet.techdojo_http.data.network.Result
import com.arranet.techdojo_http.data.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val appRepository: AppRepository) : ViewModel() {
    private var _headlines = MutableLiveData<List<Articles>>()
    var headlines: LiveData<List<Articles>> = _headlines

    private var _errorMessage = MutableLiveData<String>()
    var errorMessage: LiveData<String> = _errorMessage

    fun getTopHeadlines(country: String) {
        viewModelScope.launch {
            try {
                when (val response = appRepository.getTopHeadlines(country)) {
                    is Result.Success -> {
                        _headlines.postValue(response.data.list)
                    }
                }
            } catch (e: Exception) {
                _errorMessage.postValue(e.message)
            }
        }
    }
}