package services;

import entities.CourseTaken;
import entities.Student;

import java.util.List;

public interface StudentCourseGradeService {

    int getTotalNumberOfSubjects( Student student );

    double getTotalNumberOfUnits( Student student );

    double calculateGPA( Student student );

    List<CourseTaken> getCoursesSortedByCourseNumber( Student student );
}
