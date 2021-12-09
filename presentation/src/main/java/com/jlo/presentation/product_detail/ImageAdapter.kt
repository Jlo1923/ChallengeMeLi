package com.jlo.presentation.product_detail

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ImageAdapter(parent: Fragment, private val images: List<String>) :
    FragmentStateAdapter(parent) {
    override fun getItemCount(): Int = images.size

    override fun createFragment(position: Int): Fragment =
        ImageFragment.newInstance(images[position])
}
