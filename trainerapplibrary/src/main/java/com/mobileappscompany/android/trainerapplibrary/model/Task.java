package com.mobileappscompany.android.trainerapplibrary.model;

import java.util.Date;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Claudiordgz on 1/28/2015.
 */
public class Task implements Parcelable {
    private String mName;
    private String mDescription;
    private Date mDeadline;
    private String mTaskType;
    private int mStatus;
    private Date mOriginated;
    private Date mLastUpdated;

    public Task(){
        mName = null;
        mDescription = null;
        mDeadline = null;
        mTaskType = null;
        mStatus = 0;
        mOriginated = new Date();
        mLastUpdated = new Date();
    }

    public Task(String name, String description, Date deadline,
                String taskType, int status) {
        mName = name;
        mDescription = description;
        mDeadline = deadline;
        mTaskType = taskType;
        mStatus = status;
        mOriginated = new Date();
        mLastUpdated = new Date();
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public Date getDeadline() {
        return mDeadline;
    }

    public void setDeadline(Date mDeadline) {
        this.mDeadline = mDeadline;
    }

    public String getTaskType() {
        return mTaskType;
    }

    public void setTaskType(String mTaskType) {
        this.mTaskType = mTaskType;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int mStatus) {
        this.mStatus = mStatus;
    }

    public Date getOriginated() {
        return mOriginated;
    }

    public Date getLastUpdated() {
        return mLastUpdated;
    }

    public void setLastUpdated(Date mLastUpdated) {
        this.mLastUpdated = mLastUpdated;
    }

    protected Task(Parcel in) {
        mName = in.readString();
        mDescription = in.readString();
        long tmpMDeadline = in.readLong();
        mDeadline = tmpMDeadline != -1 ? new Date(tmpMDeadline) : null;
        mTaskType = in.readString();
        mStatus = in.readInt();
        long tmpMOriginated = in.readLong();
        mOriginated = tmpMOriginated != -1 ? new Date(tmpMOriginated) : null;
        long tmpMLastUpdated = in.readLong();
        mLastUpdated = tmpMLastUpdated != -1 ? new Date(tmpMLastUpdated) : null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mDescription);
        dest.writeLong(mDeadline != null ? mDeadline.getTime() : -1L);
        dest.writeString(mTaskType);
        dest.writeInt(mStatus);
        dest.writeLong(mOriginated != null ? mOriginated.getTime() : -1L);
        dest.writeLong(mLastUpdated != null ? mLastUpdated.getTime() : -1L);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Task> CREATOR = new Parcelable.Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };
}
