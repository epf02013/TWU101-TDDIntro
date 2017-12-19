package com.thoughtworks.tddintro.exercises.factorial;

public class Factorial {
    public Integer compute(int i) {
        if(i<0) {
            throw new IllegalArgumentException("Argument must be greater than 0");
        }
        else if (i==0 || i==1) {
            return 1;
        }
        else {
            return i*compute(i-1);
        }
    }
}
