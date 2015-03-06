package com.mobileappscompany.android.trainerapplibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Claudiordgz on 1/28/2015.
 */
public class PersonAddress implements Parcelable {
    private String mFirstLine;
    private String mSecondLine;
    private String mCity;
    private String mState;
    private String mZipCode;
    private Telephone mPhone;

    public PersonAddress(){
        mFirstLine = null;
        mSecondLine = null;
        mCity = null;
        mState = null;
        mZipCode =  null;
        mPhone = new Telephone();
    }

    public PersonAddress(String firstLine, String secondLine, String city, String state,
                  String zipCode, Telephone phone){
        mFirstLine = firstLine;
        mSecondLine = secondLine;
        mCity = city;
        mState = state;
        mZipCode = zipCode;
        mPhone = phone;
    }

    public String getFirstLine() {
        return mFirstLine;
    }

    public void setFirstLine(String mFirstLine) {
        this.mFirstLine = mFirstLine;
    }

    public String getSecondLine() {
        return mSecondLine;
    }

    public void setSecondLine(String mSecondLine) {
        this.mSecondLine = mSecondLine;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String mCity) {
        this.mCity = mCity;
    }

    public String getState() {
        return mState;
    }

    public void setState(String mState) {
        this.mState = mState;
    }

    public String getZipCode() {
        return mZipCode;
    }

    public void setZipCode(String mZipCode) {
        this.mZipCode = mZipCode;
    }

    public Telephone getPhone() {
        return mPhone;
    }

    public void setPhone(Telephone mPhone) {
        this.mPhone = mPhone;
    }

    protected PersonAddress(Parcel in) {
        mFirstLine = in.readString();
        mSecondLine = in.readString();
        mCity = in.readString();
        mState = in.readString();
        mZipCode = in.readString();
        mPhone = (Telephone) in.readValue(Telephone.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mFirstLine);
        dest.writeString(mSecondLine);
        dest.writeString(mCity);
        dest.writeString(mState);
        dest.writeString(mZipCode);
        dest.writeValue(mPhone);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<PersonAddress> CREATOR = new Parcelable.Creator<PersonAddress>() {
        @Override
        public PersonAddress createFromParcel(Parcel in) {
            return new PersonAddress(in);
        }

        @Override
        public PersonAddress[] newArray(int size) {
            return new PersonAddress[size];
        }
    };
}