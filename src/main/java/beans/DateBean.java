package beans;

import java.io.Serializable;
import java.util.Date;

public class DateBean implements Serializable {
    private Date currentDate;

    public DateBean() {
        this.currentDate = new Date();
    }

    public Date getCurrentDate() {
        return currentDate;
    }
}
