package com.jlo.presentation.product_detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jlo.domain.models.ProductAttribute
import com.jlo.presentation.R
import com.jlo.presentation.databinding.ItemFeatureBinding
import java.util.*

class FeatureAdapter : RecyclerView.Adapter<FeatureAdapter.FeatureViewHolder>() {

    var data: List<ProductAttribute> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_feature, parent, false)
        return FeatureViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeatureViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class FeatureViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding: ItemFeatureBinding = ItemFeatureBinding.bind(view)

        fun bind(feature: ProductAttribute) {
            binding.featureLabel.text = feature.name
            binding.featureValue.text = feature.value
        }
    }
}
