package com.mocktodo.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ziyun on 2017/5/8.
 */

public class Task implements Parcelable{
    private static int sId = 0;
    int mTaskId;
    String mTaskTitle;
    String mTaskDescription;
    boolean mIsActive;       // 任务是否处于活跃状态，true：是，false：任务已完成

    public Task() {
    }

    public Task(int taskId) {
        this(taskId, null, null, true);
    }

    public Task(String taskTitle, String taskDescription) {
        this(taskTitle, taskDescription, true);
    }

    public Task(String taskTitle, String taskDescription, boolean isActive) {
        this.mTaskId = generateId();
        this.mTaskTitle = taskTitle;
        this.mTaskDescription = taskDescription;
        this.mIsActive = isActive;
    }

    public Task(int taskId, String taskTitle, String taskDescription, boolean isActive) {
        this.mTaskId = taskId;
        this.mTaskTitle = taskTitle;
        this.mTaskDescription = taskDescription;
        this.mIsActive = isActive;
    }

    // Generate a global unique task id
    private int generateId(){
        sId += 1;
        return sId;
    }

    public static int getsId() {
        return sId;
    }

    public static void setsId(int sId) {
        Task.sId = sId;
    }

    public int getTaskId() {
        return mTaskId;
    }

    public void setTaskId(int taskId) {
        this.mTaskId = taskId;
    }

    public String getTaskTitle() {
        return mTaskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.mTaskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return mTaskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.mTaskDescription = taskDescription;
    }

    public boolean isActive() {
        return mIsActive;
    }

    public void setActive(boolean active) {
        mIsActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (mTaskId != task.mTaskId) return false;
        if (mIsActive != task.mIsActive) return false;
        if (mTaskTitle != null ? !mTaskTitle.equals(task.mTaskTitle) : task.mTaskTitle != null)
            return false;
        return mTaskDescription != null ? mTaskDescription.equals(task.mTaskDescription) : task.mTaskDescription == null;

    }

    @Override
    public int hashCode() {
        int result = mTaskId;
        result = 31 * result + (mTaskTitle != null ? mTaskTitle.hashCode() : 0);
        result = 31 * result + (mTaskDescription != null ? mTaskDescription.hashCode() : 0);
        result = 31 * result + (mIsActive ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task title is: " + mTaskTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mTaskId);
        dest.writeString(mTaskTitle);
        dest.writeString(mTaskDescription);
        dest.writeByte((byte)(mIsActive ? 1 : 0));
    }

    public static final Parcelable.Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel source) {
            Task task = new Task();
            task.setTaskId(source.readInt());
            task.setTaskTitle(source.readString());
            task.setTaskDescription(source.readString());
            task.setActive(source.readByte() == 1);
            return null;
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };
}
