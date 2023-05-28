package models;

import constant.Constants;
import exception.InvalidInputException;

public class Employee {
	
	private String empEmail;
	private String courseId;
	private String empName;
	private String status;
	
	
	public Employee(String empEmail, String courseId, String empName, String status) throws InvalidInputException {
		 if (Constants.VALID_EMAIL_ADDRESS_REGEX.matcher(empEmail).matches()) {
			 this.empEmail = empEmail;
		 }else {
			 throw new InvalidInputException("INPUT_DATA_ERROR");
		 }
		
		this.courseId = courseId;
		this.empName = empName;
		this.status = status;
	}


	public String getEmpEmail() {
		return empEmail;
	}


	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}


	public String getCourseId() {
		return courseId;
	}


	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	


}

