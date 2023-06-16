package com.onedream.architecture_of_mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.onedream.architecture_of_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var dataRequester: MainDataRequester
    private lateinit var uiStateHolder: MainUIStateHolder
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
        initViewModel()
        binding()
        observe()
    }

    private fun initViewModel() {
        dataRequester = VMCreateFactory.newInstance(this, MainDataRequester())
        uiStateHolder = VMCreateFactory.newInstance(this, MainUIStateHolder())
    }

    private fun binding() {
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBinding.apply {
            setVariable(BR.ui_state, uiStateHolder)
            setVariable(BR.click, ClickProxy())
        }
    }


    private fun observe() {
        dataRequester.startDataResult.observe(this, Observer {
            uiStateHolder.count.get()?.plus(1)?.apply { uiStateHolder.count.set(this) }
        })
    }


    inner class ClickProxy {
        fun start() {
            dataRequester.requestClickStart()
        }
    }

}