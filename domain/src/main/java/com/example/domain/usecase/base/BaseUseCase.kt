package com.example.domain.usecase.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
abstract class BaseUseCase<T, in P>() where T : Any {
    abstract suspend fun run(params: P? = null): T
    fun invoke(scope: CoroutineScope, params: P?, onResult: BaseResponse<T>?) {
        scope.launch {
            try {
                val result = run(params)
                onResult?.onSuccess(result)
            }catch (e: Exception) {
                e.printStackTrace()
                onResult?.onError(e)
            }
        }
    }
}