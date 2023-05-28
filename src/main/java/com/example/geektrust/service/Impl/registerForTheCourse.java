package service.Impl;

import java.util.*;

import exception.InvalidInputException;
import models.Employee;

import java.time.LocalDate;

public class registerForTheCourse {

	public static Map<String,HashMap<String,Employee>> totalCourseList = new HashMap<String, HashMap<String,Employee>>();
	public static HashMap<String, Employee> empListForACourseId = new HashMap<String,Employee>();
	
	
	public static String register(String empEmail, String courseId, String empName) throws InvalidInputException {
		
		//if a course with this id is present
		if(AddCourseOffering.findCourse(courseId)) {
			
			String courseName = AddCourseOffering.getCourseName(courseId); //fetch course name
			String courseStartDate = AddCourseOffering.getCourseStartDate(courseId); //fetch course start date
			LocalDate todaysDate = LocalDate.now(); //fetch today's date
			
			int maxCount = AddCourseOffering.getMaxEmp(courseId);
			int minCount = AddCourseOffering.getMinEmp(courseId);
			int sizeEmp = empListForACourseId.size();
				
//			if the list is empty initially; adds in the first entry
			if(totalCourseList.get(courseId)==null) {
				String crcRegisteredId = createRegisteredId(empName, AddCourseOffering.getCourseName(courseId));
				Employee reg = new Employee(empEmail,courseId, courseName, "ACCEPTED");
				empListForACourseId.put(crcRegisteredId, reg);
				totalCourseList.put(courseId, empListForACourseId);
				return crcRegisteredId+" "+"ACCEPTED";
			}else {
				//if the the min number has not been fulfilled, cancel the course
				// if(sizeEmp<maxCount && sizeEmp+1<minCount) {
				// 	return "COURSE_CANCELED";
				// }
				
				if(sizeEmp==maxCount) {
					return "COURSE_FULL_ERROR";
				}
				
				if(sizeEmp<maxCount) {
					String crcRegisteredId = createRegisteredId(empName, AddCourseOffering.getCourseName(courseId));
					Employee reg = new Employee(empEmail,courseId, courseName, "ACCEPTED");
					empListForACourseId.put(crcRegisteredId, reg);
					totalCourseList.put(courseId, empListForACourseId);
					return crcRegisteredId+" "+"ACCEPTED";
				}
			}
		}
		else {
			System.out.println("The course for the given id could not be found. Please enter a valid course Id");
			return null;
		}
		return "ERROR";

	}
	
	public static String createRegisteredId(String empName, String courseName ) {
		
		return "REG-COURSE-"+empName+"-"+courseName;
	}


}


// public class registerForTheCourse {

// 	public static Map<String,HashMap<String,Employee>> totalCourseList = new HashMap<String, HashMap<String,Employee>>();
// 	public static HashMap<String, Employee> empListForACourseId = new HashMap<String,Employee>();
	
	
// 	public static String register(String empEmail, String courseId, String empName) throws InvalidInputException {
		
// 		//if a course with this id is present
// 		if(AddCourseOffering.findCourse(courseId)) {
			
// 			String courseName = AddCourseOffering.getCourseName(courseId); //fetch course name
// 			String courseStartDate = AddCourseOffering.getCourseStartDate(courseId); //fetch course start date
// 			LocalDate todaysDate = LocalDate.now(); //fetch today's date
			
// 			int maxCount = AddCourseOffering.getMaxEmp(courseId);
// 			int minCount = AddCourseOffering.getMinEmp(courseId);
// 			int sizeEmp = empListForACourseId.size();
				
// //			if the list is empty initially; adds in the first entry
// 			if(totalCourseList.get(courseId)==null) {
			
// 				String crcRegisteredId = createRegisteredId(empName, AddCourseOffering.getCourseName(courseId));
// 				Employee reg = new Employee(empEmail,courseId, courseName, "ACCEPTED");
// 				empListForACourseId.put(crcRegisteredId, reg);
// 				totalCourseList.put(courseId, empListForACourseId);
// 				return crcRegisteredId+" "+"ACCEPTED";
// 			}else {
// //if the the min number has not been fulfilled, cancel the course

// 				if(sizeEmp<maxCount && sizeEmp+1<minCount) {
// 					return "COURSE_CANCELED";
// 				}
				
// 				else if(sizeEmp==maxCount) {
// 					return "COURSE_FULL_ERROR";
// 				}
				
// //				if(sizeEmp<maxCount && courseStartDate.compareTo(todaysDate)>=0) {
// 				if(sizeEmp<maxCount) {
// 					String crcRegisteredId = createRegisteredId(empName, AddCourseOffering.getCourseName(courseId));
// 					Employee reg = new Employee(empEmail,courseId, courseName, "ACCEPTED");
// 					empListForACourseId.put(crcRegisteredId, reg);
// 					totalCourseList.put(courseId, empListForACourseId);
// 					return crcRegisteredId+" "+"ACCEPTED";
// 				}
// 			}
// 		}
// 		else {
// 			System.out.println("The course for the given id could not be found. Please enter a valid course Id");
// 			return null;
// 		}
// 		return "OOPS, THE COURSE HAS ALREADY STARTED!";

// 	}
	
// 	public static String createRegisteredId(String empName, String courseName ) {
		
// 		return "REG-COURSE-"+empName+"-"+courseName;
// 	}


// }







