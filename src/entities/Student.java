package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student {

    public static final String NO_STRAND = "NO_STRAND";

    public static final String NO_TRACK = "NO_TRACK";

    private String studentNumber = "1000";

    private String name;

    private GradeLevel gradeLevel;

    private String email;

    private List<CourseTaken> coursesTaken = new ArrayList<>();

    public Student(String studentNumber, String name, GradeLevel gradeLevel,String email) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.email = email;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(GradeLevel gradeLevel) {
        this.gradeLevel = gradeLevel;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CourseTaken> getCoursesTaken() {
        List<CourseTaken> courseTakenTemp = new ArrayList<>(coursesTaken);
        courseTakenTemp.sort(Comparator.comparing(CourseTaken::getCourseNumber));
        return courseTakenTemp;
    }

    public void setCoursesTaken(List<CourseTaken> coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    public boolean hasCourse(Course course) {
        for( Course courseTaken : coursesTaken ) {
            if( course.equals(courseTaken) ) {
                return true;
            }
        }

        return false;
    }

    public void addCourse( CourseTaken courseTaken ) {
        coursesTaken.add( courseTaken );
    }

    @Override
    public String toString() {
        return "StudentNumber: " + studentNumber +
                ", Name: " + name +
                ", Grade Level: " + gradeLevel +
                ", Email: " + email ;
    }
}
