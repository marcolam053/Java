import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Assignment implements Calendar {
		
	class dataset implements Appointment{
		String location;
		Date when;
		String  description;
		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return this.description;
		}
		@Override
		public String getLocation() {
			// TODO Auto-generated method stub
			return this.location;
		}
		@Override
		public Date getStartTime() {
			// TODO Auto-generated method stub
			return this.when;
		}
		
	}

	ArrayList<Appointment> calender =  new ArrayList<Appointment>();
	
	
	private String location;
	private Date when;
	private String description;
	
	// The default constructor for the class should be public
	// We will use this when we test your code!
	public Assignment() {
		// Ref :http://stackoverflow.com/questions/15423483/how-to-create-an-arraylist-class-that-can-store-multiple-objects
		dataset cur = new dataset(); 
		this.location = cur.location;
		this.when = cur.when;
		this.description = cur.description;
	}
	@Override
	public List<Appointment> getAppointments(String location) {
		// throw exception if invalid input or no input at all
		if(location == null){
			throw new IllegalArgumentException("Missing or Illegal argument entered.");
		}
		ArrayList<Appointment> appointment = new ArrayList<Appointment>();
		// Return a list of appointment with specific location.
		for(Appointment entry : calender){
			if(entry.getLocation().equals(location)){
				appointment.add(entry);
			}
		}
		// return the list of appointment
		return appointment;

	}

	@Override
	public Appointment getNextAppointment(Date when) {
		// throw exception if invalid input or no input at all
		if(when == null) {
			throw new IllegalArgumentException("Missing or Illegal argument entered.");
		}
		
		// check if it is a empty list
		if(calender.size() != 0){
			// find all the appointment before and at the time
			for(Appointment appointment : calender){
				if(appointment.getStartTime().compareTo(when) >= 0){
					return calender.get(calender.indexOf(appointment));
				}
			}
		}
		
		// return null if input time is not found or list is empty.
		return null;
	}

	@Override
	public Appointment getNextAppointment(Date when, String location) {
		// throw exception if invalid input are detected or no input detected.
		if(when == null || location == null){
			throw new IllegalArgumentException("Missing or Illegal argument entered.");
		}
		// return appointment if when and location are found.
		for(Appointment appointment : calender){
			if(appointment.getStartTime().compareTo(when)>=0 && appointment.getLocation().equals(location)){
				return calender.get(calender.indexOf(appointment));
			}
		}
		return null;
	}

	@Override
	public void add(String description, Date when, String location) {
		// throw exception if invalid input or no input at all
		if(description == null || when == null || location == null){
			throw new IllegalArgumentException("Missing or Illegal argument entered.");
		}
			dataset entry = new dataset(); // Put data into the appointment
			entry.description = description;
			entry.location = location;
			entry.when = when;
			calender.add(entry); // load dataset into the calendar.
	}

	@Override
	public void remove(Appointment appointment) {
		// throw exception if invalid input or no input at all
		if(appointment == null) throw new IllegalArgumentException("Missing or Illegal argument entered.");
		List<Appointment> removal = new ArrayList<Appointment>();
		for(Appointment entry : calender){
			if(entry.getDescription() == appointment.getDescription() && entry.getLocation() == appointment.getLocation() && entry.getStartTime() == appointment.getStartTime()){
				removal.add(entry);
			}
		}
		calender.removeAll(removal);
	}

}

