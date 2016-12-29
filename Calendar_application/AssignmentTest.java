import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AssignmentTest {
	
	// Set up JUnit to be able to check for expected exceptions
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	// This will make it a bit easier for us to make Date objects
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	// Helper method to build the example calendar
	private Calendar buildTinyExample() {
		Calendar calendar = new Assignment();
		try {
			calendar.add("A", df.parse("2016/09/03 09:00:00"), "SIT lab 117");
			calendar.add("B", df.parse("2016/09/03 16:00:00"), "SIT lab 117");
			calendar.add("C", df.parse("2016/09/03 16:00:00"), "SIT lab 118");
			calendar.add("D", df.parse("2016/09/03 18:00:00"), "SIT lab 117");
			calendar.add("E",df.parse("2016/09/03 18:00:00"),"SIT lab 115");
			calendar.add("F",df.parse("2016/09/04 08:00:00"),"SIT lab 116");
			calendar.add("G",df.parse("2016/09/04 12:00:00"),"SIT lab 118");
			calendar.add("H",df.parse("2016/09/04 15:00:00"),"SIT lab 118");
			calendar.add("I",df.parse("2016/09/05 12:00:00"),"Fisher Library");
		} catch (ParseException e) {
			e.printStackTrace();
			fail("The test case is broken, invalid SimpleDateFormat parse");
		}
		return calendar;
	}

	@Test
	public void testGetAppointments_Correct() {
		
		Calendar calendar = buildTinyExample();
		
		// This should be a list containing Appointments A, B and D
		List<Appointment> appointments = calendar.getAppointments("SIT lab 117");
		
		// Good testing should be more thorough!
		List<String> descriptions = new ArrayList<String>();
		for(Appointment a: appointments) {
			descriptions.add(a.getDescription());
		}

		// Sorting the objects before we compare the list, since the assignment
		// doesn't require the output to be in any particular order
		// Compare if the appointment returned is the one we want by using description
		Collections.sort(descriptions);
		assertEquals(Arrays.asList("A", "B", "D"), descriptions);
		
	}
		
	@Test
	public void testGetNextAppointment_Correct() {
		
		Calendar calendar = buildTinyExample();
		
		// Returning all the appointment which start after the input time
		try {
			Appointment appointment = calendar.getNextAppointment(df.parse("2016/09/03 13:00:00"));
			String description = appointment.getDescription();
			assertTrue(description.equals("B") || description.equals("C") || description.equals("E") || description.equals("F") || 
						description.equals("G") || description.equals("H") || description.equals("I"));
			} catch (ParseException e) {
				e.printStackTrace();
				fail("The test case is broken, invalid SimpleDateFormat parse");
		}

		// Test input of non-existing data
		try {
			assertNull(calendar.getNextAppointment(df.parse("2020/01/01 13:00:00")));
		} catch (ParseException e) {
			e.printStackTrace();
			fail("The test case is broken, invalid SimpleDateFormat parse");
		}

	}
	
	@Test
	public void testRemoveAppointment_Correct() {

		Calendar calendar = buildTinyExample();

		// This should return false
		try {
			Appointment appointment = calendar.getNextAppointment(df.parse("2016/09/03 13:00:00"), "SIT lab 117");
			calendar.remove(appointment); // remove the appointment
			String description = appointment.getDescription();
			assertFalse(description.equals("B"));
		} catch (ParseException e) {
			e.printStackTrace();
			fail("The test case is broken, invalid SimpleDateFormat parse");
		}
	}
	
	public void testRemoveAppointment_Missing() {

		Calendar calendar = buildTinyExample();

		// This should return false
		try {
			Appointment appointment = calendar.getNextAppointment(df.parse("2016/09/03 13:00:00"), "SIT Lab 117");
			calendar.remove(null); // remove the appointment
			thrown.expect(IllegalArgumentException.class);
		} catch (ParseException e) {
			e.printStackTrace();
			fail("The test case is broken, invalid SimpleDateFormat parse");
		}
	}
	
	public void testRemoveAppointment_invalid() {

		Calendar calendar = buildTinyExample();

		// This should return false
		try {
			Appointment appointment = calendar.getNextAppointment(df.parse("2016/09/03 130"), "SIT Lab 117");
			thrown.expect(IllegalArgumentException.class);
		} catch (ParseException e) {
			e.printStackTrace();
			fail("The test case is broken, invalid SimpleDateFormat parse");
		}
	}
	
	// Test if the add method can successfully add an appointment or not
	@Test
	public void testAddAppointment_Correct() {
		Calendar cal = buildTinyExample();
		try{
			cal.add("J", df.parse("2016/10/04 09:00:00"), "International House");
			assertEquals(Arrays.asList("J","2016/10/04 09:00:00","International House"),cal.getAppointments("International House"));
		} catch (ParseException e){
			e.printStackTrace();
			fail("The test case is broken, invalid SimpleDateFormat parse");
		}
	}
	
	// test method : getNextAppointment(when,location)
	@Test
	public void testGetNextAppointment_MultiField() {
		Calendar cal = buildTinyExample();
		try {
			Appointment temp = cal.getNextAppointment(df.parse("2016/09/03 09:00:00"),"SIT Lab 118");
			String description = temp.getDescription();
			assertTrue(description.equals("G") || description.equals("H") || description.equals("C"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("The test case is broken,invalid SimpleDateFormat parse");
		}
	}
	
	// Test simple operation
	// test : add,remove,get
	@Test
	public void TestOperation(){
		Calendar cal = buildTinyExample();
		
		// remove all appointment which are after 2016-09-03 1300
		try {
			Appointment appointment = cal.getNextAppointment(df.parse("2016/09/03 13:00:00"));
			cal.remove(appointment);
			cal.add("test", df.parse("2016/09/11 09:00:00"), "Quadrangle");
			
			Appointment appoint = cal.getNextAppointment(df.parse("2016/09/03 06:00:00"));
			
			String des = appoint.getDescription();
			assertTrue(des.equals("A") || des.equals("B") || des.equals("test"));
			
		} catch (ParseException e) {
			e.printStackTrace();
			fail("The test case is broken,invalid SimpleDateFormat parse");
		}
	}
	@Test
	public void testRemoveAll(){
		Calendar cal = buildTinyExample();
		try {
			Appointment appointment = cal.getNextAppointment(df.parse("2016/09/03 06:00:00"));
			cal.remove(appointment);
			assertTrue(cal == null);
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void testIllegalArgumentExample() {

		Calendar calendar = buildTinyExample();

		// Tell JUnit to expect an IllegalArgumentException
		thrown.expect(IllegalArgumentException.class);
		
		// This should cause an IllegalArgumentException to be thrown
		calendar.getNextAppointment(null);

	}

}
