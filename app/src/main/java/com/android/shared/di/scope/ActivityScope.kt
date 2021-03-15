package com.android.shared.di.scope

import javax.inject.Scope

/**
 * The @ActivityScope is a custom scoping to permit objects whose lifetime should conform to the
 * life of the activity to be memorized in the correct component.
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope