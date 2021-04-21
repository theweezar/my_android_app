package com.example.project_test;

public class QuocGia {
    int quocKy;
    String tenQG,danSo;

    public QuocGia() {
    }

    public QuocGia(int quocKy, String tenQG, String danSo) {
        this.quocKy = quocKy;
        this.tenQG = tenQG;
        this.danSo = danSo;
    }

    public int getQuocKy() {
        return quocKy;
    }

    public void setQuocKy(int quocKy) {
        this.quocKy = quocKy;
    }

    public String getTenQG() {
        return tenQG;
    }

    public void setTenQG(String tenQG) {
        this.tenQG = tenQG;
    }

    public String getDanSo() {
        return danSo;
    }

    public void setDanSo(String danSo) {
        this.danSo = danSo;
    }

    @Override
    public String toString() {
        return "QuocGia{" +
                "quocKy=" + quocKy +
                ", tenQG='" + tenQG + '\'' +
                ", danSo='" + danSo + '\'' +
                '}';
    }
}
