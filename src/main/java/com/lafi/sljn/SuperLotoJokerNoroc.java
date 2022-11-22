package com.lafi.sljn;

import com.lafi.sljn.internal.database.SuperDatabase;
import com.lafi.sljn.internal.model.Sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuperLotoJokerNoroc {

    public static final SuperDatabase SUPERDB = SuperDatabase.getInstance();

    public static void main(String[] args) {
        SuperDatabase.loadResource();

        List<Sample> samples = SUPERDB.getSamples();

        Integer[] frequencies = new Integer[40];
        for (int k = 0; k < 40; k++) {
            frequencies[k] = 0;
        }

        for (Sample item : samples) {
            // INTEX 1
            switch (item.getIntex1()) {
                case 1: {
                    frequencies[0]++;
                }
                break;
                case 2: {
                    frequencies[1]++;
                }
                break;
                case 3: {
                    frequencies[2]++;
                }
                break;
                case 4: {
                    frequencies[3]++;
                }
                break;
                case 5: {
                    frequencies[4]++;
                }
                break;
                case 6: {
                    frequencies[5]++;
                }
                break;
                case 7: {
                    frequencies[6]++;
                }
                break;
                case 8: {
                    frequencies[7]++;
                }
                break;
                case 9: {
                    frequencies[8]++;
                }
                break;
                case 10: {
                    frequencies[9]++;
                }
                break;
                case 11: {
                    frequencies[10]++;
                }
                break;
                case 12: {
                    frequencies[11]++;
                }
                break;
                case 13: {
                    frequencies[12]++;
                }
                break;
                case 14: {
                    frequencies[13]++;
                }
                break;
                case 15: {
                    frequencies[14]++;
                }
                break;
                case 16: {
                    frequencies[15]++;
                }
                break;
                case 17: {
                    frequencies[16]++;
                }
                break;
                case 18: {
                    frequencies[17]++;
                }
                break;
                case 19: {
                    frequencies[18]++;
                }
                break;
                case 20: {
                    frequencies[19]++;
                }
                break;
                case 21: {
                    frequencies[20]++;
                }
                break;
                case 22: {
                    frequencies[21]++;
                }
                break;
                case 23: {
                    frequencies[22]++;
                }
                break;
                case 24: {
                    frequencies[23]++;
                }
                break;
                case 25: {
                    frequencies[24]++;
                }
                break;
                case 26: {
                    frequencies[25]++;
                }
                break;
                case 27: {
                    frequencies[26]++;
                }
                break;
                case 28: {
                    frequencies[27]++;
                }
                break;
                case 29: {
                    frequencies[28]++;
                }
                break;
                case 30: {
                    frequencies[29]++;
                }
                break;
                case 31: {
                    frequencies[30]++;
                }
                break;
                case 32: {
                    frequencies[31]++;
                }
                break;
                case 33: {
                    frequencies[32]++;
                }
                break;
                case 34: {
                    frequencies[33]++;
                }
                break;
                case 35: {
                    frequencies[34]++;
                }
                break;
                case 36: {
                    frequencies[35]++;
                }
                break;
                case 37: {
                    frequencies[36]++;
                }
                break;
                case 38: {
                    frequencies[37]++;
                }
                break;
                case 39: {
                    frequencies[38]++;
                }
                break;
                case 40: {
                    frequencies[39]++;
                }
                break;
            }

            // INTEX 2
            switch (item.getIntex2()) {
                case 1: {
                    frequencies[0]++;
                }
                break;
                case 2: {
                    frequencies[1]++;
                }
                break;
                case 3: {
                    frequencies[2]++;
                }
                break;
                case 4: {
                    frequencies[3]++;
                }
                break;
                case 5: {
                    frequencies[4]++;
                }
                break;
                case 6: {
                    frequencies[5]++;
                }
                break;
                case 7: {
                    frequencies[6]++;
                }
                break;
                case 8: {
                    frequencies[7]++;
                }
                break;
                case 9: {
                    frequencies[8]++;
                }
                break;
                case 10: {
                    frequencies[9]++;
                }
                break;
                case 11: {
                    frequencies[10]++;
                }
                break;
                case 12: {
                    frequencies[11]++;
                }
                break;
                case 13: {
                    frequencies[12]++;
                }
                break;
                case 14: {
                    frequencies[13]++;
                }
                break;
                case 15: {
                    frequencies[14]++;
                }
                break;
                case 16: {
                    frequencies[15]++;
                }
                break;
                case 17: {
                    frequencies[16]++;
                }
                break;
                case 18: {
                    frequencies[17]++;
                }
                break;
                case 19: {
                    frequencies[18]++;
                }
                break;
                case 20: {
                    frequencies[19]++;
                }
                break;
                case 21: {
                    frequencies[20]++;
                }
                break;
                case 22: {
                    frequencies[21]++;
                }
                break;
                case 23: {
                    frequencies[22]++;
                }
                break;
                case 24: {
                    frequencies[23]++;
                }
                break;
                case 25: {
                    frequencies[24]++;
                }
                break;
                case 26: {
                    frequencies[25]++;
                }
                break;
                case 27: {
                    frequencies[26]++;
                }
                break;
                case 28: {
                    frequencies[27]++;
                }
                break;
                case 29: {
                    frequencies[28]++;
                }
                break;
                case 30: {
                    frequencies[29]++;
                }
                break;
                case 31: {
                    frequencies[30]++;
                }
                break;
                case 32: {
                    frequencies[31]++;
                }
                break;
                case 33: {
                    frequencies[32]++;
                }
                break;
                case 34: {
                    frequencies[33]++;
                }
                break;
                case 35: {
                    frequencies[34]++;
                }
                break;
                case 36: {
                    frequencies[35]++;
                }
                break;
                case 37: {
                    frequencies[36]++;
                }
                break;
                case 38: {
                    frequencies[37]++;
                }
                break;
                case 39: {
                    frequencies[38]++;
                }
                break;
                case 40: {
                    frequencies[39]++;
                }
                break;
            }

            // INTEX 3
            switch (item.getIntex3()) {
                case 1: {
                    frequencies[0]++;
                }
                break;
                case 2: {
                    frequencies[1]++;
                }
                break;
                case 3: {
                    frequencies[2]++;
                }
                break;
                case 4: {
                    frequencies[3]++;
                }
                break;
                case 5: {
                    frequencies[4]++;
                }
                break;
                case 6: {
                    frequencies[5]++;
                }
                break;
                case 7: {
                    frequencies[6]++;
                }
                break;
                case 8: {
                    frequencies[7]++;
                }
                break;
                case 9: {
                    frequencies[8]++;
                }
                break;
                case 10: {
                    frequencies[9]++;
                }
                break;
                case 11: {
                    frequencies[10]++;
                }
                break;
                case 12: {
                    frequencies[11]++;
                }
                break;
                case 13: {
                    frequencies[12]++;
                }
                break;
                case 14: {
                    frequencies[13]++;
                }
                break;
                case 15: {
                    frequencies[14]++;
                }
                break;
                case 16: {
                    frequencies[15]++;
                }
                break;
                case 17: {
                    frequencies[16]++;
                }
                break;
                case 18: {
                    frequencies[17]++;
                }
                break;
                case 19: {
                    frequencies[18]++;
                }
                break;
                case 20: {
                    frequencies[19]++;
                }
                break;
                case 21: {
                    frequencies[20]++;
                }
                break;
                case 22: {
                    frequencies[21]++;
                }
                break;
                case 23: {
                    frequencies[22]++;
                }
                break;
                case 24: {
                    frequencies[23]++;
                }
                break;
                case 25: {
                    frequencies[24]++;
                }
                break;
                case 26: {
                    frequencies[25]++;
                }
                break;
                case 27: {
                    frequencies[26]++;
                }
                break;
                case 28: {
                    frequencies[27]++;
                }
                break;
                case 29: {
                    frequencies[28]++;
                }
                break;
                case 30: {
                    frequencies[29]++;
                }
                break;
                case 31: {
                    frequencies[30]++;
                }
                break;
                case 32: {
                    frequencies[31]++;
                }
                break;
                case 33: {
                    frequencies[32]++;
                }
                break;
                case 34: {
                    frequencies[33]++;
                }
                break;
                case 35: {
                    frequencies[34]++;
                }
                break;
                case 36: {
                    frequencies[35]++;
                }
                break;
                case 37: {
                    frequencies[36]++;
                }
                break;
                case 38: {
                    frequencies[37]++;
                }
                break;
                case 39: {
                    frequencies[38]++;
                }
                break;
                case 40: {
                    frequencies[39]++;
                }
                break;
            }

            // INTEX 4
            switch (item.getIntex4()) {
                case 1: {
                    frequencies[0]++;
                }
                break;
                case 2: {
                    frequencies[1]++;
                }
                break;
                case 3: {
                    frequencies[2]++;
                }
                break;
                case 4: {
                    frequencies[3]++;
                }
                break;
                case 5: {
                    frequencies[4]++;
                }
                break;
                case 6: {
                    frequencies[5]++;
                }
                break;
                case 7: {
                    frequencies[6]++;
                }
                break;
                case 8: {
                    frequencies[7]++;
                }
                break;
                case 9: {
                    frequencies[8]++;
                }
                break;
                case 10: {
                    frequencies[9]++;
                }
                break;
                case 11: {
                    frequencies[10]++;
                }
                break;
                case 12: {
                    frequencies[11]++;
                }
                break;
                case 13: {
                    frequencies[12]++;
                }
                break;
                case 14: {
                    frequencies[13]++;
                }
                break;
                case 15: {
                    frequencies[14]++;
                }
                break;
                case 16: {
                    frequencies[15]++;
                }
                break;
                case 17: {
                    frequencies[16]++;
                }
                break;
                case 18: {
                    frequencies[17]++;
                }
                break;
                case 19: {
                    frequencies[18]++;
                }
                break;
                case 20: {
                    frequencies[19]++;
                }
                break;
                case 21: {
                    frequencies[20]++;
                }
                break;
                case 22: {
                    frequencies[21]++;
                }
                break;
                case 23: {
                    frequencies[22]++;
                }
                break;
                case 24: {
                    frequencies[23]++;
                }
                break;
                case 25: {
                    frequencies[24]++;
                }
                break;
                case 26: {
                    frequencies[25]++;
                }
                break;
                case 27: {
                    frequencies[26]++;
                }
                break;
                case 28: {
                    frequencies[27]++;
                }
                break;
                case 29: {
                    frequencies[28]++;
                }
                break;
                case 30: {
                    frequencies[29]++;
                }
                break;
                case 31: {
                    frequencies[30]++;
                }
                break;
                case 32: {
                    frequencies[31]++;
                }
                break;
                case 33: {
                    frequencies[32]++;
                }
                break;
                case 34: {
                    frequencies[33]++;
                }
                break;
                case 35: {
                    frequencies[34]++;
                }
                break;
                case 36: {
                    frequencies[35]++;
                }
                break;
                case 37: {
                    frequencies[36]++;
                }
                break;
                case 38: {
                    frequencies[37]++;
                }
                break;
                case 39: {
                    frequencies[38]++;
                }
                break;
                case 40: {
                    frequencies[39]++;
                }
                break;
            }

            // INTEX 5
            switch (item.getIntex5()) {
                case 1: {
                    frequencies[0]++;
                }
                break;
                case 2: {
                    frequencies[1]++;
                }
                break;
                case 3: {
                    frequencies[2]++;
                }
                break;
                case 4: {
                    frequencies[3]++;
                }
                break;
                case 5: {
                    frequencies[4]++;
                }
                break;
                case 6: {
                    frequencies[5]++;
                }
                break;
                case 7: {
                    frequencies[6]++;
                }
                break;
                case 8: {
                    frequencies[7]++;
                }
                break;
                case 9: {
                    frequencies[8]++;
                }
                break;
                case 10: {
                    frequencies[9]++;
                }
                break;
                case 11: {
                    frequencies[10]++;
                }
                break;
                case 12: {
                    frequencies[11]++;
                }
                break;
                case 13: {
                    frequencies[12]++;
                }
                break;
                case 14: {
                    frequencies[13]++;
                }
                break;
                case 15: {
                    frequencies[14]++;
                }
                break;
                case 16: {
                    frequencies[15]++;
                }
                break;
                case 17: {
                    frequencies[16]++;
                }
                break;
                case 18: {
                    frequencies[17]++;
                }
                break;
                case 19: {
                    frequencies[18]++;
                }
                break;
                case 20: {
                    frequencies[19]++;
                }
                break;
                case 21: {
                    frequencies[20]++;
                }
                break;
                case 22: {
                    frequencies[21]++;
                }
                break;
                case 23: {
                    frequencies[22]++;
                }
                break;
                case 24: {
                    frequencies[23]++;
                }
                break;
                case 25: {
                    frequencies[24]++;
                }
                break;
                case 26: {
                    frequencies[25]++;
                }
                break;
                case 27: {
                    frequencies[26]++;
                }
                break;
                case 28: {
                    frequencies[27]++;
                }
                break;
                case 29: {
                    frequencies[28]++;
                }
                break;
                case 30: {
                    frequencies[29]++;
                }
                break;
                case 31: {
                    frequencies[30]++;
                }
                break;
                case 32: {
                    frequencies[31]++;
                }
                break;
                case 33: {
                    frequencies[32]++;
                }
                break;
                case 34: {
                    frequencies[33]++;
                }
                break;
                case 35: {
                    frequencies[34]++;
                }
                break;
                case 36: {
                    frequencies[35]++;
                }
                break;
                case 37: {
                    frequencies[36]++;
                }
                break;
                case 38: {
                    frequencies[37]++;
                }
                break;
                case 39: {
                    frequencies[38]++;
                }
                break;
                case 40: {
                    frequencies[39]++;
                }
                break;
            }

            // INTEX 6
            switch (item.getIntex6()) {
                case 1: {
                    frequencies[0]++;
                }
                break;
                case 2: {
                    frequencies[1]++;
                }
                break;
                case 3: {
                    frequencies[2]++;
                }
                break;
                case 4: {
                    frequencies[3]++;
                }
                break;
                case 5: {
                    frequencies[4]++;
                }
                break;
                case 6: {
                    frequencies[5]++;
                }
                break;
                case 7: {
                    frequencies[6]++;
                }
                break;
                case 8: {
                    frequencies[7]++;
                }
                break;
                case 9: {
                    frequencies[8]++;
                }
                break;
                case 10: {
                    frequencies[9]++;
                }
                break;
                case 11: {
                    frequencies[10]++;
                }
                break;
                case 12: {
                    frequencies[11]++;
                }
                break;
                case 13: {
                    frequencies[12]++;
                }
                break;
                case 14: {
                    frequencies[13]++;
                }
                break;
                case 15: {
                    frequencies[14]++;
                }
                break;
                case 16: {
                    frequencies[15]++;
                }
                break;
                case 17: {
                    frequencies[16]++;
                }
                break;
                case 18: {
                    frequencies[17]++;
                }
                break;
                case 19: {
                    frequencies[18]++;
                }
                break;
                case 20: {
                    frequencies[19]++;
                }
                break;
                case 21: {
                    frequencies[20]++;
                }
                break;
                case 22: {
                    frequencies[21]++;
                }
                break;
                case 23: {
                    frequencies[22]++;
                }
                break;
                case 24: {
                    frequencies[23]++;
                }
                break;
                case 25: {
                    frequencies[24]++;
                }
                break;
                case 26: {
                    frequencies[25]++;
                }
                break;
                case 27: {
                    frequencies[26]++;
                }
                break;
                case 28: {
                    frequencies[27]++;
                }
                break;
                case 29: {
                    frequencies[28]++;
                }
                break;
                case 30: {
                    frequencies[29]++;
                }
                break;
                case 31: {
                    frequencies[30]++;
                }
                break;
                case 32: {
                    frequencies[31]++;
                }
                break;
                case 33: {
                    frequencies[32]++;
                }
                break;
                case 34: {
                    frequencies[33]++;
                }
                break;
                case 35: {
                    frequencies[34]++;
                }
                break;
                case 36: {
                    frequencies[35]++;
                }
                break;
                case 37: {
                    frequencies[36]++;
                }
                break;
                case 38: {
                    frequencies[37]++;
                }
                break;
                case 39: {
                    frequencies[38]++;
                }
                break;
                case 40: {
                    frequencies[39]++;
                }
                break;
            }
        }

        List<Integer> absolutes = new ArrayList<>(Arrays.asList(frequencies).subList(0, 40));

        SUPERDB.setAbsoluteFrequencies(absolutes);

        System.out.println(SUPERDB.getAbsoluteFrequencies().toString());
    }
}
