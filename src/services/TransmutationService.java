package services;

import entities.ComputedGrade;

import java.util.HashMap;
import java.util.Map;

public interface TransmutationService {

    Map<String, Double> transmutationTable = new HashMap<>();



    ComputedGrade transmute( double rawGrade );
}
