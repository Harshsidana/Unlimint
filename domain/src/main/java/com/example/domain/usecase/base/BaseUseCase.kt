package com.example.domain.usecase.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
abstract class BaseUseCase<T> where T : Any {
    abstract suspend fun run(): T
    fun invoke(scope: CoroutineScope, onResult: BaseResponse<T>?) {
        scope.launch {
            try {
                while (true) {
                    val result = run()
                    onResult?.onSuccess(result)
                    delay(1000*60)
                }
            }
            catch (e: Exception) {
                e.printStackTrace()
                onResult?.onError(e)
            }
        }
    }
}