package com.developer.macro_catering_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    TextView lihatSemua;

    LinearLayout CardLocation;
    LinearLayout CardTumpeng;
    LinearLayout CardPrasmanan;
    LinearLayout CardNasiBox;
    LinearLayout CardSnackBox;
    LinearLayout CardMinuman;

    LinearLayout TumpengCard;


    LinearLayout ListCard;

    private ImageSlider img_Slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.blue1));

        bottomNavigation = findViewById(R.id.nav_view);
        bottomNavigation.setSelectedItemId(R.id.navigation_home);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.navigation_home:
                        return true;
                    case R.id.navigation_messsege:
                        startActivity(new Intent(getApplicationContext(), Messege.class));
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.navigation_notifications:
                        startActivity(new Intent(getApplicationContext(), Notifications.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        CardLocation = findViewById(R.id.location);
        CardTumpeng = findViewById(R.id.tumpeng);
        CardPrasmanan = findViewById(R.id.prasmanan);
        CardNasiBox = findViewById(R.id.nasibox);
        CardSnackBox = findViewById(R.id.snackbox);
        CardMinuman = findViewById(R.id.minuman);
        lihatSemua = findViewById(R.id.lihatsemua);
        TumpengCard = findViewById(R.id.detailTumpeng);
        ListCard = findViewById(R.id.list1);

        img_Slider = findViewById(R.id.Img_Slider);

        ArrayList<SlideModel> images = new ArrayList<>();
        images.add(new SlideModel(R.drawable.banner1,null));
        images.add(new SlideModel(R.drawable.banner2,null));
        images.add(new SlideModel(R.drawable.promo,null));
        images.add(new SlideModel(R.drawable.banner4,null));
        images.add(new SlideModel(R.drawable.banner5,null));

        img_Slider.setImageList(images, ScaleTypes.CENTER_CROP);

        img_Slider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/Chotib18"));
                startActivity(intent);
            }
        });

        CardLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Detail_Tumpeng.class));
            }
        });

        CardTumpeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Detail_Tumpeng.class));
            }
        });

        CardPrasmanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Detail_Tumpeng.class));
            }
        });

        CardNasiBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Detail_Tumpeng.class));
            }
        });

        CardSnackBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Detail_Tumpeng.class));
            }
        });

        CardMinuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Detail_Tumpeng.class));
            }
        });

        lihatSemua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity((new Intent(getApplicationContext(), List_Rekomendasi.class)));
            }
        });

        TumpengCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Detail_Tumpeng.class));
            }
        });

        ListCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Detail_Tumpeng.class));
            }
        });
    }
}