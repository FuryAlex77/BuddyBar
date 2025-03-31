package com.example.buddybar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class HomePage extends AppCompatActivity {

    private Button whiskeyButton, vodkaButton, rumButton, ginButton, tequilaButton;
    private Button brandyButton, wineButton, beerButton, champagneButton, scotchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        whiskeyButton = findViewById(R.id.btn_whiskey);
        vodkaButton = findViewById(R.id.btn_vodka);
        rumButton = findViewById(R.id.btn_rum);
        ginButton = findViewById(R.id.btn_gin);
        tequilaButton = findViewById(R.id.btn_tequila);
        brandyButton = findViewById(R.id.btn_brandy);
        wineButton = findViewById(R.id.btn_wine);
        beerButton = findViewById(R.id.btn_beer);
        scotchButton = findViewById(R.id.btn_scotch);
        champagneButton = findViewById(R.id.btn_champagne);


        whiskeyButton.setOnClickListener(v -> {
            startActivity(new Intent(HomePage.this, WhiskeyPage.class));
        });

        vodkaButton.setOnClickListener(v -> {
            startActivity(new Intent(HomePage.this, VodkaPage.class));
        });

        rumButton.setOnClickListener(v -> {
            startActivity(new Intent(HomePage.this, RumPage.class));
        });

        ginButton.setOnClickListener(v -> {
            startActivity(new Intent(HomePage.this, GinPage.class));
        });

        tequilaButton.setOnClickListener(v -> {
            startActivity(new Intent(HomePage.this, TequilaPage.class));
        });

        brandyButton.setOnClickListener(v -> {
            startActivity(new Intent(HomePage.this, BrandyPage.class));
        });

        wineButton.setOnClickListener(v -> {
            startActivity(new Intent(HomePage.this, WinePage.class));
        });

        beerButton.setOnClickListener(v -> {
            startActivity(new Intent(HomePage.this, BeerPage.class));
        });

        champagneButton.setOnClickListener(v -> {
            startActivity(new Intent(HomePage.this, ChampagnePage.class));
        });

        scotchButton.setOnClickListener(v -> {
            startActivity(new Intent(HomePage.this, ScotchPage.class));
        });

    }

}
