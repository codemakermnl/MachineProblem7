package services;

import entities.ComputedGrade;
import entities.GradeResult;

public class TransmutationServiceImpl implements TransmutationService {


    @Override
    public ComputedGrade transmute(double rawGrade) {
        String transmuted = "";
        if( rawGrade <= 60 ) {
            transmuted = "1.0";
        }else if( rawGrade >= 60 && rawGrade < 65 ) {
            transmuted = "2.0";
        }else if( rawGrade >= 65 && rawGrade < 68 ) {
            transmuted = "2.25";
        }else if( rawGrade >= 68 && rawGrade < 70) {
            transmuted = "2.5";
        }else if( rawGrade >= 70 && rawGrade < 75 ) {
            transmuted = "2.75";
        }else if( rawGrade >= 75 && rawGrade < 80 ) {
            transmuted = "3.0";
        }else if( rawGrade >= 80 && rawGrade < 85 ) {
            transmuted = "3.25";
        }else if( rawGrade >= 85 && rawGrade < 90 ) {
            transmuted = "3.5";
        }else if( rawGrade >= 90 && rawGrade < 95 ) {
            transmuted = "3.75";
        }else {
            transmuted = "4.0";
        }

        GradeResult result = rawGrade > 60 ? GradeResult.PASS : GradeResult.FAIL;

        return new ComputedGrade(rawGrade, transmuted, result);
    }
}
