package com.mocktodo.taskdetail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mocktodo.R;
import com.mocktodo.data.Task;

import java.util.List;

/**
 * Created by Ziyun on 2017/5/8.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {

    private Context mContext;
    private List<Task> mTasks;
    private TaskItemListener mListener;

    public TaskAdapter(List<Task> tasks, TaskItemListener listener) {
        this(null, tasks, listener);
    }

    public TaskAdapter(Context context, List<Task> tasks, TaskItemListener listener) {
        mContext = context;
        mTasks = tasks;
        mListener = listener;
    }

    @Override
    public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View rootView = layoutInflater.inflate(R.layout.item_tasks, parent, false);
        TaskHolder holder = new TaskHolder(rootView);
        return holder;
    }

    @Override
    public void onBindViewHolder(TaskHolder holder, int position) {
        final Task task = mTasks.get(position);
        CheckBox checkBox = holder.mCheckBox;
        TextView textView = holder.mTitleView;
        ImageButton imageButton = holder.mRightBtn;

        checkBox.setChecked(!task.isActive());
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (task.isActive()){
                    mListener.onCompleteTaskClicked();
                }else {
                    mListener.onActivateTaskClicked();
                }
            }
        });

        textView.setText(task.getTaskTitle());
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onRightBtnClicked();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    public static class TaskHolder extends RecyclerView.ViewHolder{
        CheckBox mCheckBox;
        TextView mTitleView;
        ImageButton mRightBtn;

        public TaskHolder(View itemView) {
            super(itemView);

            mCheckBox = (CheckBox)itemView.findViewById(R.id.cb_task);
            mTitleView = (TextView)itemView.findViewById(R.id.tv_task_title);
            mRightBtn = (ImageButton)itemView.findViewById(R.id.ib_enter_detail);
        }
    }

    public interface TaskItemListener{
        void onCompleteTaskClicked();
        void onActivateTaskClicked();
        void onRightBtnClicked();
    }
}
