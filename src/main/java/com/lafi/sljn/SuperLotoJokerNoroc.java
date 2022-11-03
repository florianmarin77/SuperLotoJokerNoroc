package com.lafi.sljn;

import java.util.Arrays;
import java.util.Collections;

public class SuperLotoJokerNoroc {
    public static void main(String[] args) {

        Integer[] intex = {45, 12, 10, 13, 24, 7};
        Integer[] codex = {0, 0, 0, 0, 0};
        Integer[] decada = new Integer[6];
        StringBuilder string = new StringBuilder();

        for (int k = 0; k < 6; k++) {
            decada[k] = intex[k]/10;
            codex[decada[k]]++;
        }

        Arrays.sort(codex, Collections.reverseOrder());

        for (int k = 0; k < 5; k++) {
            if (codex[k] != 0) {
                string.append(codex[k].toString());
            }
        }

        System.out.println(Arrays.toString(codex));
        System.out.println(string);
    }
}
