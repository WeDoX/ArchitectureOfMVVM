package com.onedream.architecture_of_mvvm;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

public class VMCreateFactory {

    public static <T extends ViewModel> T newInstance(ViewModelStoreOwner owner, T a) {
        Class<T> clazz = (Class<T>) a.getClass();
        return new ViewModelProvider(
                owner,
                new ViewModelProvider.Factory() {
                    @NonNull
                    @Override
                    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                        return (T) a;
                    }
                }
        ).get(clazz);
    }
}
