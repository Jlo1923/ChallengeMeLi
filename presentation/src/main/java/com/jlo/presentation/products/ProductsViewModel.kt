package com.jlo.presentation.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jlo.domain.common.AsyncResult
import com.jlo.domain.models.Product
import com.jlo.domain.usescases.GetProductsByQueryUseCase
import com.jlo.domain.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsByQueryUseCase: GetProductsByQueryUseCase,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    private val productsControl: MutableLiveData<AsyncResult<List<Product>>> = MutableLiveData()
    val products: LiveData<AsyncResult<List<Product>>> = productsControl

    fun queryProducts(query: String) = viewModelScope.launch(dispatchers.main()) {
        productsControl.value = AsyncResult.loading()
        productsControl.value = getProductsByQueryUseCase(query)
    }
}
