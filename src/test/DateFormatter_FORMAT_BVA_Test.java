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

	@Test
	public void invalidFormatValidDateTest() {
		Date validDate = new Date();
		String invalidFormat = null;
		String result = DateFormatterFORMAT.format(validDate, invalidFormat);
		assertEquals(expected, result);
	}
	
	@Test
	public void invalidFormatInvalidDateTest() {
		Date invalidDate = null;
		String invalidFormat = null;
		String result = DateFormatterFORMAT.format(invalidDate, invalidFormat);
		String expected = "";
		assertEquals(expected, result);
	}	


}
