package com.firebase.crudwithroom.Interface;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.firebase.crudwithroom.Model.Mahasiswa;

import java.util.List;
@androidx.room.Dao
public interface Dao {
    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa> getAll();

    //Example Custum Query
    @Query("SELECT * FROM mahasiswa WHERE nama LIKE :nama ")
    Mahasiswa findByName(String nama);

    @Insert
    void insertAll(Mahasiswa... mahasiswa);


    @Query("DELETE FROM mahasiswa")
    void deleteUsers();
}
