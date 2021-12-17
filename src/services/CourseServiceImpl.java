package services;

import data.SubjectData;
import entities.Course;

public class CourseServiceImpl implements CourseService {


    @Override
    public void addCourse(Course course) {
        SubjectData.addSubject( course );
    }
}
