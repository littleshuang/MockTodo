package com.mocktodo.tasks;

import com.mocktodo.BasePresenter;
import com.mocktodo.BaseView;
import com.mocktodo.data.Task;

import java.util.List;

/**
 * Created by Ziyun on 2017/5/8.
 */

public interface TasksContract {

    interface View extends BaseView<Presenter>{
        void showStatistics();
        void showCompletedTaskCleared();
        void showFilterPopupWindow();
        void showFilterLabel(int filterType);
        void showTaskCompleted();
        void showTaskActiviate();
        void showEmptyTasks(int filterType);
        void showTaskDetail(int taskId);
        void showFilterTasks(List<Task> tasks,  int FilterType);   // 显示与过滤器对应的任务列表
        void showAddEditTask();
        boolean isActive();     // 当前 Fragment 是否在 Activity 中
    }

    interface Presenter extends BasePresenter{
        void loadTasks(int FilterType);     // 根据过滤类型加载任务
        void clearCompletedTasks();
        void activiateTask(Task task);
        void completeTask(Task task);
        void openTaskDetail(Task task);
        void addNewTask();
        void setFilter(int Filter);
        int getFilter();
    }
}
