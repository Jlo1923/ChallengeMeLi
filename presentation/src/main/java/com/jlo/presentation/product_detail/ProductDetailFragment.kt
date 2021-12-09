package com.jlo.presentation.product_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.jlo.domain.common.AsyncResultStatus
import com.jlo.domain.common.Errors
import com.jlo.domain.models.ProductDetail
import com.jlo.presentation.R
import com.jlo.presentation.common.errors.ErrorMessage
import com.jlo.presentation.common.util.toCurrency
import com.jlo.presentation.databinding.FragmentProductDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {

    @Inject
    lateinit var errorMessage: ErrorMessage
    private val args: ProductDetailFragmentArgs by navArgs()
    private val viewModel: ProductDetailViewModel by viewModels()

    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!

    private val adapter = FeatureAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupRecycler()
        listenDetailData()
        loadDetail()
    }

    private fun setupToolbar() {
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar
            .setupWithNavController(navController, appBarConfiguration)
    }

    private fun setupImagePager(images: List<String>) {
        binding.content.imagePager.adapter = ImageAdapter(this, images)
    }

    private fun setupRecycler() {
        binding.content.recycler.adapter = adapter
    }

    private fun listenDetailData() {
        viewModel.productDetail.observe(viewLifecycleOwner) {
            when (it.status) {
                AsyncResultStatus.SUCCESS -> {
                    hideLoader()
                    setDetailInfo(it.data!!)
                }
                AsyncResultStatus.ERROR -> {
                    hideLoader()
                    showError(it.error)
                }
                AsyncResultStatus.LOADING -> showLoader()
            }
        }
    }

    private fun loadDetail() {
        hideError()
        viewModel.loadProductDetail(args.productId)
    }

    private fun setDetailInfo(detail: ProductDetail) {
        binding.content.run {
            root.visibility = View.VISIBLE
            productName.text = detail.title
            productCondition.text = detail.condition
            productDescription.text = detail.description ?: getString(R.string.not_description)
            productPrice.text = detail.price.toCurrency()
            productAvailable.text = getString(R.string.products_available, detail.availableQuantity)
        }

        adapter.data = detail.attributes
        setupImagePager(detail.images)
    }

    private fun showLoader() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideLoader() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showError(error: Errors?) {
        binding.content.root.visibility = View.GONE
        val message = errorMessage.getMessage(error)
        binding.error.root.visibility = View.VISIBLE
        binding.error.errorMessage.text = message
        binding.error.errorRetry.setOnClickListener {
            loadDetail()
        }
    }

    private fun hideError() {
        binding.error.root.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
