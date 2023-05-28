package service.Impl;

import java.time.LocalDate;
import java.util.*;

import models.Course;


public class AddCourseOffering {
	

	public static Map<String, Course> courseList = new HashMap<>();
	

	public static int getMinEmp(String id) {
		return courseList.get(id).getMinEmp();
	}

	public static String getCourseStartDate(String id) {
		return courseList.get(id).getCourseStartDate();
	}

	public static int getMaxEmp(String id) {
		return courseList.get(id).getMaxEmp();
	}
	
	public static String getCourseInstructor(String id) {
		return courseList.get(id).getCourseInstructor();
	}

	public static String getCourseName(String id) {
		return AddCourseOffering.findCourseUsingId(id).getCourseName();
	}
	
	public Map<String, Course> getCourseList() {
		return courseList;
	}
	
	public static boolean findCourse(String id) {
		
		if(courseList.containsKey(id)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static Course findCourseUsingId(String id) {
		
		if(courseList.containsKey(id)) {
			return courseList.get(id);
		}else {
			return null;
		}
	}

	public void setCourseList(Map<String, Course> courseList) {
		this.courseList = courseList;
	}

	private static String createCourseId(String courseName, String courseInstructor) {
		return "OFFERING-"+courseName+"-"+courseInstructor;
	}
	
	//starting point
	public static String createCourseOffering(String courseName,String courseInstructor,String courseStartDate,int minEmp,int maxEmp) {

        Course addCourse = new Course(courseName, courseInstructor, courseStartDate, minEmp, maxEmp);

        String courseId = createCourseId(addCourse.getCourseName(), addCourse.getCourseInstructor());
		courseList.put(courseId, addCourse);
		return courseId;
		
	}
	
	

}