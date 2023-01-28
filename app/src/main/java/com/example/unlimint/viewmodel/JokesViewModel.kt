package com.example.unlimint.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.JokesUseCase
import com.example.domain.usecase.base.BaseResponse

class JokesViewModel constructor(private val jokesUseCase: JokesUseCase) : ViewModel() {
    fun getJokes() {
        jokesUseCase.invoke(
            viewModelScope,
            object : BaseResponse<String> {
                override fun onSuccess(result: String) {
                    Log.i("harsh",result)

                }

                override fun onError(apiError: Exception?) {

                }
            },
        )
    }


}