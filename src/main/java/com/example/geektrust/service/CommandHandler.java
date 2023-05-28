package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import concrete.LearningManagementSystem;
import exception.InvalidInputException;

public class CommandHandler {

    private final LearningManagementSystem lms;

    public CommandHandler(LearningManagementSystem lms) {
        this.lms = lms;
    }

    public void handleCommand(String input) throws InvalidInputException {
		String[] parts = input.split(" ");
		String command = parts[0];

		switch (command) {
		case "ADD-COURSE-OFFERING":
			if(parts.length<6) {
//				throw new InvalidInputException("INPUT_DATA_ERROR");
				System.out.println("INPUT_DATA_ERROR");
			}else {
				String courseName = parts[1];
				String instructor = parts[2];
				//                LocalDate date = LocalDate.parse(parts[3], DateTimeFormatter.ofPattern("ddMMyyyy"));
				String date = parts[3];
				int minEmp = Integer.parseInt(parts[4]);
				int maxEmp = Integer.parseInt(parts[5]);
				String addNewCourseId = lms.createCourseOffering(courseName, instructor, date, minEmp, maxEmp);
				System.out.println(addNewCourseId);
			}

			break;

		case "REGISTER":
			if(parts.length>2) {
				String email = parts[1];
				String offeringId = parts[2];
				int atIndex = email.indexOf('@');
				String name = email.substring(0, atIndex);
				String courseRegistrationID = lms.register(email, offeringId, name);
				System.out.println(courseRegistrationID);
			}
			else {
//				throw new InvalidInputException("INPUT_DATA_ERROR");
				System.out.println("INPUT_DATA_ERROR");
			}
			break;
			

		case "ALLOT":
			String courseId = parts[1];
			lms.courseAllotmentList(courseId);
			break;

		case "CANCEL":
			String courseRegistrationId = parts[1];
			lms.cancelRegistration(courseRegistrationId);
			break;

		default:
			System.out.println("INVALID_COMMAND_ERROR");
			break;
		}
	}
}




