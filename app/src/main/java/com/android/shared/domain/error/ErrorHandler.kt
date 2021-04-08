package com.android.shared.domain.string

/**
 * An interface to get proper message from string resources in usecases
 * */
interface ErrorHandler {
    fun getMessage(throwable: Throwable?): String
}