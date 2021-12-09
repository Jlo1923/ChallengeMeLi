package com.jlo.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jlo.domain.common.AsyncResult
import com.jlo.domain.usescases.GetSearchHistoryByQueryUseCase
import com.jlo.domain.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSearchHistoryByQueryUseCase: GetSearchHistoryByQueryUseCase,
    private val dispatcher: DispatcherProvider
) : ViewModel() {

    private val searchHistoryControl: MutableLiveData<AsyncResult<List<String>>> = MutableLiveData()
    val searchHistory: LiveData<AsyncResult<List<String>>> = searchHistoryControl

    fun loadSearchHistory(query: String) = viewModelScope.launch(dispatcher.main()) {
        searchHistoryControl.value = getSearchHistoryByQueryUseCase(query)
    }
}
