package com.onedream.architecture_of_mvvm

import com.onedream.architecture.data_requester.DataRequester
import com.onedream.architecture.data_requester.DataResultLiveData
import com.onedream.architecture.data_requester.DataResultMutableLiveData

class MainDataRequester : DataRequester() {
    private val mStartDataResult = DataResultMutableLiveData<Any>()
    val startDataResult : DataResultLiveData<Any> = mStartDataResult

    fun requestClickStart(){
        mStartDataResult.postValue(mStartDataResult)
    }
}