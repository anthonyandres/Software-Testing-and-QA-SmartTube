# Preface

This repository contains unit testing of various methods within Yuliskov's open source project [SmartTube](https://github.com/yuliskov/SmartTube). Originally this project was done for my class COE891: Software Testing and Quality Assurance.

# Introduction

In this project, five different methods were selected from the Java application and tested on using five different testing abstractions.

The five methods are contained within yuliskov's [Proxy.java](https://github.com/yuliskov/SmartTube/blob/master/common/src/main/java/com/liskovsoft/smartyoutubetv2/common/proxy/Proxy.java) and [DateFormatter.java](https://github.com/yuliskov/SmartTube/blob/master/chatkit/src/main/java/com/stfalcon/chatkit/utils/DateFormatter.java) classes. They include the following:

- DateFormatter.format(Date, String)
- DateFormatter.isSameDay(Calender, Calender)
- DateFormatter.isSameDay(Date, Date)
- Proxy.equals(Object)
- Proxy.Proxy(Type, SocketAddress)

The four testing abstractions include the following:
- Input Space Partitioning (ISP),
- Control Flow Graphs (CFG)
- Data Flow Graphs (DFG)
- logic-based testing
- mutation testing

A majority of the testing was done in the Eclipse Java IDE using the JUnit testing library as well as the PitClipse plugin for mutation testing. Control flow and data flow graphs were created using the free to use web application [Lucidchart](https://www.lucidchart.com/pages).

# Testing Breakdown

In this section I will cover over the tests done for each method.

## format(Date, String)

    public static String format(Date date, String format) {
        if (date == null) return "";
        return new SimpleDateFormat(format, Locale.getDefault())
                .format(date);
    }

This method takes a variable _date_ of data type _Date_ and a variable _format_ for format of that date as a _String_. It will return an empty string on a null _date_, otherwise it returns the _Date_ as a _String_ in the format of the variable _format_. 

The original DateFormatter.java file was modified by commenting out relevant code so testing on the file can be focused on the format() method. You can find the file I used to run tests on this specific method [here](https://github.com/anthonyandres/Software-Testing-and-QA-SmartTube/blob/main/src/main/DateFormatterFORMAT.java). The file I used to test this method is found [here](https://github.com/anthonyandres/Software-Testing-and-QA-SmartTube/blob/main/src/test/DateFormatter_FORMAT_BVA_Test.java).

### Input Space Partitioning (ISP): format(Date, String)

The method takes two input parameters: date and format. Due to this, the different combination criteria (ACoC, BCC, ECC, PWC, and TWC) are easily satisfied. The two inputs are represented as A and B in the following tables that test the inputs on the characteristic of null-ness and or valid-ness. At the same time, these tests cover the boundary values since both null-ness and valid-ness are binary characteristics and are either null/valid or non-null/non-valid.

| Characteristic | non-null | null |
| --- | --- | --- |
| A (date) | A1 | A2 |
| B (format) | B1 | B2 |

The following combinations satisfy ACoC, BCC, ECC, PWC and TWC:
(A1 B1), (A1 B2), (A2, B1), (A2, B2)

Expected outcome: method should return the current date in the format of variable _format_

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

In the first test, I test for valid date and valid format

- (A1 B1), both inputs are non-null

- Both variables _date_ and _format_ are valid inputs

Outcome: the method returns the current date in the format of _format_
      
    	@Test
    	public void validFormatInvalidDateTest() {
    		Date invalidDate = null;
    		String validFormat = "dd-MM-yyyy";
    		String result = DateFormatterFORMAT.format(validDate, validFormat);
    		String expected = "";
    		assertEquals(expected, result);
    	}

In the second test, I test for invalid date and invalid format:

- (A1 B2), A is null, B is non-null

- _date_ is invalid, _format_ is valid

Outcome: the method returns an empty String due to an empty _date_

    	@Test
    	public void invalidFormatValidDateTest() {
    		Date validDate = new Date();
    		String invalidFormat = null;
    		String result = DateFormatterFORMAT.format(validDate, invalidFormat);
    		assertEquals(expected, result);
    	}

In the third test, I test for valid date and invalid format:

- (A1 B2), A is non-null, B is null

- _date_ is valid, _format_ is invalid

Outcome: method throws null pointer exception
      
    	@Test
    	public void invalidFormatInvalidDateTest() {
    		Date invalidDate = null;
    		String invalidFormat = null;
    		String result = DateFormatterFORMAT.format(invalidDate, invalidFormat);
    		String expected = "";
    		assertEquals(expected, result);
    	}	      
    }

In the fourth test, I test for valid date and invalid format:

- (A2 B2), A is null, B is null

- _date_ is invalid, _format_ is invalid

Outcome: the method returns an empty String rather than throwing a null pointer exception since the method handles a null “date” first

### Control Flow Graphs (CFG) & Data Flow Graphs (DFG): format(Date, String)

![formatCFG](https://github.com/anthonyandres/Software-Testing-and-QA-SmartTube/blob/main/Test%20Images/formatCFG.jpg)

![formatDFG](https://github.com/anthonyandres/Software-Testing-and-QA-SmartTube/blob/main/Test%20Images/formatDFG.jpg)

### Logic Coverage: format(Date, String)

In this method I use Clause Coverage criteria; All clauses must be tested when they evaulate to true or false. The test requirements contain each clause evaulated to true or false, and the test set contains the set of tests that satisfy all conditions in the test requirements.

**Logical Coverage**:
1. if(date == null)
    - if(a)
 
**Clause Coverage**:
1. date == null

**Test Requirements**
Clause 1:
- evaulates true: _date_ is null
- evaulates false: _date_ is not null

**Test Set**:
1. _date_ is null
2. _date_ is not null

### Mutation Coverage: format(Date, String)

The mutation operators selected were all mutation operators due to the simplicity of the method. All ten mutations were killed, and an effective 100% line coverage was achieved for the method (the PIT summary says 75% but this is due to the class declaration line being counted towards one of the tested lines.)

![formatMutation](https://github.com/anthonyandres/Software-Testing-and-QA-SmartTube/blob/main/Test%20Images/formatMutation.jpg)

