package com.android.shared.data

import com.android.shared.data.entity.EntityModule
import dagger.Module

@Module(
    includes = [
        EntityModule::class,
    ]
)
class DataModule