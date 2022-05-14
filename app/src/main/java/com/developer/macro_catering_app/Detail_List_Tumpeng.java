package com.developer.macro_catering_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import java.text.NumberFormat;
import java.util.Locale;

public class Detail_List_Tumpeng extends AppCompatActivity {

    RelativeLayout messege;
    RelativeLayout keranjang;
    LinearLayout plih_menu;

    ImageButton tambah_menu, hapus_menu, backlayout;

    int jml=0;
    TextView jumlah_menu;

    double ttl=0;
    TextView total_menu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_tumpeng);
        getWindow().setStatusBarColor(ContextCompat.getColor(Detail_List_Tumpeng.this, R.color.blue1));

        messege = findViewById(R.id.pesan);
        keranjang = findViewById(R.id.keranjang);
        plih_menu = findViewById(R.id.pilihmenu);

        jumlah_menu = findViewById(R.id.txt_jumlah);
        total_menu = findViewById(R.id.txt_total);
        tambah_menu = findViewById(R.id.btn_tambah);
        hapus_menu = findViewById(R.id.btn_kurang);

        backlayout = findViewById(R.id.backIntent);

        backlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        plih_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PilihMenu.class));
            }
        });

        tambah_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jml=jml+1;
                jumlah_menu.setText(Integer.toString(jml));

                ttl += 100000;
                total_menu.setText("Rp "+Double.toString(ttl));
            }
        });

        hapus_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jml=jml-1;
                jumlah_menu.setText(Integer.toString(jml));

                ttl=ttl-100000;
                total_menu.setText("Rp " + Double.toString(ttl));
            }
        });
    }

    private String formatRupiah(Double number){
        Locale localeID = new Locale("ID", "ID");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeID);
        String formatRupiah = numberFormat.format(number);
        String[] split = formatRupiah.split(",");
        int lenght = split[0].length();
        return split[0].substring(0,2)+". "+split[0].substring(2, lenght);
    }

}