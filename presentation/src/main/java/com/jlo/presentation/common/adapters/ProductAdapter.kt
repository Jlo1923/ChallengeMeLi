package com.jlo.presentation.common.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jlo.presentation.common.util.loadUrl
import com.jlo.presentation.common.util.toCurrency
import com.jlo.domain.models.Product
import com.jlo.presentation.R
import com.jlo.presentation.databinding.ItemProductBinding

class ProductAdapter(
    private val widthCard: Int = CoordinatorLayout.LayoutParams.MATCH_PARENT,
    private val onItemClick: (Product) -> Unit
) : ListAdapter<Product, ProductAdapter.RecentProductViewHolder>(ProductDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return RecentProductViewHolder(view, widthCard, onItemClick)
    }

    override fun onBindViewHolder(holder: RecentProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RecentProductViewHolder(
        view: View,
        private val widthCard: Int,
        private val onClickProduct: (Product) -> Unit

    ) : RecyclerView.ViewHolder(view) {
        private val binding = ItemProductBinding.bind(view)
        private var currentProduct: Product? = null

        init {
            view.setOnClickListener {
                currentProduct?.let(onClickProduct)
            }
        }

        fun bind(product: Product) {
            currentProduct = product
            binding.root.layoutParams = binding.root.layoutParams.apply {
                width = widthCard
            }
            binding.productImage.loadUrl(product.image)
            binding.productName.text = product.title
            binding.productPrice.text = product.price.toCurrency()
        }
    }
}

object ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}
