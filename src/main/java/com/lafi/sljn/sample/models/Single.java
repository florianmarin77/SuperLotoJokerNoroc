package com.lafi.sljn.sample.models;

import java.util.Objects;

public class Single {

    // DATEX este data extragerii
    private String datex;

    // INTEX este întregul extragerii
    private String intex1;
    private String intex2;
    private String intex3;
    private String intex4;
    private String intex5;
    private String intex6;

    // CODEX este codificarea extragerii
    private String codex;

    // INDEX este indicativul extragerii
    private String index;

    /* ==================================================> constructors */

    public Single() {
        // empty constructor by default
    }

    public Single(String datex, String intex1, String intex2, String intex3, String intex4, String intex5, String intex6, String codex, String index) {
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

    public String getCodex() {
        return codex;
    }

    public void setCodex(String codex) {
        this.codex = codex;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    /* ==================================================> special methods */

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Single single = (Single) object;
        return intex1.equals(single.intex1) && intex2.equals(single.intex2) && intex3.equals(single.intex3) && intex4.equals(single.intex4) && intex5.equals(single.intex5) && intex6.equals(single.intex6);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intex1, intex2, intex3, intex4, intex5, intex6);
    }

    @Override
    public String toString() {
        return "(" + datex + ")=[" + intex1 + "," + intex2 + "," + intex3 + "," + intex4 + "," + intex5 + "," + intex6 + "]={" + codex + "}=#" + index;
    }
}
