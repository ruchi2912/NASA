package rationalcoe;
public class ProjectDetailsDTO {
	/*
	 * Edited by Rational COE
	 */
	int Id;
	String Name;
	String Address;
	String Contact;
	String DOB;
	String State;
	String City;
	String PIN;
	
	public int getId(){
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String accountName) {
		this.Name=accountName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String clientName) {
		this.Address = clientName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String isuName) {
		this.City = isuName;
	}
	public String getState() {
		return State;
	}
	public void setState(String loc) {
		this.State = loc;
	}
	public String getPIN() {
		return PIN;
	}
	public void setPIN(String plContactNum) {
		this.PIN = plContactNum;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String plName) {
		this.DOB = plName;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String prjEndDate) {
		this.Contact = prjEndDate;
	}
	

		}


