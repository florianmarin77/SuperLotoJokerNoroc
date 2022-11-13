package com.lafi.sljn.components.models;

import java.util.Objects;

public class Sample {

    // DATEX este data extragerii
    private String datex;

    // INTEX este întregul extragerii
    private Integer intex1;
    private Integer intex2;
    private Integer intex3;
    private Integer intex4;
    private Integer intex5;
    private Integer intex6;

    // CODEX este codificarea extragerii
    private String codex;

    // INDEX este indicativul extragerii
    private Integer index;

    /* ==================================================> constructors */

    public Sample() {
        // empty constructor by default
    }

    public Sample(String datex, Integer intex1, Integer intex2, Integer intex3, Integer intex4, Integer intex5, Integer intex6, String codex, Integer index) {
        this.datex = datex;
        this.intex1 = intex1;
        this.intex2 = intex2;
        this.intex3 = intex3;
        this.intex4 = intex4;
        this.intex5 = intex5;
        this.intex6 = intex6;
        this.codex = codex;
        this.index = index;
    }

    /* ==================================================> getters & setters */

    public String getDatex() {
        return datex;
    }

    public void setDatex(String datex) {
        this.datex = datex;
    }

    public Integer getIntex1() {
        return intex1;
    }

    public void setIntex1(Integer intex1) {
        this.intex1 = intex1;
    }

    public Integer getIntex2() {
        return intex2;
    }

    public void setIntex2(Integer intex2) {
        this.intex2 = intex2;
    }

    public Integer getIntex3() {
        return intex3;
    }

    public void setIntex3(Integer intex3) {
        this.intex3 = intex3;
    }

    public Integer getIntex4() {
        return intex4;
    }

    public void setIntex4(Integer intex4) {
        this.intex4 = intex4;
    }

    public Integer getIntex5() {
        return intex5;
    }

    public void setIntex5(Integer intex5) {
        this.intex5 = intex5;
    }

    public Integer getIntex6() {
        return intex6;
    }

    public void setIntex6(Integer intex6) {
        this.intex6 = intex6;
    }

    public String getCodex() {
        return codex;
    }

    public void setCodex(String codex) {
        this.codex = codex;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    /* ==================================================> special methods */

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
        return "(" + datex + ")=[" + intex1 + "," + intex2 + "," + intex3 + "," + intex4 + "," + intex5 + "," + intex6 + "]={" + codex + "}#" + index;
    }
}
