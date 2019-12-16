package pl.alx.kpij.Ogloszenia;

public class Advertiser {
	
	private String firstName, lastName, place, phoneNumber;
	
	
	public Advertiser(String firstName, String lastName, String place, String phoneNumber) {
		setFirstName(firstName);
		setLastName(lastName);
		setPlace(place);
		setPhoneNumber(phoneNumber);
	}
	
	public String toString() {
		return String.format("%s %s %s %s", firstName, lastName, place, phoneNumber);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

}
