package entities;


import java.util.Objects;

public class Course {

    private String courseNumber;

    private String courseDescription;

    private double numberOfUnits;

    public Course(String courseNumber, String courseDescription, double numberOfUnits) {
        this.courseNumber = courseNumber;
        this.courseDescription = courseDescription;
        this.numberOfUnits = numberOfUnits;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public double getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(double numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    @Override
    public String toString() {
        return "Course Number: " + courseNumber + ", Description: " + courseDescription + ", Number of Units: " + numberOfUnits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Course course = (Course) o;
        return Double.compare(course.numberOfUnits, numberOfUnits) == 0 &&
                Objects.equals(courseNumber, course.courseNumber) &&
                Objects.equals(courseDescription, course.courseDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseNumber, courseDescription, numberOfUnits);
    }
}
