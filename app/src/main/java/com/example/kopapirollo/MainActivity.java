package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button Ko, Papir, Ollo;
    private ImageView Gep_kep, Felh_kep;
    private TextView Win, Lose;
    private int wincount, losecount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        Ko = findViewById(R.id.ko);
        Papir = findViewById(R.id.papir);
        Ollo = findViewById(R.id.ollo);
        Gep_kep = findViewById(R.id.gep_kep);
        Felh_kep = findViewById(R.id.felh_kep);
        Win = findViewById(R.id.win);
        Lose = findViewById(R.id.lose);
    }
}