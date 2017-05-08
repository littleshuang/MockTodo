package com.mocktodo.tasks;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.mocktodo.BaseActivity;
import com.mocktodo.R;

public class TasksActivity extends BaseActivity {
    Toolbar mToolbar;
    FrameLayout mContentView;
    FloatingActionButton mFab;
    TasksFragment mFragment;
    TasksContract.Presenter mTasksPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        initViews();
        mFragment = (TasksFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (mFragment == null){
            mFragment = TasksFragment.newInstance();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.contentFrame, mFragment);
            ft.commit();
        }

        mTasksPresenter = new TasksPresenter(mFragment);
    }

    private void initViews() {
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mContentView = (FrameLayout)findViewById(R.id.contentFrame);
        mFab = (FloatingActionButton)findViewById(R.id.fab_add_task);
    }
}
