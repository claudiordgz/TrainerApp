package com.mobileappscompany.android.trainerapplibrary.model;

import java.util.Date;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Claudiordgz on 1/28/2015.
 */
public class AssignedTask implements Parcelable {
    private Trainer mAssigner;
    private Trainee mResponsible;
    private Task mTask;
    private TaskGrade mGrade;
    private TaskAnswer mAnswer;
    private Date mAssignedDate;

    public AssignedTask(){
        mAssigner = null;
        mResponsible = null;
        mTask = null;
        mGrade = null;
        mAnswer = null;
        mAssignedDate = null;
    }

    public AssignedTask(Trainer assigner, Trainee responsible,
                        Task task, TaskGrade grade, TaskAnswer answer,
                        Date assignedDate) {
        mAssigner = assigner;
        mResponsible = responsible;
        mTask = task;
        mGrade = grade;
        mAnswer = answer;
        mAssignedDate = assignedDate;
    }

    public Trainer getAssigner() {
        return mAssigner;
    }

    public void setAssigner(Trainer mAssigner) {
        this.mAssigner = mAssigner;
    }

    public Trainee getResponsible() {
        return mResponsible;
    }

    public void setResponsible(Trainee mResponsible) {
        this.mResponsible = mResponsible;
    }

    public Task getTask() {
        return mTask;
    }

    public void setTask(Task mTask) {
        this.mTask = mTask;
    }

    public TaskGrade getGrade() {
        return mGrade;
    }

    public void setGrade(TaskGrade mGrade) {
        this.mGrade = mGrade;
    }

    public TaskAnswer getAnswer() {
        return mAnswer;
    }

    public void setAnswer(TaskAnswer mAnswer) {
        this.mAnswer = mAnswer;
    }

    public Date getAssignedDate() {
        return mAssignedDate;
    }

    public void setAssignedDate(Date mAssignedDate) {
        this.mAssignedDate = mAssignedDate;
    }

    protected AssignedTask(Parcel in) {
        mAssigner = (Trainer) in.readValue(Trainer.class.getClassLoader());
        mResponsible = (Trainee) in.readValue(Trainee.class.getClassLoader());
        mTask = (Task) in.readValue(Task.class.getClassLoader());
        mGrade = (TaskGrade) in.readValue(TaskGrade.class.getClassLoader());
        mAnswer = (TaskAnswer) in.readValue(TaskAnswer.class.getClassLoader());
        long tmpMAssignedDate = in.readLong();
        mAssignedDate = tmpMAssignedDate != -1 ? new Date(tmpMAssignedDate) : null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(mAssigner);
        dest.writeValue(mResponsible);
        dest.writeValue(mTask);
        dest.writeValue(mGrade);
        dest.writeValue(mAnswer);
        dest.writeLong(mAssignedDate != null ? mAssignedDate.getTime() : -1L);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<AssignedTask> CREATOR = new Parcelable.Creator<AssignedTask>() {
        @Override
        public AssignedTask createFromParcel(Parcel in) {
            return new AssignedTask(in);
        }

        @Override
        public AssignedTask[] newArray(int size) {
            return new AssignedTask[size];
        }
    };
}
