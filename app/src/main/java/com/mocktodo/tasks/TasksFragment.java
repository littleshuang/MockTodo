package com.mocktodo.tasks;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mocktodo.R;
import com.mocktodo.data.Task;
import com.mocktodo.taskdetail.TaskAdapter;

import java.util.ArrayList;
import java.util.List;

public class TasksFragment extends Fragment implements TasksContract.View {
    private static final String TAG_LOG = "TasksFragment";
    private Activity mActivity;
    private TasksContract.Presenter mPresenter;
    private TaskAdapter mAdapter;
    private TaskAdapter.TaskItemListener mListener;

    // Layout elements
    TextView mFilterLableView;
    RecyclerView mRecyclerView;
    LinearLayout mContentLayout;
    LinearLayout mErrorLayout;
    TextView mErrorView;

    public TasksFragment() {
    }

    public static TasksFragment newInstance() {
        return new TasksFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new TaskAdapter(this.getContext(), new ArrayList<Task>(0), mListener);
    }

    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container,
                                          Bundle savedInstanceState) {
        android.view.View root = inflater.inflate(R.layout.fragment_tasks, container, false);

        // get layout items
        mFilterLableView = (TextView) root.findViewById(R.id.tv_filter_label);
        mRecyclerView = (RecyclerView)root.findViewById(R.id.rv_tasks);
        mRecyclerView.setAdapter(mAdapter);

        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showStatistics() {

    }

    @Override
    public void showCompletedTaskCleared() {

    }

    @Override
    public void showFilterPopupWindow() {

    }

    @Override
    public void showFilterLabel(int filterType) {

    }

    @Override
    public void showTaskCompleted() {

    }

    @Override
    public void showTaskActiviate() {

    }

    @Override
    public void showEmptyTasks(int filterType) {

    }

    @Override
    public void showTaskDetail(int taskId) {

    }

    @Override
    public void showFilterTasks(List<Task> tasks, int FilterType) {

    }

    @Override
    public void showAddEditTask() {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void setPresenter(TasksContract.Presenter presenter) {

    }

    @Override
    public void showLoadingIndecator(boolean show) {

    }

    @Override
    public void showLoadingError() {

    }
}
