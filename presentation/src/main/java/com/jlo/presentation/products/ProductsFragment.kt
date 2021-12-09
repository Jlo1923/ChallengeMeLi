package com.jlo.presentation.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.jlo.domain.common.AsyncResultStatus
import com.jlo.domain.common.Errors
import com.jlo.domain.models.Product
import com.jlo.presentation.R
import com.jlo.presentation.common.adapters.ProductAdapter
import com.jlo.presentation.common.errors.ErrorMessage
import com.jlo.presentation.databinding.FragmentProductsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProductsFragment : Fragment(), Toolbar.OnMenuItemClickListener {

    @Inject
    lateinit var errorMessage: ErrorMessage
    private val args: ProductsFragmentArgs by navArgs()
    private val viewModel: ProductsViewModel by viewModels()
    private val adapter: ProductAdapter = ProductAdapter(onItemClick = this::goToDetail)

    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupRecycler()
        listenData()
        loadProducts()
    }

    private fun setupToolbar() {
        binding.toolbar.inflateMenu(R.menu.menu_search)
        binding.toolbar.setOnMenuItemClickListener(this)

        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar
            .setupWithNavController(navController, appBarConfiguration)

        binding.toolbar.title = args.query
    }

    private fun setupRecycler() {
        binding.recycler.adapter = adapter
    }

    private fun listenData() {
        viewModel.products.observe(viewLifecycleOwner) {
            when (it.status) {
                AsyncResultStatus.SUCCESS -> {
                    hideLoader()
                    adapter.submitList(it.data ?: emptyList())
                }
                AsyncResultStatus.ERROR -> {
                    hideLoader()
                    showError(it.error)
                }
                AsyncResultStatus.LOADING -> showLoader()
            }
        }
    }

    private fun loadProducts() {
        hideError()
        viewModel.queryProducts(args.query)
    }

    private fun showLoader() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideLoader() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showError(error: Errors?) {
        val message = errorMessage.getMessage(error)
        binding.error.root.visibility = View.VISIBLE
        binding.error.errorMessage.text = message
        binding.error.errorRetry.setOnClickListener {
            loadProducts()
        }
    }

    private fun hideError() {
        binding.error.root.visibility = View.GONE
    }

    private fun goToDetail(product: Product) {
        val action = ProductsFragmentDirections.actionProductsToProductDetail(product.id)
        findNavController().navigate(action)
    }

    private fun goToSearch() {
        val action = ProductsFragmentDirections.actionProductsToSearch()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        goToSearch()
        return false
    }
}
