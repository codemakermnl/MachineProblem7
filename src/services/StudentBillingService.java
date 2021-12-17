package services;

import entities.Student;

public interface StudentBillingService {

    double COURSE_PER_UNIT = 1500;

    double getBillingAmount(Student student);
}
