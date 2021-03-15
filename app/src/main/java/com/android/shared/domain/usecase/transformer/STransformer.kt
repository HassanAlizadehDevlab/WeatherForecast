package com.android.shared.domain.usecase.transformer

import io.reactivex.SingleTransformer

/**
 * A transformer to io thread for Single.
 */
abstract class STransformer<T> : SingleTransformer<T, T>