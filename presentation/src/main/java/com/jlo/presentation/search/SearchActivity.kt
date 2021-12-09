package com.jlo.presentation.search

import android.app.SearchManager
import android.content.ComponentName
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import com.jlo.presentation.MainActivity
import com.jlo.presentation.databinding.ActivitySearchBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Collections.emptyList

@AndroidEntryPoint
class SearchActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private val viewModel: SearchViewModel by viewModels()
    private val adapter = SearchAdapter(this::submitSearch)
    lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        setupSearchView()
        setupRecycler()
        listenFocusChange()
        listenInputChange()
        listenDataChange()
        loadHistory()
    }

    private fun setupSearchView() {
        val searchManager =
            ContextCompat.getSystemService(this, SearchManager::class.java)
        binding.searchBar.setSearchableInfo(
            searchManager?.getSearchableInfo(
                ComponentName(this, MainActivity::class.java)
            )
        )
        binding.searchBar.setIconifiedByDefault(false)
        binding.searchBar.requestFocus()
    }

    private fun setupRecycler() {
        binding.recycler.adapter = adapter
    }

    private fun listenFocusChange() {
        binding.searchBar.setOnQueryTextFocusChangeListener { _, focused ->
            if (!focused) {
                finish()
            }
        }
    }

    private fun listenInputChange() {
        binding.searchBar.setOnQueryTextListener(this)
    }

    private fun listenDataChange() {
        viewModel.searchHistory.observe(this) {
            adapter.data = it.data ?: emptyList()
        }
    }

    private fun loadHistory(query: String = "") {
        viewModel.loadSearchHistory(query)
    }

    private fun submitSearch(query: String) {
        binding.searchBar.setQuery(query, true)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        finish()
        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {
        loadHistory(newText)
        return false
    }
}
