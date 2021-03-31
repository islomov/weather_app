package com.example.weatherapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import com.example.core.DataState
import com.example.weatherapp.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory = viewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoad.setOnClickListener {
            viewModel.getWeather(41.29, 69.24)
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.weatherData.observe(this, {
            when (it.dataState) {
                DataState.SUCCESS -> {
                    binding.weather.text = it.data?.main?.pressure?.toString() ?: "null"
                }
                DataState.LOADING -> {
                    binding.weather.text = "Loading..."
                }
                else -> {
                    binding.weather.text = it.message
                }
            }
        })
    }

}