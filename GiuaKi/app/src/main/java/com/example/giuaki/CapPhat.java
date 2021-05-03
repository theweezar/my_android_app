package com.example.giuaki;

public class CapPhat {

    private long id;
    private String soPhieu;
    private String ngayCap;
    private long idVpp;
    private long idNv;
    private long sl;

    public CapPhat(String soPhieu, String ngayCap, long idVpp, long idNv, long sl) {
        this.soPhieu = soPhieu;
        this.ngayCap = ngayCap;
        this.idVpp = idVpp;
        this.idNv = idNv;
        this.sl = sl;
    }

    public CapPhat(long id, String soPhieu, String ngayCap, long idVpp, long idNv, long sl) {
        this.id = id;
        this.soPhieu = soPhieu;
        this.ngayCap = ngayCap;
        this.idVpp = idVpp;
        this.idNv = idNv;
        this.sl = sl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSoPhieu() {
        return soPhieu;
    }

    public void setSoPhieu(String soPhieu) {
        this.soPhieu = soPhieu;
    }

    public String getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(String ngayCap) {
        this.ngayCap = ngayCap;
    }

    public long getIdVpp() {
        return idVpp;
    }

    public void setIdVpp(long idVpp) {
        this.idVpp = idVpp;
    }

    public long getIdNv() {
        return idNv;
    }

    public void setIdNv(long idNv) {
        this.idNv = idNv;
    }

    public long getSl() {
        return sl;
    }

    public void setSl(long sl) {
        this.sl = sl;
    }
}
