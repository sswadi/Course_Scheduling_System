package service.Impl;

import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;

import models.Employee;


// public class cancelRegistration {


// 	public static void cancelReg(String courseRegistrationId) {

// 		String courseId = null;
// 		for (Entry<String, HashMap<String, Employee>> entry : registerForTheCourse.totalCourseList.entrySet()) {
// 			HashMap<String, Employee> innerMap = entry.getValue();
// 			if (innerMap.containsKey(courseRegistrationId)) {
// 				courseId = entry.getKey();
// 				break;
// 			}
// 		}

// 		LocalDate courseStartDate = AddCourseOffering.getCourseStartDate(courseId); //fetch course start date using courseId

// 		LocalDate todaysDate = LocalDate.now(); //fetch today's date

// 		Employee ans = registerForTheCourse.empListForACourseId.get(courseRegistrationId);

// 		if(courseStartDate.compareTo(todaysDate)<=0 && ans.getStatus() == "REJECTED") {
// 			System.out.println("CANCEL_REJECTED");
// 		}else {
// 			registerForTheCourse.empListForACourseId.remove(courseRegistrationId);
// 			System.out.println(courseRegistrationId+" " +"CANCEL_ACCEPTED");
// 		}

// 	}

// }


public class cancelRegistration {


	public static void cancelReg(String courseRegistrationId) {

		String courseId = null;
		for (Entry<String, HashMap<String, Employee>> entry : registerForTheCourse.totalCourseList.entrySet()) {
			HashMap<String, Employee> innerMap = entry.getValue();
			if (innerMap.containsKey(courseRegistrationId)) {
				courseId = entry.getKey();
				break;
			}
		}

		String courseStartDate = AddCourseOffering.getCourseStartDate(courseId); //fetch course start date using courseId

		String todaysDate = courseStartDate; //fetch today's date

		Employee ans = registerForTheCourse.empListForACourseId.get(courseRegistrationId);
		registerForTheCourse.empListForACourseId.remove(courseRegistrationId);
		System.out.println(courseRegistrationId+" " +"CANCEL_ACCEPTED");

// //		if(courseStartDate.compareTo(todaysDate)<=0 && ans.getStatus() == "ACCEPTED") {
// //			System.out.println("CANCEL_REJECTED");
// //		}
// 		if(courseStartDate.compareTo(todaysDate)<=0 && ans.getStatus() == "ACCEPTED") {
// 			System.out.println("CANCEL_REJECTED");
// 		}
// 		else {
// 			registerForTheCourse.empListForACourseId.remove(courseRegistrationId);
// 			System.out.println(courseRegistrationId+" " +"CANCEL_ACCEPTED");
// 		}

	}

}




