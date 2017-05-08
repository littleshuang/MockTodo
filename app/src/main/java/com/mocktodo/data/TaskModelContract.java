package com.mocktodo.data;

import java.util.List;

/**
 * Created by Ziyun on 2017/5/8.
 *
 * 数据模型层对外接口
 */

public interface TaskModelContract {

    void saveTask(Task task);
    void delTask(int taskId);
    void clearTask(int filterType);
    void loadTask(int taskId, LoadTaskCallback callback);
    void loadTasks(int filterType, LoadTasksCallback callback);
    void completeTask(int taskId);
    void activateTask(int taskId);
    void refresh();

    interface LoadTaskCallback{
        void onTaskLoaded(Task task);
        void onTaskUnavailable();
    }

    interface LoadTasksCallback{
        void onLoadSuccess(List<Task> tasks);
        void onLoadError();
    }
}
