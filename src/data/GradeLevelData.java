package data;

import entities.GradeLevel;

import java.util.Arrays;

public class GradeLevelData {

    private static final GradeLevel[] gradeLevels = {
            new GradeLevel(1, "Grade 1"),
            new GradeLevel(2, "Grade 2"),
            new GradeLevel(3, "Grade 3"),
            new GradeLevel(4, "Grade 4"),
            new GradeLevel(5, "Grade 5"),
            new GradeLevel(6, "Grade 6"),
            new GradeLevel(7, "Grade 7"),
            new GradeLevel(8, "Grade 8"),
            new GradeLevel(9, "Grade 9"),
            new GradeLevel(10, "Grade 10"),
            new GradeLevel(11, "Grade 11"),
            new GradeLevel(12, "Grade 12"),
            new GradeLevel(13, "First Year College"),
            new GradeLevel(14, "Second Year College"),
            new GradeLevel(15, "Third Year College"),
            new GradeLevel(16, "Fourth Year College")
    };

    public static GradeLevel[] getGradeLevels() {
        return Arrays.copyOf(gradeLevels, gradeLevels.length);
    }
}
