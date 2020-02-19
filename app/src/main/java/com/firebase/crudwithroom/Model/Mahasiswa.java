package com.firebase.crudwithroom.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Mahasiswa {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "nama")
    private String nama;
    @ColumnInfo(name = "nim")
    private String nim;
    @ColumnInfo(name = "kejuruan")
    private String kejuruan;
    @ColumnInfo(name = "alamat")
    private String alamat;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNim() {
        return nim;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }
    public String getKejuruan() {
        return kejuruan;
    }
    public void setKejuruan(String kejuruan) {
        this.kejuruan = kejuruan;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}