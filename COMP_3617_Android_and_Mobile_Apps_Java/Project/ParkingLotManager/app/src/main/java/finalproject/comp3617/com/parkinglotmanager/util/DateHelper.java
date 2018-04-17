package finalproject.comp3617.com.parkinglotmanager.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    public static final DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

    public static String getDateTimeString(Date date) {
        return dateFormat.format(date);
    }
}
