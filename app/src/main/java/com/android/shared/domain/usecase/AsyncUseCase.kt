package com.android.shared.domain.usecase

interface AsyncUseCase<PARAM, RESULT> {
    fun execute(param: PARAM): RESULT
}