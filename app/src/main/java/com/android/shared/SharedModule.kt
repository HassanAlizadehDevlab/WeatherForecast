package com.android.shared

import com.android.shared.data.DataModule
import com.android.shared.domain.error.ErrorHandler
import com.android.shared.domain.error.ErrorHandlerImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [DataModule::class])
abstract class SharedModule {

    @Binds
    @Reusable
    abstract fun provideErrorHandler(
        errorHandlerImpl: ErrorHandlerImpl
    ): ErrorHandler
}