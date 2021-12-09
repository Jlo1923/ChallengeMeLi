package com.jlo.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.jlo.domain.models.Product
import com.jlo.presentation.R
import com.jlo.presentation.common.adapters.ProductAdapter
import com.jlo.presentation.common.util.SwipeToDelete
import com.jlo.presentation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val recentWidth by lazy { resources.getDimensionPixelSize(R.dimen.recent_card_width) }
    private val adapter: ProductAdapter by lazy {
        ProductAdapter(recentWidth, this::goToDetail)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        listenRecentProducts()
        listenButtonSearch()
    }

    private fun setupRecycler() {
        binding.recyclerProducts.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerProducts.adapter = adapter

        val touchHelper =
            ItemTouchHelper(
                SwipeToDelete(ItemTouchHelper.DOWN or ItemTouchHelper.UP) {
                    deleteRecentProduct(it)
                }
            )
        touchHelper.attachToRecyclerView(binding.recyclerProducts)
    }

    private fun listenButtonSearch() {
        binding.buttonSearch.setOnClickListener {
            goToSearch()
        }
    }

    private fun listenRecentProducts() {
        viewModel.recentProducts.observe(viewLifecycleOwner) {
            val data = it.data ?: emptyList()
            adapter.submitList(

                data)
            if (data.isEmpty()) {
                hideRecentProduct()
            } else {
                showRecentProduct()
            }
        }
    }

    private fun showRecentProduct() {
        binding.root.transitionToEnd()
    }

    private fun hideRecentProduct() {
        binding.root.transitionToStart()
    }

    private fun deleteRecentProduct(index: Int) {
        val product = adapter.currentList[index]
        viewModel.deleteProduct(product)
    }

    private fun goToDetail(product: Product) {
        val action = HomeFragmentDirections.actionHomeToProductDetail(product.id)
        findNavController().navigate(action)
    }

    private fun goToSearch() {
        val action = HomeFragmentDirections.actionHomeToSearch()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
