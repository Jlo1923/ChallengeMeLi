package com.jlo.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.jlo.domain.common.AsyncResult
import com.jlo.domain.models.Product
import com.jlo.domain.usescases.DeleteProductFromRecentUseCase
import com.jlo.domain.usescases.GetRecentProductsUseCase
import com.jlo.domain.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getRecentProductsUseCase: GetRecentProductsUseCase,
    private val deleteProductFromRecentUseCase: DeleteProductFromRecentUseCase,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    val recentProducts: LiveData<AsyncResult<List<Product>>> = getRecentProductsUseCase()
        .asLiveData(timeoutInMs = 500)

    fun deleteProduct(product: Product) = viewModelScope.launch(dispatchers.main()) {
        deleteProductFromRecentUseCase(product)
    }
}
