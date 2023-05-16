package dto;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BikeOwner {

	@Id
	private int ownerId;
	private String ownerName;
	private String phoneNumber;
	private String emailId;
	
	@Embedded
	private Bike bike;
	
	
	
	public BikeOwner() {
		super();
	}

	public BikeOwner(int ownerId, String ownerName, String phoneNumber, String emailId, Bike bike) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.bike = bike;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}
	
	
}


//create table bikeOwner
//(
//		ownerId int Primary Key,
//	    ownerName varchar(255),
//	    phoneNumber varchar(255),
//	    emailId varchar(255),
//	    Bike
//);