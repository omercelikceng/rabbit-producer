package com.example.batch.data;

import java.io.Serializable;

public class ExampleData implements Serializable {
    private double xx = 0.0;


    public ExampleData() {
    }

    public ExampleData(double xx) {
        this.xx = xx;
    }


    public double getXx() {
        return xx;
    }
}

