package com.example.toplamamakinesiodev5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView sonucEkrani, islemEkrani;
    Button buttonNum0, buttonNum1, buttonNum2,buttonNum3,buttonNum4,buttonNum5,buttonNum6,buttonNum7,buttonNum8,
            buttonNum9, buttonAC, buttonC, buttonEsit, buttonNokta, buttonArti;
    String ilkSayi, sonSayi;
    int toplam = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonNum0 = findViewById(R.id.buttonNum0);
        buttonNum1 = findViewById(R.id.buttonNum1);
        buttonNum2 = findViewById(R.id.buttonNum2);
        buttonNum3 = findViewById(R.id.buttonNum3);
        buttonNum4 = findViewById(R.id.buttonNum4);
        buttonNum5 = findViewById(R.id.buttonNum5);
        buttonNum6 = findViewById(R.id.buttonNum6);
        buttonNum7 = findViewById(R.id.buttonNum7);
        buttonNum8 = findViewById(R.id.buttonNum8);
        buttonNum9 = findViewById(R.id.buttonNum9);
        buttonAC = findViewById(R.id.buttonTamamenSilAC);
        buttonC = findViewById(R.id.buttonSilC);
        buttonNokta = findViewById(R.id.buttonNokta);
        buttonEsit = findViewById(R.id.buttonEsit);
        buttonArti = findViewById(R.id.buttonArti);
        sonucEkrani = findViewById(R.id.textViewSonucEkrani);
        islemEkrani = findViewById(R.id.textViewIslemEkran);

        buttonNum0.setOnClickListener(view -> {
            ekranaYaz(0);
        });
        buttonNum1.setOnClickListener(view -> {
            ekranaYaz(1);
        });
        buttonNum2.setOnClickListener(view -> {
            ekranaYaz(2);
        });
        buttonNum3.setOnClickListener(view -> {
            ekranaYaz(3);
        });
        buttonNum4.setOnClickListener(view -> {
            ekranaYaz(4);
        });
        buttonNum5.setOnClickListener(view -> {
            ekranaYaz(5);
        });
        buttonNum6.setOnClickListener(view -> {
            ekranaYaz(6);
        });
        buttonNum7.setOnClickListener(view -> {
            ekranaYaz(7);
        });
        buttonNum8.setOnClickListener(view -> {
            ekranaYaz(8);
        });
        buttonNum9.setOnClickListener(view -> {
            ekranaYaz(9);
        });
        buttonAC.setOnClickListener(view -> {
            sonucEkrani.setText("0");
        });
        buttonC.setOnClickListener(view -> {
            sonucEkrani.setText("0");
        });
        buttonNokta.setOnClickListener(view -> {
            ekranaYazSembol(".");
        });
        buttonArti.setOnClickListener(view -> {
            ilkSayi = sonucEkrani.getText().toString();
            ekranaYazSembol("+");
            islemEkrani.setText(sonucEkrani.getText().toString());
            sonucEkrani.setText("");
        });
        buttonEsit.setOnClickListener(view -> {
            sonSayi = sonucEkrani.getText().toString();
            toplam += Integer.valueOf(ilkSayi) + Integer.valueOf(sonSayi);
            sonucEkrani.setText(Integer.toString(toplam));
            islemEkrani.setText("");
            toplam = 0;
        });
    }
    public void ekranaYaz (int sayi){
        if (sonucEkrani.getText().toString() == "0" || sonucEkrani.getText().toString() == "+"){
            sonucEkrani.setText("");
        }
        sonucEkrani.setText(sonucEkrani.getText() + String.valueOf(sayi));
    }
    public void ekranaYazSembol(String sembol){
        switch (sembol){
            case "+":
                sonucEkrani.setText(sonucEkrani.getText() + " + ");
                break;
            case ".":
                sonucEkrani.setText(sonucEkrani.getText() + ".");
                break;
        }
    }
}

