package com.example.muhammad.prediksihargarumputlaut;

public class Data {
    private String id, moving, moving2,moving3, smoothing,smoothing2,smoothing3,naive,naive2,naive3;

    public Data(){
    }


    public Data(String id, String moving, String moving2, String moving3, String smoothing, String smoothing2, String smoothing3, String naive, String naive2, String naive3){
        this.id = id;
        this.moving = moving;
        this.moving2 = moving2;
        this.moving3 = moving3;
        this.smoothing = smoothing;
        this.smoothing2 = smoothing2;
        this.smoothing3 = smoothing3;
        this.naive = naive;
        this.naive2 = naive2;
        this.naive3 = naive3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getMoving() {
        return moving;
    }

    public String getMoving2() {
        return moving2;
    }

    public String getMoving3() {
        return moving3;
    }


    public String getSmoothing() {
        return smoothing;
    }

    public String getSmoothing2() {
        return smoothing2;
    }

    public String getSmoothing3() {
        return smoothing3;
    }


    public String getNaive() {
        return naive;
    }

    public String getNaive2() {
        return naive2;
    }

    public String getNaive3() {
        return naive3;
    }


    public void setMoving(String moving) {
        this.moving = moving;
    }

    public void setMoving2(String moving2) {
        this.moving2 = moving2;
    }

    public void setMoving3(String moving3) {
        this.moving3 = moving3;
    }



    public void setSmoothing(String smoothing) {
        this.smoothing = smoothing;
    }

    public void setSmoothing2(String smoothing2) {
        this.smoothing2 = smoothing2;
    }

    public void setSmoothing3(String smoothing3) {
        this.smoothing3 = smoothing3;
    }


    public void setNaive(String naive) {
        this.naive = naive;
    }

    public void setNaive2(String naive2) {
        this.naive2 = naive2;
    }

    public void setNaive3(String naive3) {
        this.naive3 = naive3;
    }
}
