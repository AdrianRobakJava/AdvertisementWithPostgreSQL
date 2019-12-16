package pl.alx.kpij.Ogloszenia;

public class Advertisement {
	
	private String type, title, place, description, phoneNumber;
	private int id, counter;
	private double price;
	
	public Advertisement() {
		
	}
	
	public Advertisement(String type, String title, String place, double price, String phoneNumber) {
		this.title = title;
		this.place = place;
		setPrice(price);
		setPhoneNumber(phoneNumber);
		//counter++;
		//id = counter;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s w miejscowości %s za %.2fzł. Mój numer to: %s.\n%s\n", type, title, place, price, phoneNumber, description);
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
