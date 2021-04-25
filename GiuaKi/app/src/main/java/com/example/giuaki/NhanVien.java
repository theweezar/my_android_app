package com.example.giuaki;

public class NhanVien {

    private long id;
    private String maNv;
    private String hoTen;
    private String ngaySinh;
    private long idPb;

    public NhanVien(String maNv, String hoTen, String ngaySinh, long idPb) {
        this.maNv = maNv;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.idPb = idPb;
    }

    public NhanVien(long id, String maNv, String hoTen, String ngaySinh, long idPb) {
        this.id = id;
        this.maNv = maNv;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.idPb = idPb;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public long getIdPb() {
        return idPb;
    }

    public void setIdPb(long idPb) {
        this.idPb = idPb;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "id=" + id +
                ", maNv='" + maNv + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", idPb=" + idPb +
                '}';
    }
}
