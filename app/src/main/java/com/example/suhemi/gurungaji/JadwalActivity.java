package com.example.suhemi.gurungaji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class JadwalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);
    }

    public void kemenuguru(View view) {
        Intent intent = new Intent(JadwalActivity.this, GuruActivity.class);
        startActivity(intent);
    }
}
