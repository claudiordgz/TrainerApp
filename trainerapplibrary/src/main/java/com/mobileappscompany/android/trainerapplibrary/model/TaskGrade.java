package com.mobileappscompany.android.trainerapplibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Claudiordgz on 1/28/2015.
 */
public class TaskGrade implements Parcelable {
    private String mResult;
    private String mFeedback;

    public TaskGrade(){
        mResult = null;
        mFeedback = null;
    }

    public TaskGrade(String result, String feedback) {
        mResult = result;
        mFeedback = feedback;
    }

    public String getResult() {
        return mResult;
    }

    public void setResult(String mResult) {
        this.mResult = mResult;
    }

    public String getFeedback() {
        return mFeedback;
    }

    public void setFeedback(String mFeedback) {
        this.mFeedback = mFeedback;
    }

    protected TaskGrade(Parcel in) {
        mResult = in.readString();
        mFeedback = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mResult);
        dest.writeString(mFeedback);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<TaskGrade> CREATOR = new Parcelable.Creator<TaskGrade>() {
        @Override
        public TaskGrade createFromParcel(Parcel in) {
            return new TaskGrade(in);
        }

        @Override
        public TaskGrade[] newArray(int size) {
            return new TaskGrade[size];
        }
    };
}
