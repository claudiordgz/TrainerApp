package com.mobileappscompany.android.trainerapplibrary.model;

import java.util.ArrayList;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Claudiordgz on 1/28/2015.
 */
public class TaskAnswer implements Parcelable {
    private String mContents;
    private ArrayList<String> mAttachments;

    public TaskAnswer() {
        mContents = null;
        mAttachments = null;
    }

    public TaskAnswer(String contents, ArrayList<String> attachments) {
        mContents = contents;
        mAttachments = attachments;
    }

    public String getContents() {
        return mContents;
    }

    public void setContents(String mContents) {
        this.mContents = mContents;
    }

    public ArrayList<String> getAttachments() {
        return mAttachments;
    }

    public void setAttachments(ArrayList<String> mAttachments) {
        this.mAttachments = mAttachments;
    }

    protected TaskAnswer(Parcel in) {
        mContents = in.readString();
        if (in.readByte() == 0x01) {
            mAttachments = new ArrayList<String>();
            in.readList(mAttachments, String.class.getClassLoader());
        } else {
            mAttachments = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mContents);
        if (mAttachments == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mAttachments);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<TaskAnswer> CREATOR = new Parcelable.Creator<TaskAnswer>() {
        @Override
        public TaskAnswer createFromParcel(Parcel in) {
            return new TaskAnswer(in);
        }

        @Override
        public TaskAnswer[] newArray(int size) {
            return new TaskAnswer[size];
        }
    };
}
