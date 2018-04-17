package finalproject.comp3617.com.parkinglotmanager.model;


import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    public static final String USER_OBJECT = "USER_OBJECT";

    private long id;
    private String firstName;
    private String lastName;
    private String badgeId;
    private boolean isAdmin;

    public User() {}

    public User(Parcel in) {
        id = in.readLong();
        firstName = in.readString();
        lastName = in.readString();
        badgeId = in.readString();
        isAdmin = in.readByte() != 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(String badgeId) {
        this.badgeId = badgeId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(getId());
        dest.writeString(getFirstName());
        dest.writeString(getLastName());
        dest.writeString(getBadgeId());
        dest.writeByte((byte) (isAdmin ? 1 : 0));
    }

    public static final Parcelable.Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
