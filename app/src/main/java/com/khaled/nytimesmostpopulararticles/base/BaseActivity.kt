package com.khaled.nytimesmostpopulararticles.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B : ViewDataBinding?, VM : BaseViewModel?> : AppCompatActivity() {

    private var viewDataBinding: B? = null
    private var baseViewModel: VM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseViewModel = getBaseViewModel()
        viewDataBinding = getActivityBinding()
    }

    protected abstract fun getBaseViewModel(): VM
    protected abstract fun getActivityBinding(): B?

}