package com.example.suhemi.gurungaji;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {

    private TextView profileName, profileJk, profileHp, profileAlamat, profileEmail;
    private Button editProfill;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileName = findViewById(R.id.nameprofile);
        profileJk = findViewById(R.id.jkprofile);
        profileHp = findViewById(R.id.hpprofile);
        profileAlamat = findViewById(R.id.alamatprofile);
        profileEmail = findViewById(R.id.emailprofile);
        editProfill = findViewById(R.id.edit);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        /*databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                profileName.setText("Nama Lengkap : " + userProfile.getUserNama());
                profileJk.setText("Jenis Kelamin : " + userProfile.getUserJk());
                profileHp.setText("No Handphone : " + userProfile.getUserNohp());
                profileAlamat.setText("Alamat : " + userProfile.getUserAlamat());
                profileEmail.setText("Email: " +userProfile.getUserEmail());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ProfileActivity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });
*/
       /* databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                profileName.setText("Nama Lengkap : " + userProfile.getNama());
                profileJk.setText("Jenis Kelamin : " + userProfile.getJk());
                profileHp.setText("No Handphone : " + userProfile.getNohp());
                profileAlamat.setText("Alamat : " + userProfile.getAlamat());
                profileEmail.setText("Email: " +userProfile.getEmail());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ProfileActivity.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });*/


    }

    public void tetapdisiniaja(View view) {
        Intent intent = new Intent(ProfileActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
}
