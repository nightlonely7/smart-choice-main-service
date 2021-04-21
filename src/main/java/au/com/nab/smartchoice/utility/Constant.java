package au.com.nab.smartchoice.utility;

import java.util.function.Supplier;

public class Constant {

    public static final String DATE_TIME_FORMAT = "uuuu-MM-dd HH:mm:ss";

    public static Supplier<IllegalArgumentException> notFoundException(String field, String value) {
        return () -> new IllegalArgumentException(field + " '" + value + "' not found.");
    }
}
