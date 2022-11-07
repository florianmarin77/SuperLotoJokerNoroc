package com.lafi.sljn.sample.converter;

import com.lafi.sljn.sample.models.Sample;
import com.lafi.sljn.sample.models.Single;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public List<Sample> toSamples(List<Single> singles) {
        List<Sample> samples = new ArrayList<>();

        for (Single item : singles) {
            samples.add(toSample(item));
        }

        return samples;
    }

    public List<Single> toSingles(List<Sample> samples) {
        List<Single> singles = new ArrayList<>();

        for (Sample item : samples) {
            singles.add(toSingle(item));
        }

        return singles;
    }

    public Single toSingle(Sample sample) {
        Single single = new Single();

        single.setDatex(sample.getDatex());
        single.setIntex1(sample.getIntex1().toString());
        single.setIntex2(sample.getIntex2().toString());
        single.setIntex3(sample.getIntex3().toString());
        single.setIntex4(sample.getIntex4().toString());
        single.setIntex5(sample.getIntex5().toString());
        single.setIntex6(sample.getIntex6().toString());
        single.setCodex(sample.getCodex());
        single.setIndex(sample.getIndex().toString());

        return single;
    }

    public Sample toSample(Single single) {
        Sample sample = new Sample();

        sample.setDatex(single.getDatex());
        sample.setIntex1(Integer.valueOf(single.getIntex1()));
        sample.setIntex2(Integer.valueOf(single.getIntex2()));
        sample.setIntex3(Integer.valueOf(single.getIntex3()));
        sample.setIntex4(Integer.valueOf(single.getIntex4()));
        sample.setIntex5(Integer.valueOf(single.getIntex5()));
        sample.setIntex6(Integer.valueOf(single.getIntex6()));
        sample.setCodex(single.getCodex());
        sample.setIndex(Integer.valueOf(single.getIndex()));

        return sample;
    }
}
