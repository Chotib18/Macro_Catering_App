package com.developer.macro_catering_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Detail_Tumpeng extends AppCompatActivity {

    ActionBar actionBar;

    LinearLayout tumpeng1;
    LinearLayout tumpeng2;
    LinearLayout tumpeng3;
    LinearLayout tumpeng4;
    LinearLayout tumpeng5;
    LinearLayout tumpeng6;
    LinearLayout tumpeng7;
    LinearLayout tumpeng8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tumpeng);
        getWindow().setStatusBarColor(ContextCompat.getColor(Detail_Tumpeng.this, R.color.blue1));

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.tumpeng_detail));

        tumpeng1 = findViewById(R.id.tumpeng1);
        tumpeng2 = findViewById(R.id.tumpeng2);

        tumpeng1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Detail_List_Tumpeng.class));
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}