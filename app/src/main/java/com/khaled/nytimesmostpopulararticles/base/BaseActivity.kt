package com.khaled.nytimesmostpopulararticles.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B : ViewDataBinding?, VM : BaseViewModel?> : AppCompatActivity() {

    private var viewDataBinding: B? = null
    private var baseViewModel: VM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseViewModel = getBaseViewModel()
        viewDataBinding = getActivityBinding()
        setupObservers()
    }

    private fun setupObservers() {
        baseViewModel?.showMessage?.observe(this) {
            hideProgressBar()
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }

    protected open fun hideProgressBar() {

    }
    protected abstract fun getBaseViewModel(): VM
    protected abstract fun getActivityBinding(): B?

}