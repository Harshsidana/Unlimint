package com.example.domain.usecase.base

interface BaseResponse<Type> {

    fun onSuccess(result: Type)

    fun onError(apiError: Exception?)
}