package test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import static org.junit.Assert.*;
import org.junit.Test;
import main.DateFormatterISSAMEDAYCAL;
public class DateFormatter_ISSAMEDAY_CAL_BVA_Test {
	
	@Test
	public void validNonMatchingDatesTest(){
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, -15);//calender 15 days ago
		boolean result = DateFormatterISSAMEDAYCAL.isSameDay(cal1, cal2);
		boolean expected = false;
		assertEquals(expected, result);
	}
	
	@Test
	public void validMatchingDatesTest(){
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		//cal2.add(Calendar.DATE, -15);//calender 15 days ago
		boolean result = DateFormatterISSAMEDAYCAL.isSameDay(cal1, cal2);
		boolean expected = true;
		assertEquals(expected, result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void oneNullDateTest(){
		Calendar cal1 = null;
		Calendar cal2 = Calendar.getInstance();
		//cal2.add(Calendar.DATE, -15);//calender 15 days ago
		boolean result = DateFormatterISSAMEDAYCAL.isSameDay(cal1, cal2);
		boolean expected = true;
		assertEquals(expected, result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void otherNullDateTest(){
		Calendar cal2 = null;
		Calendar cal1 = Calendar.getInstance();
		//cal2.add(Calendar.DATE, -15);//calender 15 days ago
		boolean result = DateFormatterISSAMEDAYCAL.isSameDay(cal1, cal2);
		boolean expected = true;
		assertEquals(expected, result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void twoNullDateTest(){
		Calendar cal1 = null;
		Calendar cal2 = null;
		//cal2.add(Calendar.DATE, -15);//calender 15 days ago
		boolean result = DateFormatterISSAMEDAYCAL.isSameDay(cal1, cal2);
		boolean expected = true;
		assertEquals(expected, result);
	}
}
////TEST THIS
//public static boolean isSameDay(Date date1, Date date2) {
//    if (date1 == null || date2 == null) {
//        throw new IllegalArgumentException("Dates must not be null");
//    }
//    Calendar cal1 = Calendar.getInstance();
//    cal1.setTime(date1);
//    Calendar cal2 = Calendar.getInstance();
//    cal2.setTime(date2);
//    return isSameDay(cal1, cal2);
//}
//
////TEST THIS
//public static boolean isSameDay(Calendar cal1, Calendar cal2) {
//    if (cal1 == null || cal2 == null) {
//        throw new IllegalArgumentException("Dates must not be null");
//    }
//    return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
//            cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
//            cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
//}

