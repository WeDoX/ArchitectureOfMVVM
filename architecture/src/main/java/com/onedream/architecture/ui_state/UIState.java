package com.onedream.architecture.ui_state;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

public class UIState<T> extends ObservableField<T> {

    private final boolean mIsDebouncing;

    /**
     * 务必根据泛型提供初值，以彻底规避 Null 安全问题
     * Be sure to provide initial values based on generics to completely avoid null security issues
     *
     * @param value initial value
     */
    public UIState(@NonNull T value) {
        this(value, false);
    }

    public UIState(@NonNull T value, boolean isDebouncing) {
        super(value);
        mIsDebouncing = isDebouncing;
    }

    @Override
    public void set(@NonNull T value) {
        boolean isUnChanged = get() == value;
        super.set(value);
        if (!mIsDebouncing && isUnChanged) {
            notifyChange();
        }
    }
}
