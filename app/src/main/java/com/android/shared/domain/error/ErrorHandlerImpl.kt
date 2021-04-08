package com.android.shared.domain.error

import android.content.Context
import com.android.app.R
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

/**
 * ErrorHandler class has access to string resources to get error messages.
 * */
class ErrorHandlerImpl @Inject constructor(
    private val context: Context
) : ErrorHandler {
    private fun internalServerError(): String = context.getString(R.string.internal_server_error)
    private fun noInternetError(): String = context.getString(R.string.no_internet)
    private fun sessionTimeOutError(): String = context.getString(R.string.retry_again_please)
    private fun serverNotRespondingError(): String = context.getString(R.string.retry_again_please)
    private fun unknownError(): String = context.getString(R.string.unknown_error)

    override fun getMessage(throwable: Throwable?): String {
        // check it is http error or not
        // check it is one the server errors

        if (throwable is SocketTimeoutException) return sessionTimeOutError()
        if (throwable is UnknownHostException) return noInternetError()
        if (throwable is ConnectException) return serverNotRespondingError()
        if (throwable is IOException) return internalServerError()
        // And other type of errors

        return unknownError()
    }

}