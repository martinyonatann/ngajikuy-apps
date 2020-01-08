package com.example.suhemi.gurungaji;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BiodataActivity extends AppCompatActivity {


    EditText editTextName,editTextjk,editTextnohp, editTextalamat, editTextuser, editTextpw;
    FirebaseAuth firebaseAuth;
    User user;
    DatabaseReference databaseReference;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);


        firebaseAuth = FirebaseAuth.getInstance();

      /*  if (firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this, TampilanAwalActivity.class));
        }*/

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("User");
        user = new User();

        editTextName = (EditText) findViewById(R.id.edittextname);
        editTextjk = (EditText) findViewById(R.id.edittextjk);
        editTextnohp = (EditText) findViewById(R.id.edittextnohp);
        editTextalamat = (EditText) findViewById(R.id.edittextalamat);
       /* *//*editTextuser = (EditText) findViewById(R.id.edittextuser);
        editTextpw = (EditText) findViewById(R.id.edittextpw);*//*

        tambah = (Button) findViewById(R.id.tambah);*/


    }

    private void getValues(){
        user.setName(editTextName.getText().toString());
        user.setJk(editTextjk.getText().toString());
        user.setPhone(editTextnohp.getText().toString());
        user.setAlamat(editTextalamat.getText().toString());/*
        user.setUserName(editTextuser.getText().toString());
        user.setPassword(editTextpw.getText().toString());*/

    }

    public void addsimpanbiodata(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                getValues();
                databaseReference.child(user.getName()).setValue(user);
                Toast.makeText(BiodataActivity.this, "Data Berhasil Diubah", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        }
        public void tampil(){
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    getValues();
                    User user = dataSnapshot.getValue(User.class);
                    editTextName.setText("Nama Lengkap : " + user.getName());
                    editTextjk.setText("Jenis Kelamin : " + user.getJk());
                    editTextnohp.setText("No Handphone : " + user.getPhone());
                    editTextalamat.setText("Alamat : " + user.getAlamat());
                    editTextuser.setText("Email: " +user.getUserName());

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(BiodataActivity.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
                }
            });
        }


    public void simpan(View view) {
        addsimpanbiodata();
        finish();
        startActivity(new Intent(this, BiodataActivity.class));
    }/*

    public EditText getEditTextnohp() {
        return editTextnohp;
    }

    public EditText getEditTextjk() {
        return editTextjk;
    }

    public EditText getEditTextalamat() {
        return editTextalamat;
    }


*/

    public void lihatprofil(View view) {
        tampil();
        finish();
        startActivity(new Intent(this, LihatProfileActivity.class));
    }
  /*  @Override
    public void onClick(View v) {
        if (v == simpan){
      *//*      addsimpanbiodata();*//*
        }
    }*/
}
