package com.mobileappscompany.android.trainerapplibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Claudiordgz on 1/28/2015.
 */
public class Telephone implements Parcelable {
    private int mCountryCode;
    private int mAreaCode;
    private int mPhoneNumber;

    public Telephone() {
        mCountryCode = 0;
        mAreaCode = 0;
        mPhoneNumber = 0;
    }

    public Telephone(int countryCode, int areaCode, int phoneNumber) {
        mCountryCode = countryCode;
        mAreaCode = areaCode;
        mPhoneNumber = phoneNumber;
    }

    public int getCountryCode() {
        return mCountryCode;
    }

    public void setCountryCode(int mCountryCode) {
        this.mCountryCode = mCountryCode;
    }

    public int getAreaCode() {
        return mAreaCode;
    }

    public void setAreaCode(int mAreaCode) {
        this.mAreaCode = mAreaCode;
    }

    public int getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(int mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    protected Telephone(Parcel in) {
        mCountryCode = in.readInt();
        mAreaCode = in.readInt();
        mPhoneNumber = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mCountryCode);
        dest.writeInt(mAreaCode);
        dest.writeInt(mPhoneNumber);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Telephone> CREATOR = new Parcelable.Creator<Telephone>() {
        @Override
        public Telephone createFromParcel(Parcel in) {
            return new Telephone(in);
        }

        @Override
        public Telephone[] newArray(int size) {
            return new Telephone[size];
        }
    };
}