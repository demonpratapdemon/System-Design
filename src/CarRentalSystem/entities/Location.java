package CarRentalSystem.entities;

public class Location {
	private String state;
	private String city;
	private String address;
	private String pincode;
	private String country;

	public Location(String state, String city, String address, String pincode, String country) {
		this.state = state;
		this.city = city;
		this.address = address;
		this.pincode = pincode;
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getAddress() {
		return address;
	}

	public String getPincode() {
		return pincode;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return address + ", " + city + ", " + state + " - " + pincode + ", " + country;
	}
}
