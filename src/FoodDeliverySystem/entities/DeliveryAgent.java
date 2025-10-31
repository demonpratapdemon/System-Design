package FoodDeliverySystem.entities;

import java.util.UUID;

public class DeliveryAgent {
	private String agentId;
	private String agentName;
	private boolean isAvailable;
	private double latitude;
	private double longitude;
	private int completedDeliveries;

	public DeliveryAgent(String agentName, double latitude, double longitude) {
		this.agentId = UUID.randomUUID().toString();
		this.agentName = agentName;
		this.isAvailable = true;
		this.latitude = latitude;
		this.longitude = longitude;
		this.completedDeliveries = 0;
	}

	public String getAgentId() {
		return agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getCompletedDeliveries() {
		return completedDeliveries;
	}

	public void incrementDeliveries() {
		this.completedDeliveries++;
	}
}
