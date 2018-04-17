package finalproject.comp3617.com.parkinglotmanager.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {

    public static final String LOCATION_OBJECT = "LOCATION_OBJECT";

    private long id;
    private String code;
    private String orderCode;
    private boolean isMultiCapacity;

    public Location() {}

    public Location(Parcel in) {
        id = in.readLong();
        code = in.readString();
        orderCode = in.readString();
        isMultiCapacity = in.readByte() != 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public boolean isMultiCapacity() {
        return isMultiCapacity;
    }

    public void setIsMultiCapacity(boolean isMultiCapacity) {
        this.isMultiCapacity = isMultiCapacity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(getId());
        dest.writeString(getCode());
        dest.writeString(getOrderCode());
        dest.writeByte((byte) (isMultiCapacity ? 1 : 0));
    }

    public static final Parcelable.Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
}
