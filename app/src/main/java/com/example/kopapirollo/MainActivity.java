package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button Ko, Papir, Ollo;
    private ImageView Gep_kep, Felh_kep, gepsziv1, gepsziv2, gepsziv3, felhsziv1, felhsziv2, felhsziv3;
    private ImageView[] gepszivek, felhszivek;
    private TextView draws;
    private int wincount, losecount, drawcount, felhtipp, geptipp;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Ko.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Felh_kep.setImageResource(R.drawable.rock);
                felhtipp = 0;
                sorsol();
                kiNyert();
            }
        });
        Papir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Felh_kep.setImageResource(R.drawable.paper);
                felhtipp = 1;
                sorsol();
                kiNyert();
            }
        });
        Ollo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Felh_kep.setImageResource(R.drawable.scissors);
                felhtipp = 2;
                sorsol();
                kiNyert();
            }
        });


    }
    public void init(){
        Ko = findViewById(R.id.ko);
        Papir = findViewById(R.id.papir);
        Ollo = findViewById(R.id.ollo);
        Gep_kep = findViewById(R.id.gep_kep);
        Felh_kep = findViewById(R.id.felh_kep);
        gepsziv1 = findViewById(R.id.gepsziv1);
        gepsziv2 = findViewById(R.id.gepsziv2);
        gepsziv3 = findViewById(R.id.gepsziv3);
        felhsziv1 = findViewById(R.id.felhsziv1);
        felhsziv2 = findViewById(R.id.felhsziv2);
        felhsziv3 = findViewById(R.id.felhsziv3);
        draws = findViewById(R.id.drawlabel);
        gepszivek = new ImageView[]{gepsziv3,gepsziv2,gepsziv1};
        felhszivek = new ImageView[]{felhsziv3,felhsziv2,felhsziv1};
        wincount = 0;
        losecount = 0;
        drawcount = 0;

    }

    public void sorsol(){
        geptipp = (int)(Math.random()*3);
        switch (geptipp){
            case 0: Gep_kep.setImageResource(R.drawable.rock); break;
            case 1: Gep_kep.setImageResource(R.drawable.paper); break;
            case 2: Gep_kep.setImageResource(R.drawable.scissors); break;
            default:break;
        }
    }
    public void kiNyert(){

        if (geptipp == 0 && felhtipp == 1){
            gepszivek[wincount].setImageResource(R.drawable.heart1);
            wincount++;
            Toast.makeText(this, "Győzelem", Toast.LENGTH_SHORT).show();
        }else if (geptipp == 1 && felhtipp == 2){
            gepszivek[wincount].setImageResource(R.drawable.heart1);
            wincount++;
            Toast.makeText(this, "Győzelem", Toast.LENGTH_SHORT).show();
        }else if (geptipp == 2 && felhtipp == 0){
            gepszivek[wincount].setImageResource(R.drawable.heart1);
            wincount++;
            Toast.makeText(this, "Győzelem", Toast.LENGTH_SHORT).show();
        }else if (felhtipp == 0 && geptipp == 1){
            felhszivek[losecount].setImageResource(R.drawable.heart1);
            losecount++;
            Toast.makeText(this, "Vereség", Toast.LENGTH_SHORT).show();
        }else if (felhtipp == 1 && geptipp == 2){
            felhszivek[losecount].setImageResource(R.drawable.heart1);
            losecount++;
            Toast.makeText(this, "Vereség", Toast.LENGTH_SHORT).show();
        }else if (felhtipp == 2 && geptipp == 0){
            felhszivek[losecount].setImageResource(R.drawable.heart1);
            losecount++;
            Toast.makeText(this, "Vereség", Toast.LENGTH_SHORT).show();
        }else{
            drawcount++;
            draws.setText(String.format("Döntetlenek száma: %d", drawcount));
            Toast.makeText(this, "Döntetlen", Toast.LENGTH_SHORT).show();
        }
        if (wincount == 3 || losecount == 3){
            AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
            if (wincount == 3) b.setTitle("Győzelem");
            else b.setTitle("Vereség");
            b.setMessage("Vége a játéknak. Szeretne új játékot kezdeni?");
            b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    wincount = 0;
                    losecount = 0;
                    drawcount = 0;
                    draws.setText(String.format("Döntetlenek száma: %d", drawcount));
                    for (ImageView v:gepszivek) {
                        v.setImageResource(R.drawable.heart2);
                    }
                    for (ImageView v:felhszivek) {
                        v.setImageResource(R.drawable.heart2);
                    }
                }
            });
            b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finishAffinity();
                }
            });
            b.setCancelable(false);
            dialog = b.create();
            dialog.show();
        }
    }
}
