package com.lafi.sljn.sample.model;

import java.util.Objects;

public class Sample {

    private String datex;

    private String number1;

    private String number2;

    private String number3;

    private String number4;

    private String number5;

    private String number6;

    // constructors

    public Sample() {
        // empty constructor by default
    }


    public Sample(String datex, String number1, String number2, String number3, String number4, String number5, String number6) {
        this.datex = datex;
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.number4 = number4;
        this.number5 = number5;
        this.number6 = number6;
    }

// getters & setters

    public String getDatex() {
        return datex;
    }

    public void setDatex(String datex) {
        this.datex = datex;
    }

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public String getNumber3() {
        return number3;
    }

    public void setNumber3(String number3) {
        this.number3 = number3;
    }

    public String getNumber4() {
        return number4;
    }

    public void setNumber4(String number4) {
        this.number4 = number4;
    }

    public String getNumber5() {
        return number5;
    }

    public void setNumber5(String number5) {
        this.number5 = number5;
    }

    public String getNumber6() {
        return number6;
    }

    public void setNumber6(String number6) {
        this.number6 = number6;
    }

    // special methods

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Sample sample = (Sample) object;
        return number1.equals(sample.number1) && number2.equals(sample.number2) && number3.equals(sample.number3) && number4.equals(sample.number4) && number5.equals(sample.number5) && number6.equals(sample.number6);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number1, number2, number3, number4, number5, number6);
    }

    @Override
    public String toString() {
        return "(" + datex +
                ") => [" + number1 +
                "," + number2 +
                "," + number3 +
                "," + number4 +
                "," + number5 +
                "," + number6 +
                "]";
    }
}
