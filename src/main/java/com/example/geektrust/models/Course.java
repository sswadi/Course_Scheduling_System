package models;

import java.time.LocalDate;
import java.util.*;

public class Course {
	
	private String courseName;
	private String courseInstructor;
	private String courseStartDate;
	private int minEmp;
	private int maxEmp;
	
	public Course(String courseName, String courseInstructor, String courseStartDate, int minEmp, int maxEmp) {
		this.courseName = courseName;
		this.courseInstructor = courseInstructor;
		this.courseStartDate = courseStartDate;
		this.minEmp = minEmp;
		this.maxEmp = maxEmp;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseInstructor() {
		return courseInstructor;
	}

	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}

	public String getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(String courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	public int getMinEmp() {
		return minEmp;
	}

	public void setMinEmp(int minEmp) {
		this.minEmp = minEmp;
	}

	public int getMaxEmp() {
		return maxEmp;
	}

	public void setMaxEmp(int maxEmp) {
		this.maxEmp = maxEmp;
	}
	
	


	
	


}