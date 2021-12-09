package com.jlo.presentation.product_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jlo.domain.common.AsyncResult
import com.jlo.domain.models.ProductDetail
import com.jlo.domain.usescases.GetProductDetailByIdUseCase
import com.jlo.domain.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductDetailByIdUseCase: GetProductDetailByIdUseCase,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    private val productDetailControl: MutableLiveData<AsyncResult<ProductDetail>> =
        MutableLiveData()
    val productDetail: LiveData<AsyncResult<ProductDetail>> = productDetailControl

    fun loadProductDetail(productId: String) = viewModelScope.launch(dispatchers.main()) {
        productDetailControl.value = AsyncResult.loading()
        productDetailControl.value = getProductDetailByIdUseCase(productId)
    }
}
