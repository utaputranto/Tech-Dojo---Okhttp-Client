package com.arranet.techdojo_http.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.INFO
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import com.arranet.techdojo_http.R
import com.arranet.techdojo_http.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.logging.Level.INFO

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
        initObservers()
    }

    private fun initObservers() {
        viewModel.headlines.observe(this, {
            with(binding.listView) {
                adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, it.map { it.title })
                onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                    Toast.makeText(this@MainActivity, it[position].title, Toast.LENGTH_SHORT).show()
                }
            }
        })
        viewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun initViews() {
        viewModel.getTopHeadlines("us")
    }
}