package com.example.giuaki;

public class PhongBan {

    private long id;
    private String mapb;
    private String tenpb;

    public PhongBan(String mapb, String tenpb) {
        this.mapb = mapb;
        this.tenpb = tenpb;
    }

    public PhongBan(long id, String mapb, String tenpb) {
        this.id = id;
        this.mapb = mapb;
        this.tenpb = tenpb;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMapb() {
        return mapb;
    }

    public void setMapb(String mapb) {
        this.mapb = mapb;
    }

    public String getTenpb() {
        return tenpb;
    }

    public void setTenpb(String tenpb) {
        this.tenpb = tenpb;
    }
}
