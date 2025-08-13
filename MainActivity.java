package com.example.registrationapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etMonth, etDay, etYear, etEmail;
    Button btnSubmit;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etMonth = findViewById(R.id.etMonth);
        etDay = findViewById(R.id.etDay);
        etYear = findViewById(R.id.etYear);
        etEmail = findViewById(R.id.etEmail);
        btnSubmit = findViewById(R.id.btnSubmit);

        db = new DatabaseHelper(this);

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String month = etMonth.getText().toString();
            String day = etDay.getText().toString();
            String year = etYear.getText().toString();
            String email = etEmail.getText().toString();

            if (name.isEmpty() || month.isEmpty() || day.isEmpty() || year.isEmpty() || email.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                String dob = month + " " + day + " " + year;
                db.insertUser(name, dob, email);

                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(intent);
            }
        });
    }
}
