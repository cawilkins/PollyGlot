package com.example.pollyglot;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CardCategoryViewModel extends ViewModel {
    private final MutableLiveData<Integer> selected = new MutableLiveData<Integer>();

    public void select(int item) {
        selected.setValue(item);
    }

    public LiveData<Integer> getSelected() {
        return selected;
    }
}
