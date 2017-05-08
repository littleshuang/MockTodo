package com.mocktodo.tasks;

import com.mocktodo.data.Task;

/**
 * Created by Ziyun on 2017/5/8.
 */

public class TasksPresenter implements TasksContract.Presenter {

    TasksContract.View mView;

    public TasksPresenter() {
    }

    public TasksPresenter(TasksContract.View view) {
        mView = view;
    }

    public TasksContract.View getView() {
        return mView;
    }

    @Override
    public void loadTasks(int FilterType) {

    }

    @Override
    public void clearCompletedTasks() {

    }

    @Override
    public void activiateTask(Task task) {

    }

    @Override
    public void completeTask(Task task) {

    }

    @Override
    public void openTaskDetail(Task task) {

    }

    @Override
    public void addNewTask() {

    }

    @Override
    public void setFilter(int Filter) {

    }

    @Override
    public int getFilter() {
        return 0;
    }

    @Override
    public void start() {

    }
}
