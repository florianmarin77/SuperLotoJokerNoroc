package com.lafi.sljn.sample.model;

import java.util.Objects;

public class Sample {

    private String datex;

    private Integer number1;

    private Integer number2;

    private Integer number3;

    private Integer number4;

    private Integer number5;

    private Integer number6;

    // constructors

    public Sample() {
        // empty constructor by default
    }

    public Sample(String datex, Integer number1, Integer number2, Integer number3, Integer number4, Integer number5, Integer number6) {
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

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    public Integer getNumber3() {
        return number3;
    }

    public void setNumber3(Integer number3) {
        this.number3 = number3;
    }

    public Integer getNumber4() {
        return number4;
    }

    public void setNumber4(Integer number4) {
        this.number4 = number4;
    }

    public Integer getNumber5() {
        return number5;
    }

    public void setNumber5(Integer number5) {
        this.number5 = number5;
    }

    public Integer getNumber6() {
        return number6;
    }

    public void setNumber6(Integer number6) {
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
