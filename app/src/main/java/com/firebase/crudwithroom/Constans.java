package com.firebase.crudwithroom;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.firebase.crudwithroom.Interface.Dao;
import com.firebase.crudwithroom.Model.Mahasiswa;

@Database(entities = {Mahasiswa.class}, version = 1)
public abstract class Constans extends RoomDatabase {

    public abstract Dao userDao();

}
