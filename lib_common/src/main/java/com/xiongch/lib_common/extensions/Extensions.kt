package com.xiongch.lib_common.extensions

import android.app.Activity
import android.arch.lifecycle.*
import android.content.Context
import android.content.res.Resources
import android.os.Looper
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import com.xiongch.lib_common.base.BaseApplication
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

val Context.app: BaseApplication get() = BaseApplication.INSTANCE as BaseApplication

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun Activity.toastMD(msg: String) {
    Snackbar.make(findViewById<FrameLayout>(android.R.id.content),
            msg, Snackbar.LENGTH_SHORT).show()
}

fun toastMD(view: View, msg: String) {
    Snackbar.make(view,
            msg, Snackbar.LENGTH_SHORT).show()
}

fun Context.toast(msg: String?) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    add(disposable)
}

fun Disposable.addTo(androidDisposable: CompositeDisposable): Disposable
        = apply { androidDisposable.add(this) }

fun <T> MutableLiveData<T>.update(t: T?) {
    if (Looper.myLooper() != Looper.getMainLooper()) {
        this.postValue(t)
    } else {
        this.value = t
    }
}

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(this, Observer(body))
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(viewModelFactory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
}

inline fun <reified T : ViewModel> FragmentActivity.withViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        body: T.() -> Unit
): T {
    val vm = getViewModel<T>(viewModelFactory)
    vm.body()
    return vm
}

inline fun <reified T : ViewModel> Fragment.getViewModel(viewModelFactory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
}

inline fun <reified T : ViewModel> Fragment.withViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        body: T.() -> Unit
): T {
    val vm = getViewModel<T>(viewModelFactory)
    vm.body()
    return vm
}