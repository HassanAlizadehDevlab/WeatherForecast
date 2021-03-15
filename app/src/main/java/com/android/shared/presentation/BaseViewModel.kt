package com.android.shared.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Base class for all ViewModels.
 */
open class BaseViewModel : ViewModel() {

    private val disposable = CompositeDisposable()
    protected val _messageObservable = MutableLiveData<String>()
    val messageObservable: LiveData<String>
        get() = _messageObservable


    protected fun Disposable.track() {
        disposable.add(this)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}