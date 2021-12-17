package entities;

public class CourseTaken extends Course {

    private ComputedGrade computedGrade;

    public CourseTaken(String courseCode, String courseDescription, double numberOfUnits, ComputedGrade computedGrade) {
        super(courseCode, courseDescription, numberOfUnits);
        this.computedGrade = computedGrade;
    }

    public CourseTaken(Course course) {
        super(course.getCourseNumber(), course.getCourseDescription(), course.getNumberOfUnits());
    }

    public ComputedGrade getComputedGrade() {
        return computedGrade;
    }

    public void setComputedGrade(ComputedGrade computedGrade) {
        this.computedGrade = computedGrade;
    }

    @Override
    public String toString() {
        return super.toString() +" " + computedGrade;
    }
}
