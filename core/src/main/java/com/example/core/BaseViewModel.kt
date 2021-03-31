package com.example.core

import androidx.lifecycle.ViewModel
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

open class BaseViewModel  : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun Disposable.addToDisposable() {
        compositeDisposable.add(this)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    fun <T> Single<T>.baseSubscribe(
        observeOn: Scheduler? = AndroidSchedulers.mainThread(),
        subscribeOn: Scheduler = Schedulers.io(),
        onError: ((Throwable) -> Unit)? = null,
        onSuccess: (T) -> Unit
    ) {
        this.subscribeOn(subscribeOn)
            .run {
                if (observeOn != null) {
                    observeOn(observeOn)
                } else {
                    this
                }
            }
            .subscribe(
                { onSuccess.invoke(it) },
                { onError?.invoke(it) }
            ).addToDisposable()
    }


}