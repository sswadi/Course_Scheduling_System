package concrete;
import java.time.LocalDate;

import exception.InvalidInputException;
import service.Impl.AddCourseOffering;
import service.Impl.courseAllotment;
import service.Impl.registerForTheCourse;
import service.Impl.cancelRegistration;

public class LearningManagementSystem {

    public String createCourseOffering(String courseName, String instructor, String date, int minEmp, int maxEmp) {
        // Implementation for creating a course offering
        String addNewCourseId = AddCourseOffering.createCourseOffering(courseName, instructor, date, minEmp, maxEmp);
        return addNewCourseId;
    }

    public String register(String email, String offeringId, String name) throws InvalidInputException {
        // Implementation for registering a student
        String courseRegistrationID = registerForTheCourse.register(email, offeringId, name);
        return courseRegistrationID;
    }

    public void courseAllotmentList(String courseId) {
        // Implementation for course allotment
        courseAllotment.courseAllotmentList(courseId);
    }

    public void cancelRegistration(String courseRegistrationId) {
//        Object cancelRegistration;
		// Implementation for canceling a registration
        cancelRegistration.cancelReg(courseRegistrationId);
    }
}

