package com.android.shared.domain.transformer

import com.android.shared.domain.usecase.transformer.STransformer
import io.reactivex.Single
import io.reactivex.SingleSource

class TestSTransformer<T> : STransformer<T>() {
    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream
    }
}