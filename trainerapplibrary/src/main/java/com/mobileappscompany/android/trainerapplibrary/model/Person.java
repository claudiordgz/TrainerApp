package com.mobileappscompany.android.trainerapplibrary.model;

import java.util.ArrayList;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Claudiordgz on 1/28/2015.
 */
public class Person implements Parcelable {
    private String mFirstName;
    private String mLastName;
    private PersonAddress mContactAddress;
    private ArrayList<Telephone> mPhoneNumbers;
    private ArrayList<String> mEmails;

    public Person() {
        mFirstName = null;
        mLastName = null;
        mContactAddress = new PersonAddress();
        mPhoneNumbers = new ArrayList<>();
        mEmails = new ArrayList<>();
    }

    public Person(String firstName, String lastName,
                  PersonAddress contactAddress, ArrayList<Telephone> phoneNumbers,
                  ArrayList<String> emails){
        mFirstName = firstName;
        mLastName = lastName;
        mContactAddress = contactAddress;
        mPhoneNumbers = phoneNumbers;
        mEmails = emails;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public PersonAddress getContactAddress() {
        return mContactAddress;
    }

    public void setContactAddress(PersonAddress mContactAddress) {
        this.mContactAddress = mContactAddress;
    }

    public ArrayList<Telephone> getPhoneNumbers() {
        return mPhoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<Telephone> mPhoneNumbers) {
        this.mPhoneNumbers = mPhoneNumbers;
    }

    public ArrayList<String> getEmails() {
        return mEmails;
    }

    public void setEmails(ArrayList<String> mEmails) {
        this.mEmails = mEmails;
    }

    protected Person(Parcel in) {
        mFirstName = in.readString();
        mLastName = in.readString();
        mContactAddress = (PersonAddress) in.readValue(PersonAddress.class.getClassLoader());
        if (in.readByte() == 0x01) {
            mPhoneNumbers = new ArrayList<Telephone>();
            in.readList(mPhoneNumbers, Telephone.class.getClassLoader());
        } else {
            mPhoneNumbers = null;
        }
        if (in.readByte() == 0x01) {
            mEmails = new ArrayList<String>();
            in.readList(mEmails, String.class.getClassLoader());
        } else {
            mEmails = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mFirstName);
        dest.writeString(mLastName);
        dest.writeValue(mContactAddress);
        if (mPhoneNumbers == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mPhoneNumbers);
        }
        if (mEmails == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mEmails);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
