package test;
import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;
import main.DateFormatterISSAMEDAYDATE;
public class DateFormatter_ISSAMEDAY_BVA_Test {
	
	@Test
	public void validNonMatchingDatesTest(){
		Date date1 = new Date(); //date1 is todays date
		Date date2 = new Date();
       date2.setTime(1000); //set date to 1000ms after EPOCH (some date in 1970)
       //System.out.println(date2);
       boolean result = DateFormatterISSAMEDAYDATE.isSameDay(date1, date2);
       boolean expected = false;
       assertEquals(expected, result);
       //System.out.println(DateFormatter.isSameDay(date1, date2));
	}
	
	@Test
	public void validMatchingDatesTest(){
		Date date1 = new Date(); //date1 is todays date
		Date date2 = new Date();
       boolean result = DateFormatterISSAMEDAYDATE.isSameDay(date1, date2);
       boolean expected = true;
       assertEquals(expected, result);
       //System.out.println(DateFormatter.isSameDay(date1, date2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void oneNullDateTest(){
		Date date1 = new Date(); //date1 is todays date
		Date date2 = null;
       //date2.setTime(1000); //set date to 1000ms after EPOCH (some date in 1970)
       //System.out.println(date2);
       boolean result = DateFormatterISSAMEDAYDATE.isSameDay(date1, date2);
       boolean expected = false;
       assertEquals(expected, result);
       //System.out.println(DateFormatter.isSameDay(date1, date2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void twoNullDateTest(){
		Date date1 = null; //date1 is todays date
		Date date2 = null;
       //date2.setTime(1000); //set date to 1000ms after EPOCH (some date in 1970)
       //System.out.println(date2);
       boolean result = DateFormatterISSAMEDAYDATE.isSameDay(date1, date2);
       boolean expected = false;
       assertEquals(expected, result);
       //System.out.println(DateFormatter.isSameDay(date1, date2));
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
////TEST THIS
//public static boolean isSameDay(Calendar cal1, Calendar cal2) {
//    if (cal1 == null || cal2 == null) {
//        throw new IllegalArgumentException("Dates must not be null");
//    }
//    return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
//            cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
//            cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
//}

