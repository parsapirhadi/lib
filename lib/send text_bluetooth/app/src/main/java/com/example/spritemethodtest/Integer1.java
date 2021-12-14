package com.example.spritemethodtest;

import android.graphics.Color;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Integer1 extends BaseObservable {
    String count="kkkkkk";



    @Bindable
    public String getCount() {
        return count;
    }

    @Bindable
    public void setCount(String count) {
        this.count = count;
        notifyPropertyChanged(BR.count);

    }
}
