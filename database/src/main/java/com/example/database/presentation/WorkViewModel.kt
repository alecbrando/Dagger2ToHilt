package com.example.database.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.network.di.GiveMeIt
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorkViewModel @Inject constructor(
    private val giveMeIt: GiveMeIt
): ViewModel() {
    private val _giveMeTheText = MutableLiveData<String>()
    val giveMeTheText: LiveData<String> = _giveMeTheText

    init {
        _giveMeTheText.value = giveMeIt.theTextToProvide
    }
}