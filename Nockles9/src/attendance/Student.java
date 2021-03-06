package attendance;

public class Student implements Attendee 
{
	private boolean present = false;
	private String firstName;
	private String lastName;
	
	public Student(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public boolean isPresent()
	{
		return this.present;
	}
	
	public void setPresent(boolean present)
	{
		this.present = present;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public boolean mathces(String first, String last)
	{
		return ((firstName.toLowerCase().equals(first.toLowerCase())) && (lastName.toLowerCase().equals(last.toLowerCase())));
	}
	
	public boolean matches(String last)
	{
		return (lastName.toLowerCase().equals(last.toLowerCase()));
	}
	
	public String getReportString()
	{
		String finalString = this.lastName;
		
		for (int i = 0; i < (20 - this.lastName.length()); i += 1)
		{
			finalString += " ";
		}
		finalString += this.firstName;
		for (int i = 0; i < (20 - this.firstName.length()); i += 1)
		{
			finalString += " ";
		}
		if (this.present)
		{
			finalString += ("PRESENT");
			return finalString;
		}
		else
		{
			finalString += ("ABSENT");
			return finalString;
		}
	}
}
