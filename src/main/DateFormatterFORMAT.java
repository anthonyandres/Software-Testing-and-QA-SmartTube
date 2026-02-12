package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class DateFormatterFORMAT {
//    private DateFormatterFORMAT() {
//        throw new AssertionError();
//    }

//    public static String format(Date date, Template template) {
//        return format(date, template.get());
//    }
    
    //TEST THIS
    public static String format(Date date, String format) {
        if (date == null) return "";
        return new SimpleDateFormat(format, Locale.getDefault())
                .format(date);
    }
}
//    //TEST THIS
//    public static boolean isSameDay(Date date1, Date date2) {
//        if (date1 == null || date2 == null) {
//            throw new IllegalArgumentException("Dates must not be null");
//        }
//        Calendar cal1 = Calendar.getInstance();
//        cal1.setTime(date1);
//        Calendar cal2 = Calendar.getInstance();
//        cal2.setTime(date2);
//        return isSameDay(cal1, cal2);
//    }
//    
//    //TEST THIS
//    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
//        if (cal1 == null || cal2 == null) {
//            throw new IllegalArgumentException("Dates must not be null");
//        }
//        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
//                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
//                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
//    }
//    
//    //TEST THIS
//    public static boolean isSameYear(Date date1, Date date2) {
//        if (date1 == null || date2 == null) {
//            throw new IllegalArgumentException("Dates must not be null");
//        }
//        Calendar cal1 = Calendar.getInstance();
//        cal1.setTime(date1);
//        Calendar cal2 = Calendar.getInstance();
//        cal2.setTime(date2);
//        return isSameYear(cal1, cal2);
//    }
//    //TEST THIS
//    public static boolean isSameYear(Calendar cal1, Calendar cal2) {
//        if (cal1 == null || cal2 == null) {
//            throw new IllegalArgumentException("Dates must not be null");
//        }
//        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
//                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR));
//    }
//    //TEST THIS
//    public static boolean isToday(Calendar calendar) {
//        return isSameDay(calendar, Calendar.getInstance());
//    }
//    //TEST THIS
//    public static boolean isToday(Date date) {
//        return isSameDay(date, Calendar.getInstance().getTime());
//    }
//    //TEST THIS
//    public static boolean isYesterday(Calendar calendar) {
//        Calendar yesterday = Calendar.getInstance();
//        yesterday.add(Calendar.DAY_OF_MONTH, -1);
//        return isSameDay(calendar, yesterday);
//    }
//
//    //TEST THIS??
//    public static boolean isYesterday(Date date) {
//        Calendar yesterday = Calendar.getInstance();
//        yesterday.add(Calendar.DAY_OF_MONTH, -1);
//        return isSameDay(date, yesterday.getTime());
//    }
//    //TEST THIS??
//    public static boolean isCurrentYear(Date date) {
//        return isSameYear(date, Calendar.getInstance().getTime());
//    }
//    //TEST THIS??
//    public static boolean isCurrentYear(Calendar calendar) {
//        return isSameYear(calendar, Calendar.getInstance());
//    }
//
//    /**
//     * Interface used to format dates before they were displayed (e.g. dialogs time, messages date headers etc.).
//     */
//    public interface Formatter {
//
//        /**
//         * Formats an string representation of the date object.
//         *
//         * @param date The date that should be formatted.
//         * @return Formatted text.
//         */
//        String format(Date date);
//    }
//
//    public enum Template {
//        STRING_DAY_MONTH_YEAR("d MMMM yyyy"),
//        STRING_DAY_MONTH("d MMMM"),
//        TIME("HH:mm");
//
//        private String template;
//
//        Template(String template) {
//            this.template = template;
//        }
//
//        public String get() {
//            return template;
//        }
//    }
//}

