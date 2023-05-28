package service.Impl;

import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;

import models.Employee;

public class courseAllotment {
	
	
// 	public static void courseAllotmentList(String courseId) {
		
// 		if(registerForTheCourse.totalCourseList.containsKey(courseId)) {
			
// 			String courseName = AddCourseOffering.getCourseName(courseId);
// 			String instructor = AddCourseOffering.getCourseInstructor(courseId);
// 			LocalDate startDate = AddCourseOffering.getCourseStartDate(courseId);
// 			HashMap<String, Employee> ans = registerForTheCourse.totalCourseList.get(courseId);

// 			for(Entry<String, Employee> entry: ans.entrySet()) {
				
// 				if(entry.getValue().getCourseId().equals(courseId)) {
// 					String courseRegistrationId = entry.getKey();
// //					registerForTheCourse registerForTheCourseObj = entry.getValue().empListForACourseId.get(courseRegistrationId);
// 					Employee registerForTheCourseObj = entry.getValue();
// 					String email = registerForTheCourseObj.getEmpEmail();
// 					String status = registerForTheCourseObj.getStatus();
// 					if(status == "ACCEPTED"){
// 						status = "CONFIRMED";
// 					}else{
// 						status = "NOT CONFIRMED"
// 					}
// 					System.out.println(courseRegistrationId+" "+email+" "+courseId+" "+courseName+" "+instructor+" "+startDate+" "+status);
// 				}	
// 			}
// 		}else {
// 			System.out.println("No list");
// 		}
	
// 	}
	
// }


//The below code is correct but needs to be edited in order to print entries in last in first out order
//****************************************************************************************** */
// public class courseAllotment {
	
	
// 	public static void courseAllotmentList(String courseId) {
		
// 		if(registerForTheCourse.totalCourseList.containsKey(courseId)) {
			
// 			String courseName = AddCourseOffering.getCourseName(courseId);
// 			String instructor = AddCourseOffering.getCourseInstructor(courseId);
// 			String startDate = AddCourseOffering.getCourseStartDate(courseId);
// 			HashMap<String, Employee> ans = registerForTheCourse.totalCourseList.get(courseId);

// 			for(Entry<String, Employee> entry: ans.entrySet()) {
				
// 				if(entry.getValue().getCourseId().equals(courseId)) {
// 					String courseRegistrationId = entry.getKey();
// //					registerForTheCourse registerForTheCourseObj = entry.getValue().empListForACourseId.get(courseRegistrationId);
// 					Employee registerForTheCourseObj = entry.getValue();
// 					String email = registerForTheCourseObj.getEmpEmail();
// 					// String status = registerForTheCourseObj.getStatus();
// 					String status;
// 	                if(size>minEmp) {
// 	                	status = "ACCEPTED";
// 	                }else {
// 	                	status = "COURSE_CANCELED";
// 	                }
	                
// 	                System.out.println(courseRegistrationId + " " + email + " " + courseId + " " + courseName + " " + instructor + " " + startDate + " " +status);
// 	            }
// 			}
// 		}else {
// 			System.out.println("No list");
// 		}
	
// 	}
	
// }

//****************************************************************************************** */

//LIFO ORDER

// public static void courseAllotmentList(String courseId) {
// 	    if (registerForTheCourse.totalCourseList.containsKey(courseId)) {
// 	        String courseName = AddCourseOffering.getCourseName(courseId);
// 	        String instructor = AddCourseOffering.getCourseInstructor(courseId);
// 	        String startDate = AddCourseOffering.getCourseStartDate(courseId);
// 	        HashMap<String, Employee> ans = registerForTheCourse.totalCourseList.get(courseId);
	        
// 	        LinkedList<Entry<String, Employee>> reversedEntries = new LinkedList<>(ans.entrySet());
	        
// 	        ListIterator<Entry<String, Employee>> iterator = reversedEntries.listIterator(reversedEntries.size());
	        
// 	        while (iterator.hasPrevious()) {
// 	            Entry<String, Employee> entry = iterator.previous();
	            
// 	            if (entry.getValue().getCourseId().equals(courseId)) {
// 	                String courseRegistrationId = entry.getKey();
// 	                Employee registerForTheCourseObj = entry.getValue();
// 	                String email = registerForTheCourseObj.getEmpEmail();
// 	                String status = registerForTheCourseObj.getStatus();
	                
// 	                System.out.println(courseRegistrationId + " " + email + " " + courseId + " " + courseName + " " + instructor + " " + startDate + " " + "CONFIRMED");
// 	            }
// 	        }
// 	    } else {
// 	        System.out.println("No list");
// 	    }
// 	}
// 


//-----------------------------------------

public static void courseAllotmentList(String courseId) {
		  if (registerForTheCourse.totalCourseList.containsKey(courseId)) {
		        String courseName = AddCourseOffering.getCourseName(courseId);
		        String instructor = AddCourseOffering.getCourseInstructor(courseId);
		        String startDate = AddCourseOffering.getCourseStartDate(courseId);
		        HashMap<String, Employee> ans = registerForTheCourse.totalCourseList.get(courseId);
		        int minEmp = AddCourseOffering.getMinEmp(courseId);
		        int size = ans.size();

		        List<Map.Entry<String, Employee>> sortedEntries = new ArrayList<>(ans.entrySet());
		        Collections.sort(sortedEntries, new Comparator<Map.Entry<String, Employee>>() {
		            @Override
		            public int compare(Map.Entry<String, Employee> entry1, Map.Entry<String, Employee> entry2) {
		                return entry1.getKey().compareTo(entry2.getKey());
		            }
		        });

		        for (Map.Entry<String, Employee> entry : sortedEntries) {
		            if (entry.getValue().getCourseId().equals(courseId)) {
		                String courseRegistrationId = entry.getKey();
		                Employee registerForTheCourseObj = entry.getValue();
		                String email = registerForTheCourseObj.getEmpEmail();
		                String status;
		                if (size > minEmp) {
		                    status = "CONFIRMED";
		                } else {
		                    status = "COURSE_CANCELED";
		                }

		                System.out.println(courseRegistrationId + " " + email + " " + courseId + " " + courseName + " " + instructor + " " + startDate + " " + status);
		            }
		        }
		    } else {
		        System.out.println("No list");
		    }
	}
	
}

	