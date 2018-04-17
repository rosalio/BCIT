package finalproject.comp3617.com.parkinglotmanager.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Vehicle implements Parcelable {

    public static final String VEHICLE_OBJECT = "VEHICLE_OBJECT";

    private long id;
    private long locationId;
    private String type;
    private String make;
    private String model;
    private String licensePlate;
    private String scannableId;
    private Date arrivalTime;
    private Date departureTime;

    public Vehicle() {}

    public Vehicle(Parcel in) {
        id = in.readLong();
        locationId = in.readLong();
        type = in.readString();
        make = in.readString();
        model = in.readString();
        licensePlate = in.readString();
        scannableId = in.readString();
        arrivalTime = (Date) in.readSerializable();
        departureTime = (Date) in.readSerializable();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getScannableId() {
        return scannableId;
    }

    public void setScannableId(String scannableId) {
        this.scannableId = scannableId;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(getId());
        dest.writeLong(getLocationId());
        dest.writeString(getType());
        dest.writeString(getMake());
        dest.writeString(getModel());
        dest.writeString(getLicensePlate());
        dest.writeString(getScannableId());
        dest.writeSerializable(getArrivalTime());
        dest.writeSerializable(getDepartureTime());
    }

    public static final Parcelable.Creator<Vehicle> CREATOR = new Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel source) {
            return new Vehicle(source);
        }

        @Override
        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };
}
