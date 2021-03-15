package com.android.shared.domain.usecase.transformer

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Single transformer to do and observe the job on specific threads
 */
class AsyncSTransformer<T> (
    private val threadExecutor: Scheduler = Schedulers.io(),
    private val postExecutionThread: Scheduler = AndroidSchedulers.mainThread()
) : STransformer<T>() {

    override fun apply(upstream: Single<T>): SingleSource<T> =
        upstream.subscribeOn(threadExecutor)
            .observeOn(postExecutionThread)

}