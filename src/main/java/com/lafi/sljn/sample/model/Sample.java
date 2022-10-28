package com.lafi.sljn.sample.model;

import java.util.Objects;

public class Sample {

    private String datex;

    private String intex1;

    private String intex2;

    private String intex3;

    private String intex4;

    private String intex5;

    private String intex6;

    // constructors

    public Sample() {
        // empty constructor by default
    }

    public Sample(String datex, String intex1, String intex2, String intex3, String intex4, String intex5, String intex6) {
        this.datex = datex;
        this.intex1 = intex1;
        this.intex2 = intex2;
        this.intex3 = intex3;
        this.intex4 = intex4;
        this.intex5 = intex5;
        this.intex6 = intex6;
    }

// getters & setters

    public String getDatex() {
        return datex;
    }

    public void setDatex(String datex) {
        this.datex = datex;
    }

    public String getIntex1() {
        return intex1;
    }

    public void setIntex1(String intex1) {
        this.intex1 = intex1;
    }

    public String getIntex2() {
        return intex2;
    }

    public void setIntex2(String intex2) {
        this.intex2 = intex2;
    }

    public String getIntex3() {
        return intex3;
    }

    public void setIntex3(String intex3) {
        this.intex3 = intex3;
    }

    public String getIntex4() {
        return intex4;
    }

    public void setIntex4(String intex4) {
        this.intex4 = intex4;
    }

    public String getIntex5() {
        return intex5;
    }

    public void setIntex5(String intex5) {
        this.intex5 = intex5;
    }

    public String getIntex6() {
        return intex6;
    }

    public void setIntex6(String intex6) {
        this.intex6 = intex6;
    }

    // special methods

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Sample sample = (Sample) object;
        return intex1.equals(sample.intex1) && intex2.equals(sample.intex2) && intex3.equals(sample.intex3) && intex4.equals(sample.intex4) && intex5.equals(sample.intex5) && intex6.equals(sample.intex6);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intex1, intex2, intex3, intex4, intex5, intex6);
    }

    @Override
    public String toString() {
        return "(" + datex +
                ") => [" + intex1 +
                "," + intex2 +
                "," + intex3 +
                "," + intex4 +
                "," + intex5 +
                "," + intex6 +
                "]";
    }
}
