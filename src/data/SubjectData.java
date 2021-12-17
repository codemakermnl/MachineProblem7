package data;

import entities.Course;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

public class SubjectData {

    private static final List<Course> courses = new ArrayList<>();

    public static void addSubject( Course course ) {
        courses.add( course );
    }

    public static List<Course> getSubjects() {
        return new ArrayList<>(courses);
    }
}
