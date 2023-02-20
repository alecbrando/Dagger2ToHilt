package com.example.database.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.database.databinding.ActivityWorkBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkActivity: AppCompatActivity() {
    private val binding: ActivityWorkBinding by lazy {
        ActivityWorkBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<WorkViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() = with(binding){
        tvText.text = viewModel.giveMeTheText.value
    }
}