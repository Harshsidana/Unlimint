package com.example.unlimint.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.JokesUseCase
import com.example.domain.usecase.base.BaseResponse
import com.example.unlimint.addToStart

class JokesViewModel constructor(private val jokesUseCase: JokesUseCase) : ViewModel() {

    var jokesList: MutableList<String> = mutableListOf()
    private val jokesData = MutableLiveData<List<String>>()

    fun getJokes() {
        jokesUseCase.invoke(
            viewModelScope,
            object : BaseResponse<String> {
                override fun onSuccess(joke: String) {
                    jokesList=jokesList.addToStart(joke)
                    jokesData.value = jokesList.take(10)
                }

                override fun onError(apiError: Exception?) {
                    getJokes()
                    Log.i("Exception:", "Error occurred" + apiError?.message.toString())
                }
            },
        )
    }

    fun getJokesLiveData(): LiveData<List<String>> {
        return jokesData
    }

}