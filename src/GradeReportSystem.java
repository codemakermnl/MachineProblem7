import data.GradeLevelData;
import data.SubjectData;
import entities.ComputedGrade;
import entities.Course;
import entities.CourseTaken;
import entities.Student;
import services.*;

import javax.security.auth.Subject;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class GradeReportSystem {

    private static Student student;

    private static final StudentInformationService studentInformationService = new StudentInformationServiceImpl();

    private static final StudentCourseGradeService studentCourseGradeService = new StudentCourseGradeServiceImpl();

    private static final CourseService courseService = new CourseServiceImpl();

    private static final TransmutationService transmutationService = new TransmutationServiceImpl();

    private static final StudentBillingService studentBillingService = new StudentBillingServiceImpl();

    private static final DecimalFormat format = new DecimalFormat("#,###.00");

    public static void main(String[] args) {
        System.out.println("Welcome to the Grades Report System\n");
        Scanner sc = new Scanner(System.in);

        String menu = "\nPlease choose a choice below: \n[A] Set Student Information\n[B] Print Student Information\n[C] Add Course\n[D] Add Course Taken and Grade\n" +
                "[E] View Report Card\n[F] View Tuition\n[G] Exit\n";

        System.out.println(menu);
        System.out.print("Enter choice: ");
        String choice = sc.nextLine().toUpperCase();

        while( !"G".equals(choice) ) {
            switch(choice) {
                case "A":
                    setStudentInformation();
                    break;
                case "B":
                    printStudentInformation();
                    break;
                case "C":
                    addCourse();
                    break;
                case "D":
                    addCourseTakenAndGradeForStudent();
                    break;
                case "E":
                    viewReportCard();
                    break;
                case "F":
                    viewTuition();
                    break;
                default:
                    System.err.println("Invalid choice.");
            }

            System.out.println(menu);
            System.out.print("Enter choice: ");
            choice = sc.nextLine().toUpperCase();
        }
    }

    public static void setStudentInformation() {
        Scanner sc = new Scanner(System.in);

        if( student == null ) {
            student = new Student();
        }

        System.out.print("Enter name: ");
        student.setName( sc.nextLine() );

        System.out.println("Select grade level: ");
        for(int i = 0; i < GradeLevelData.getGradeLevels().length; i++) {
            System.out.println((i+1) + ". " + GradeLevelData.getGradeLevels()[i]);
        }

        int choiceLevel = sc.nextInt();

        if( choiceLevel < 1 || choiceLevel > GradeLevelData.getGradeLevels().length ) {
            System.err.println("Please enter a grade level of 1 to 16 only.");
            return;
        }

        student.setGradeLevel( GradeLevelData.getGradeLevels()[choiceLevel-1] );
        sc.nextLine();

        System.out.print("Enter email: ");
        student.setEmail( sc.nextLine() );

        System.out.println("Student successfully set.");
    }

    public static void printStudentInformation() {
        if( student != null ) {
            studentInformationService.printStudentInformation(student);
            return;
        }

        System.out.println("Student not set yet.");
    }

    public static void addCourse() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter course code: ");
        String courseCode = sc.nextLine();

        System.out.print("Enter course description: ");
        String courseDescription = sc.nextLine();

        System.out.print("Enter number of units: ");
        double numberOfUnits = sc.nextInt();

        courseService.addCourse( new Course(courseCode, courseDescription, numberOfUnits));

        System.out.println("Course successfully added.");
    }

    public static void addCourseTakenAndGradeForStudent() {
        Scanner sc = new Scanner(System.in);
        if( student == null ) {
            System.out.println("Student not yet set");
            return;
        }

        if( SubjectData.getSubjects().isEmpty() ) {
            System.out.println("No courses set.");
            return;
        }

        System.out.println("Select courses: ");
        for(int i = 0; i < SubjectData.getSubjects().size(); i++) {
            System.out.println((i+1) + ". " + SubjectData.getSubjects().get(i));
        }

        int choice = sc.nextInt();

        if( choice < 1 || choice > SubjectData.getSubjects().size() ) {
            System.err.println("Please enter a grade level of 1 to " + SubjectData.getSubjects().size() +" only.");
            return;
        }

        if( student.hasCourse( SubjectData.getSubjects().get(choice-1) ) ) {
            System.err.println("Student already has that course.");
            return;
        }

        CourseTaken courseTaken = new CourseTaken(SubjectData.getSubjects().get(choice-1));

        System.out.print("Enter student grade (60 to 100 only. lowest is 0, highest is 100, passing is 60): ");
        double rawGrade = sc.nextDouble();

        courseTaken.setComputedGrade( transmutationService.transmute(rawGrade) );

        student.addCourse( courseTaken );
        System.out.println("Course successfully added to student");
    }

    public static void viewReportCard() {
        if( student == null ) {
            System.out.println("Student not yet set");
            return;
        }
        showCoursesTaken();
        showTotalUnitsAndSubjects();
        System.out.println("GPA: " + studentCourseGradeService.calculateGPA(student));
    }

    public static void viewTuition() {
        showCoursesTaken();
        showTotalUnitsAndSubjects();;
        System.out.println("Billing Amount: " + format.format(studentBillingService.getBillingAmount(student)));
        System.out.println("Note: 1 unit = PHP 1500");
    }

    private static void showTotalUnitsAndSubjects() {
        System.out.println("Total Number of Subjects: " + studentCourseGradeService.getTotalNumberOfSubjects(student));
        System.out.println("Total Units: " + studentCourseGradeService.getTotalNumberOfUnits(student));
    }

    private static void showCoursesTaken() {
        System.out.println("Courses Taken: ");
        studentCourseGradeService.getCoursesSortedByCourseNumber(student).forEach(c -> System.out.println("\t"+c));
    }
}
