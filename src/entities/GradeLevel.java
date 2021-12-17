package entities;

public class GradeLevel {

    private int gradeLevelNumber;

    private String gradeLevelCode;

    public GradeLevel(int gradeLevelNumber, String gradeLevelCode) {
        this.gradeLevelNumber = gradeLevelNumber;
        this.gradeLevelCode = gradeLevelCode;
    }

    public int getGradeLevelNumber() {
        return gradeLevelNumber;
    }

    public void setGradeLevelNumber(int gradeLevelNumber) {
        this.gradeLevelNumber = gradeLevelNumber;
    }

    public String getGradeLevelCode() {
        return gradeLevelCode;
    }

    public void setGradeLevelCode(String gradeLevelCode) {
        this.gradeLevelCode = gradeLevelCode;
    }

    @Override
    public String toString() {
        return getGradeLevelCode();
    }
}
