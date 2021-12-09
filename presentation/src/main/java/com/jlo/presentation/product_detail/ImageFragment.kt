package com.jlo.presentation.product_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jlo.presentation.common.util.loadUrl
import com.jlo.presentation.databinding.FragmentImageBinding

private const val ARG_IMAGE = "image"

class ImageFragment : Fragment() {

    private var image: String? = null

    private var _binding: FragmentImageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            image = it.getString(ARG_IMAGE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadImage()
    }

    private fun loadImage() {
        image?.let {
            binding.image.loadUrl(it)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(image: String) =
            ImageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_IMAGE, image)
                }
            }
    }
}
