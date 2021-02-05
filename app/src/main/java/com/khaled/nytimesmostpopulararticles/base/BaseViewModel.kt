package com.khaled.nytimesmostpopulararticles.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.khaled.nytimesmostpopulararticles.utils.SingleLiveEvent

abstract class BaseViewModel(application: Application): AndroidViewModel(application) {
    val showMessage: SingleLiveEvent<String> = SingleLiveEvent()
}