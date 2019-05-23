package com.activity.myapplication;

public class Model {
    private int id;
    private String stt, masach, tensach, sotien ;
    private  byte[] image ;

    public Model(int id, String stt, String masach, String tensach, String sotien, byte[] image) {
        this.id = id;
        this.stt = stt;
        this.masach = masach;
        this.tensach = tensach;
        this.sotien = sotien;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getSotien() {
        return sotien;
    }

    public void setSotien(String sotien) {
        this.sotien = sotien;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
