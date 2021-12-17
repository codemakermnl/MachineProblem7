package services;

import entities.Student;

public class StudentBillingServiceImpl implements StudentBillingService {

    private StudentCourseGradeService studentCourseGradeService;

    public StudentBillingServiceImpl() {
        studentCourseGradeService = new StudentCourseGradeServiceImpl();
    }


    @Override
    public double getBillingAmount(Student student) {
        double totalUnits = studentCourseGradeService.getTotalNumberOfUnits(student);
        int totalSubjects = studentCourseGradeService.getTotalNumberOfSubjects(student);

        return totalUnits * totalSubjects * COURSE_PER_UNIT;
    }
}
