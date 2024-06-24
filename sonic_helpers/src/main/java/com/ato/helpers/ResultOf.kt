package com.ato.helpers

import com.ato.helpers.ResultOf.Error
import com.ato.helpers.ResultOf.Loading
import com.ato.helpers.ResultOf.Success


sealed class ResultOf<out T> {
    abstract val previous: T?

    data class Success<out T>(
        val data: T,
        override val previous: T? = null
    ) : ResultOf<T>()

    data class Loading<out T>(
        override val previous: T? = null
    ) : ResultOf<T>()

    data class Error<out T>(
        val exception: Throwable,
        override val previous: T? = null
    ) : ResultOf<T>()
}

inline fun <T> ResultOf<T>.ifSuccess(action: (T) -> Unit) {
    if (this is ResultOf.Success<T>) {
        action(data)
    }
}

val ResultOf<*>.isSuccess: Boolean
    get() = this is ResultOf.Success<*>

val ResultOf<*>.isLoading: Boolean
    get() = this is ResultOf.Loading<*>

val ResultOf<*>.isError: Boolean
    get() = this is ResultOf.Error<*>

fun <T> ResultOf<T>.getOrNull(): T? {
    return (this as? Success)?.data
}

fun <T> ResultOf<T>.exceptionOrNull(): Throwable? {
    return (this as? Error)?.exception
}

fun <T> ResultOf<T>.previousOrNull(): T? {
    return when (this) {
        is Success -> this.previous
        is Loading -> this.previous
        is Error -> this.previous
    }
}

inline fun <T> ResultOf<T>.onSuccess(action: (T) -> Unit): ResultOf<T> {
    if (this is Success) action(data)
    return this
}

inline fun <T> ResultOf<T>.onLoading(action: () -> Unit): ResultOf<T> {
    if (this is Loading) action()
    return this
}

inline fun <T> ResultOf<T>.onError(action: (Throwable) -> Unit): ResultOf<T> {
    if (this is Error) action(exception)
    return this
}

fun <T> T.toSuccess(previous: ResultOf<T>? = null): ResultOf.Success<T> {
    return ResultOf.Success(this, previous?.getOrNull())
}

fun <T> Throwable.toError(previous: ResultOf<T>? = null): ResultOf.Error<T> {
    return ResultOf.Error(this, previous?.getOrNull())
}

fun <T> T.toLoading(previous: ResultOf<T>? = null): ResultOf.Loading<T> {
    return ResultOf.Loading(previous?.getOrNull())
}

fun <T, R> ResultOf<T>.map(transform: (T) -> R): ResultOf<R> {
    return when (this) {
        is ResultOf.Success -> ResultOf.Success(
            transform(this.data),
        )

        is ResultOf.Loading -> ResultOf.Loading()
        is ResultOf.Error -> ResultOf.Error(this.exception)
    }
}

inline fun <T> ResultOf<T>.display(
    onLoading: (previous: T?) -> Unit = {},
    onSuccess: (data: T, previous: T?) -> Unit = { _, _ -> },
    onSuccessEmpty: (previous: T?) -> Unit = { _ -> },
    onError: (exception: Throwable, previous: T?) -> Unit = { _, _ -> }
): ResultOf<T> {
    when (this) {
        is ResultOf.Loading -> onLoading(this.previous)
        is ResultOf.Success -> {
            if (data == null) {
                onSuccessEmpty(this.previous)
            } else {
                onSuccess(this.data, this.previous)
            }
        }

        is ResultOf.Error -> onError(this.exception, this.previous)
    }
    return this
}