package CarRentalSystem.entities;

import java.util.UUID;

public class User {
	private String userId;
	private String userName;
	private String licenseNo;
	private String phone;
	private Location userLocation;

	public User(String userName, String licenseNo, String phone, Location userLocation) {
		this.userId = UUID.randomUUID().toString();
		this.userName = userName;
		this.licenseNo = licenseNo;
		this.phone = phone;
		this.userLocation = userLocation;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public String getPhone() {
		return phone;
	}

	public Location getUserLocation() {
		return userLocation;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", licenseNo=" + licenseNo + ", phone=" + phone
				+ ", userLocation=" + userLocation + "]";
	}

}
