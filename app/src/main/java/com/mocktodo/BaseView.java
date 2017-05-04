package com.mocktodo;


import android.support.v4.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public interface BaseView<T> {

    void setPresenter(T presenter);
    void showLoadingIndecator(boolean show);
    void showLoadingError();
}
