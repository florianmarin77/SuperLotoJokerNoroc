package com.lafi.sljn.internal.database;

import com.lafi.sljn.internal.model.Sample;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    // Singleton - ca să avem o singură instanță în toată aplicația
    private static LottoRepository instance;

    private final List<Sample> lotoData = new ArrayList<>();
    private final List<Sample> jokerData = new ArrayList<>();
    private final List<Sample> superData = new ArrayList<>();

    private LottoRepository() {
    }

    public static synchronized LottoRepository getInstance() {
        if (instance == null) {
            instance = new LottoRepository();
        }
        return instance;
    }

    // Metode pentru a adăuga date
    public void setLotoData(List<Sample> data) {
        this.lotoData.clear();
        this.lotoData.addAll(data);
    }

    public void setJokerData(List<Sample> data) {
        this.jokerData.clear();
        this.jokerData.addAll(data);
    }

    public void setSuperData(List<Sample> data) {
        this.superData.clear();
        this.superData.addAll(data);
    }

    // Metode pentru a prelua datele
    public List<Sample> getLotoData() {
        return lotoData;
    }

    public List<Sample> getJokerData() {
        return jokerData;
    }

    public List<Sample> getSuperData() {
        return superData;
    }
}