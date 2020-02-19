package com.firebase.crudwithroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.firebase.crudwithroom.Adapter.DetailAdapter;
import com.firebase.crudwithroom.Model.Mahasiswa;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etNim;
    EditText etKejuruan;
    EditText etAlamat;
    Button btnInsert;
    Button btnDelete;
    Mahasiswa mahasiswa;
    Constans database;
    RecyclerView recyclerView;
    DetailAdapter detailAdapter;
    List<Mahasiswa> listMahasiswa = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = Room.databaseBuilder(getApplicationContext(),Constans.class,"mahasiswa")
                .allowMainThreadQueries().build();
        init();
        listMahasiswa = database.userDao().getAll();

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        detailAdapter = new DetailAdapter(this,listMahasiswa);

        recyclerView.setAdapter(detailAdapter);
    }

    void init(){
        etNama = findViewById(R.id.etNama);
        etNim = findViewById(R.id.etNim);
        etAlamat = findViewById(R.id.etAlamat);
        etKejuruan = findViewById(R.id.etKejuruan);
            btnInsert = findViewById(R.id.btnInsert);
        recyclerView = findViewById(R.id.recycleView);
        btnDelete = findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.userDao().deleteUsers();

            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mahasiswa = new Mahasiswa();
                mahasiswa.setNama(etNama.getText().toString());
                mahasiswa.setNim(etNim.getText().toString());
                mahasiswa.setAlamat(etAlamat.getText().toString());
                mahasiswa.setKejuruan(etKejuruan.getText().toString());

                database.userDao().insertAll(mahasiswa);
                database.userDao().getAll();


            }
        });
    }


}
