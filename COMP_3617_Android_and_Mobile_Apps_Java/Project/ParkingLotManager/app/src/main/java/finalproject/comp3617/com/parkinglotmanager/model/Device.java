package finalproject.comp3617.com.parkinglotmanager.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Device implements Parcelable {

    public static final String DEVICE_OBJECT = "DEVICE_OBJECT";

    private long id;
    private String imei;

    public Device() {}

    public Device(Parcel in) {
        id = in.readLong();
        imei = in.readString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(getId());
        dest.writeString(getImei());
    }

    public static final Parcelable.Creator<Device> CREATOR = new Creator<Device>() {
        @Override
        public Device createFromParcel(Parcel source) {
            return new Device(source);
        }

        @Override
        public Device[] newArray(int size) {
            return new Device[size];
        }
    };
}
