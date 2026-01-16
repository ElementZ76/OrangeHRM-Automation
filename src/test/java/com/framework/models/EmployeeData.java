package com.framework.models;

public class EmployeeData {
	private String firstName;
//	private String middlenName;
	private String lastName;
	private String photoFile;
	
	//constructor required by jackson
	public EmployeeData() {}
	
	public String getFirstName(){ return firstName;}
	public void setFirstName(String fname) {
		this.firstName=fname;
	}
	
//	public String getMiddleName() {
//		return mname;
//	}
//	public void setMiddleName(String mname) {
//		this.mname = mname;
//	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lname) {
		this.lastName = lname;
	}
	
	public String getPhotoFile() { return photoFile; }
    public void setPhotoFile(String photoFile) { this.photoFile = photoFile; }
}
