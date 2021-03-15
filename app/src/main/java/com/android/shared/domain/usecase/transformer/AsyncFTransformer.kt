package com.android.shared.domain.usecase.transformer

import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Publisher

/**
 * Flowable transformer to do and observe the job on specific threads
 */
class AsyncFTransformer<T>(
    private val threadExecutor: Scheduler = Schedulers.io(),
    private val postExecutionThread: Scheduler = AndroidSchedulers.mainThread()
) : FTransformer<T>() {

    override fun apply(upstream: Flowable<T>): Publisher<T> =
        upstream.subscribeOn(threadExecutor)
            .observeOn(postExecutionThread)

}