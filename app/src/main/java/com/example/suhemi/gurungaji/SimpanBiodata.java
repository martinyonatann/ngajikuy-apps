package com.example.suhemi.gurungaji;

public class SimpanBiodata {
    String id;
    String nama;
    String jk;
    String nohp;
    String alamat;

  public SimpanBiodata(){

    }

    public SimpanBiodata(String id, String nama, String jk, String nohp, String alamat) {
        this.id = id;
        this.nama = nama;
        this.jk = jk;
        this.nohp = nohp;
        this.alamat = alamat;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJk() {
        return jk;
    }

    public String getNohp() {
        return nohp;
    }

    public String getAlamat() {
        return alamat;
    }
}
