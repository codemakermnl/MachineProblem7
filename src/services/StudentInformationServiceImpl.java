package services;

import data.GradeLevelData;
import entities.GradeLevel;
import entities.Student;

public class StudentInformationServiceImpl implements  StudentInformationService {



    @Override
    public void printStudentInformation(Student student) {
        System.out.println(student);
    }

}
