package com.lakhdharmedakrem.deepmetisinterview.dateutils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtility {

    private DateUtility() {
        throw new AssertionError("Utility class cannot be instantiated");
    }

    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
