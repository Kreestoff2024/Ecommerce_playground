package utilis;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getToday(){
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }
}
