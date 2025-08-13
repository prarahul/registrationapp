package com.example.registrationapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    TableLayout tableLayout;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tableLayout = findViewById(R.id.tableLayout);
        db = new DatabaseHelper(this);

        List<UserModel> userList = db.getAllUsers();

        for (UserModel user : userList) {
            TableRow row = new TableRow(this);

            TextView tvName = new TextView(this);
            tvName.setText(user.getName());
            tvName.setPadding(5, 5, 5, 5);

            TextView tvDob = new TextView(this);
            tvDob.setText(user.getDob());
            tvDob.setPadding(5, 5, 5, 5);

            TextView tvEmail = new TextView(this);
            tvEmail.setText(user.getEmail());
            tvEmail.setPadding(5, 5, 5, 5);

            row.addView(tvName);
            row.addView(tvDob);
            row.addView(tvEmail);

            tableLayout.addView(row);
        }
    }
}
