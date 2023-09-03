package com.example.jectpack.retrofit

import android.app.ProgressDialog
import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class RetrofitCallBack<T>(private var context: Context?, showProgress: Boolean) : Callback<T> {
    private var mProgressDialog: ProgressDialog? = null
    abstract fun response(call: Call<T>?, response: Response<T>?)
    abstract fun failure(call: Call<T>?, t: Throwable?)

    init {
        if (showProgress) {
//            mProgressDialog = Utilities.showProgressDialog(context)
        }
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
//        mProgressDialog?.let { Utilities.hideProgressDialog(it) }
        response(call, response)
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
//        mProgressDialog?.let { Utilities.hideProgressDialog(it) }
        failure(call, t)
    }
}