package services;

import entities.CourseTaken;
import entities.Student;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentCourseGradeServiceImpl implements  StudentCourseGradeService{


    @Override
    public int getTotalNumberOfSubjects(Student student) {
        return student.getCoursesTaken().size();
    }

    @Override
    public double getTotalNumberOfUnits(Student student) {
        List<CourseTaken> coursesTaken = getCoursesSortedByCourseNumber(student);
        double totalUnits = 0;
        for(CourseTaken courseTaken : coursesTaken) {
            totalUnits += courseTaken.getNumberOfUnits();
        }

        return totalUnits;
    }

    @Override
    public double calculateGPA(Student student) {
        List<CourseTaken> coursesTaken = getCoursesSortedByCourseNumber(student);
        double totalNumericGrade = 0;

        for( CourseTaken courseTaken : coursesTaken ) {
            totalNumericGrade += courseTaken.getNumberOfUnits() * Double.parseDouble(courseTaken.getComputedGrade().getTransmutedGrade());
        }

        return totalNumericGrade / getTotalNumberOfUnits(student);
    }

    @Override
    public List<CourseTaken> getCoursesSortedByCourseNumber(Student student) {
        List<CourseTaken> coursesTaken = student.getCoursesTaken();

        coursesTaken.sort(Comparator.comparing(CourseTaken::getCourseNumber));

        return coursesTaken;
    }
}
