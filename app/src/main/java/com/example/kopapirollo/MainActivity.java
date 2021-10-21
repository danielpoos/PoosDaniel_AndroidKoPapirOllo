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
    private ImageView Gep_kep, Felh_kep;
    private TextView Win, Lose;
    private int wincount, losecount, drawcount;
    private int felhtipp, geptipp;
    private Toast toast;
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
                felhtipp = 1;sorsol();
                kiNyert();
            }

        });
        Ollo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Felh_kep.setImageResource(R.drawable.scissors);
                felhtipp = 2;sorsol();
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
        Win = findViewById(R.id.win);
        Lose = findViewById(R.id.lose);
        wincount = 0;
        losecount = 0;
        drawcount = 0;
        toast = new Toast(getApplicationContext());
    }

    public void sorsol(){
        geptipp = (int)(Math.random()*3);
        switch (geptipp){
            case 0: Gep_kep.setImageResource(R.drawable.rock); break;
            case 1: Gep_kep.setImageResource(R.drawable.paper);break;
            case 2: Gep_kep.setImageResource(R.drawable.scissors);break;
            default:break;
        }
    }
    public void kiNyert(){

        if (geptipp == 0 && felhtipp == 1){
            wincount++;
            Win.setText(String.format("%d", wincount));
            Toast.makeText(this, "Győzelem", Toast.LENGTH_SHORT).show();
        }else if (geptipp == 1 && felhtipp == 2){
            wincount++;
            Win.setText(String.format("%d", wincount));
            Toast.makeText(this, "Győzelem", Toast.LENGTH_SHORT).show();
        }else if (geptipp == 2 && felhtipp == 0){
            wincount++;
            Win.setText(String.format("%d", wincount));
            Toast.makeText(this, "Győzelem", Toast.LENGTH_SHORT).show();
        }else if (felhtipp == 0 && geptipp == 1){
            losecount++;
            Lose.setText(String.format("%d", losecount));
            Toast.makeText(this, "Vereség", Toast.LENGTH_SHORT).show();
        }else if (felhtipp == 1 && geptipp == 2){
            losecount++;
            Lose.setText(String.format("%d", losecount));
            Toast.makeText(this, "Vereség", Toast.LENGTH_SHORT).show();
        }else if (felhtipp == 2 && geptipp == 0){
            losecount++;
            Lose.setText(String.format("%d", losecount));
            Toast.makeText(this, "Vereség", Toast.LENGTH_SHORT).show();
        }else{
            drawcount++;
        }
        if (wincount == 3 || losecount == 3){
            //finish();
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
                    Lose.setText("0");
                    Win.setText("0");
                    /*finish();
                    startActivity(getIntent());*/
                }
            });
            b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finishAffinity();
                }
            });
            b.setCancelable(false);
            AlertDialog dialog = b.create();
            dialog.show();
        }
    }
}
