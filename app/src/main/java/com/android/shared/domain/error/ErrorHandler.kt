package com.android.shared.domain.error

/**
 * An interface to get proper message from string resources in usecases
 * */
interface ErrorHandler {
    fun getMessage(throwable: Throwable?): String
}