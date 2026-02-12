package test;

import static org.junit.Assert.*;
import org.junit.Test;
import main.DateFormatterFORMAT;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateFormatter_FORMAT_BVA_Test {
	
	String expected = "07-04-2024";
	@Test
	public void validFormatValidDateTest() {
		Date validDate = new Date();
		String validFormat = "dd-MM-yyyy";
		String result = DateFormatterFORMAT.format(validDate, validFormat);
		assertEquals(expected, result);
	}
	
	@Test
	public void validFormatInvalidDateTest() {
		Date validDate = null;
		String validFormat = "dd-MM-yyyy";
		String result = DateFormatterFORMAT.format(validDate, validFormat);
		String expected = "";
		assertEquals(expected, result);
	}
}
