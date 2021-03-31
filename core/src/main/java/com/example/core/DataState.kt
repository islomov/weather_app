package com.example.core

enum class DataState { LOADING, SUCCESS, ERROR }

data class ResponseData<T> constructor(val dataState: DataState, val data: T? = null, val message: String? = null)

fun <T> dataSuccess(data: T): ResponseData<T> = ResponseData(DataState.SUCCESS, data)
fun <T> dataLoading(data: T? = null): ResponseData<T> = ResponseData(DataState.LOADING, data)
fun <T> dataError(message: String?, data: T? = null): ResponseData<T> = ResponseData(DataState.ERROR, data, message)