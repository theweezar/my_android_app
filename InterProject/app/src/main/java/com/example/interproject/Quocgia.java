package com.example.interproject;

public class Quocgia {
    int quocKy;
    String tenQG, danSo;

    public Quocgia() {
    }

    public Quocgia(int quocKy, String tenQG, String danSo) {
        this.quocKy = quocKy;
        this.tenQG = tenQG;
        this.danSo = danSo;
    }

    public int getQuocKy() {
        return quocKy;
    }

    public String getTenQG() {
        return tenQG;
    }

    public void setQuocKy(int quocKy) {
        this.quocKy = quocKy;
    }

    public void setTenQG(String tenQG) {
        this.tenQG = tenQG;
    }

    public void setDanSo(String danSo) {
        this.danSo = danSo;
    }

    public String getDanSo() {
        return danSo;
    }

    @Override
    public String toString() {
        return "Quocgia{" +
                "quocKy=" + quocKy +
                ", tenQG='" + tenQG + '\'' +
                ", danSo='" + danSo + '\'' +
                '}';
    }
}
