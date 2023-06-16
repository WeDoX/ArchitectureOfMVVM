package com.onedream.architecture.data_requester;

public class DataResultMutableLiveData<T> extends DataResultLiveData<T> {

    /**
     * 勿在 Activity/Fragment 等页面处使用该 API，
     * do not use this method in View Controller like Activity,Fragment etc,
     *
     * @param value
     */
    public void setValue(T value) {
        super.setValue(value);
    }

    /**
     * 勿在 Activity/Fragment 等页面处使用该 API，
     * do not use this method in View Controller like Activity,Fragment etc
     *
     * @param value
     */
    public void postValue(T value) {
        super.postValue(value);
    }
}
