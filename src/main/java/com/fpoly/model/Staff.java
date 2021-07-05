package com.fpoly.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Staff {
    private String username;
    private String password;
    private String gioiTinh;
    private String honNhan;
    private String quocTich;
    private String[] soThich;
    private String note;
    private String hinhAnh;

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", honNhan='" + honNhan + '\'' +
                ", quocTich='" + quocTich + '\'' +
                ", soThich=" + Arrays.toString(soThich) +
                ", note='" + note + '\'' +
                ", hinhAnh='" + hinhAnh + '\'' +
                '}';
    }

    public Staff() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(password);
            password = new SimpleDateFormat("dd-MM-yyyy").format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getHonNhan() {
        return honNhan;
    }

    public void setHonNhan(String honNhan) {
        this.honNhan = honNhan;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String[] getSoThich() {
        return soThich;
    }

    public void setSoThich(String[] soThich) {
        this.soThich = soThich;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
