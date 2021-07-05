package com.fpoly.model;

public class Lab4Item {
    private int id;
    private String tenItem;
    private String anhItem;
    private int giaItem;
    private int giaGiam;
    private String moTaItem;
    private String ngayNhap;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGiaGiam() {
        return giaGiam;
    }

    public void setGiaGiam(int giaGiam) {
        this.giaGiam = giaGiam;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public Lab4Item(){
    }

    public Lab4Item(int id, String tenItem, String anhItem, int giaItem, int giaGiam, String moTaItem, String ngayNhap) {
        this.id = id;
        this.tenItem = tenItem;
        this.anhItem = anhItem;
        this.giaItem = giaItem;
        this.giaGiam = giaGiam;
        this.moTaItem = moTaItem;
        this.ngayNhap = ngayNhap;
    }

    public String getTenItem() {
        return tenItem;
    }

    public void setTenItem(String tenItem) {
        this.tenItem = tenItem;
    }

    public String getAnhItem() {
        return anhItem;
    }

    public void setAnhItem(String anhItem) {
        this.anhItem = anhItem;
    }

    public int getGiaItem() {
        return giaItem;
    }

    public void setGiaItem(int giaItem) {
        this.giaItem = giaItem;
    }

    public String getMoTaItem() {
        return moTaItem;
    }

    public void setMoTaItem(String moTaItem) {
        this.moTaItem = moTaItem;
    }
}
