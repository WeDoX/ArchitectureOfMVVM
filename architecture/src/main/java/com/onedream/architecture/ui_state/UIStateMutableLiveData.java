package com.onedream.architecture.ui_state;

public class UIStateMutableLiveData<T> extends UIStateLiveData<T> {
    @Override
    public void postValue(T value) {
        super.postValue(value);
    }

    @Override
    public void setValue(T value) {
        super.setValue(value);
    }
}
