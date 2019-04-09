package com.abhi.microservices.limitsservice.beans;

/**
 * Created by Abhinav on 4/1/2019.
 */
public class LimitConfiguration {
    private int max;
    private int min;

    protected LimitConfiguration() {
    }

    public LimitConfiguration(int max, int min) {
        this.max = max;
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}
