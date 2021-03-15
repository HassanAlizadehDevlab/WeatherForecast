package com.android.shared.domain.string

import android.content.Context
import com.android.weatherforecastapp.R
import javax.inject.Inject


class ErrorHandlerImpl @Inject constructor(
    private val context: Context
) : ErrorHandler {
    private fun internalServerError(): String = context.getString(R.string.internal_server_error)
    private fun unknownError(): String = context.getString(R.string.unknown_error)

    override fun getMessage(throwable: Throwable?): String {
        // check it is http error or not
        // check it is one the server errors

        return unknownError()
    }

}