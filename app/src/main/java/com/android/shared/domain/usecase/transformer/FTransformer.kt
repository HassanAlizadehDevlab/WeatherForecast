package com.android.shared.domain.usecase.transformer

import io.reactivex.FlowableTransformer

/**
 * A transformer to io thread for Single.
 */
abstract class FTransformer<T> : FlowableTransformer<T, T>