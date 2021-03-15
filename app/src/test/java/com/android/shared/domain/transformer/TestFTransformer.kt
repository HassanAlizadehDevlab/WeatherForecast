package com.android.shared.domain.transformer

import com.android.shared.domain.usecase.transformer.FTransformer
import io.reactivex.Flowable
import org.reactivestreams.Publisher

class TestFTransformer<T> : FTransformer<T>() {
    override fun apply(upstream: Flowable<T>): Publisher<T> {
        return upstream
    }
}