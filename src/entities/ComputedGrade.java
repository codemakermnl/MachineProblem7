package entities;

public class ComputedGrade {

    private double rawGrade;

    private String transmutedGrade;

    private GradeResult gradeResult;

    public ComputedGrade(double rawGrade, String transmutedGrade, GradeResult gradeResult) {
        this.rawGrade = rawGrade;
        this.transmutedGrade = transmutedGrade;
        this.gradeResult = gradeResult;
    }

    public double getRawGrade() {
        return rawGrade;
    }

    public void setRawGrade(double rawGrade) {
        this.rawGrade = rawGrade;
    }

    public String getTransmutedGrade() {
        return transmutedGrade;
    }

    public void setTransmutedGrade(String transmutedGrade) {
        this.transmutedGrade = transmutedGrade;
    }

    public GradeResult getGradeResult() {
        return gradeResult;
    }

    public void setGradeResult(GradeResult gradeResult) {
        this.gradeResult = gradeResult;
    }

    @Override
    public String toString() {
        return "Raw Grade: " + rawGrade + ", Transmuted Grade: " + transmutedGrade + ", Result: " + gradeResult.name();
    }
}
