package com.chapslife.septatest.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kchapman on 10/24/13.
 */
public class RailTrip {

    public String orig_train;
    public String orig_line;
    public String orig_departure_time;
    public String orig_arrival_time;
    public String orig_delay;
    public String term_train;
    public String term_line;
    public String term_depart_time;
    public String term_arrival_time;
    public String Connection;
    public String term_delay;
    public String isdirect;

    public RailTrip(){}

    protected RailTrip(Parcel in) {
        orig_train = in.readString();
        orig_line = in.readString();
        orig_departure_time = in.readString();
        orig_arrival_time = in.readString();
        orig_delay = in.readString();
        term_train = in.readString();
        term_line = in.readString();
        term_depart_time = in.readString();
        term_arrival_time = in.readString();
        Connection = in.readString();
        term_delay = in.readString();
        isdirect = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(orig_train);
        dest.writeString(orig_line);
        dest.writeString(orig_departure_time);
        dest.writeString(orig_arrival_time);
        dest.writeString(orig_delay);
        dest.writeString(term_train);
        dest.writeString(term_line);
        dest.writeString(term_depart_time);
        dest.writeString(term_arrival_time);
        dest.writeString(Connection);
        dest.writeString(term_delay);
        dest.writeString(isdirect);
    }

    public static final Parcelable.Creator<RailTrip> CREATOR = new Parcelable.Creator<RailTrip>() {
        public RailTrip createFromParcel(Parcel in) {
            return new RailTrip(in);
        }

        public RailTrip[] newArray(int size) {
            return new RailTrip[size];
        }
    };

}
