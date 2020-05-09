package com.uc.uts_protech.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Output implements Parcelable {

  private static String Pennjualantotal;

    public Output(String pennjualantotal) {
        Pennjualantotal = pennjualantotal;
    }

    public String getPennjualantotal() {
        return Pennjualantotal;
    }

    public void setPennjualantotal(String pennjualantotal) {
        Pennjualantotal = pennjualantotal;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Pennjualantotal);
    }

    protected Output(Parcel in) {
        this.Pennjualantotal = in.readString();
    }

    public static final Creator<Output> CREATOR = new Creator<Output>() {
        @Override
        public Output createFromParcel(Parcel source) {
            return new Output(source);
        }

        @Override
        public Output[] newArray(int size) {
            return new Output[size];
        }
    };
}
