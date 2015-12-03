package com.example.nikolay.shuffledex;

import android.os.Parcel;
import android.os.Parcelable;

public class Flourish implements Parcelable  {
    private String name;
    private String creator;

    public Flourish(String name, String creator) {
        this.name = name;
        this.creator = creator;
    }

    public Flourish(Parcel source) {
        name = source.readString();
        creator = source.readString();
    }

    public static final Creator<Flourish> CREATOR = new Creator<Flourish>() {
        @Override
        public Flourish createFromParcel(Parcel in) {
            return new Flourish(in);
        }

        @Override
        public Flourish[] newArray(int size) {
            return new Flourish[size];
        }
    };

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(creator);
    }
}
