package com.example.listaprzekreslenie;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Produkt> produkty = new ArrayList<>();
    ArrayAdapter<Produkt> adapter;
    Button dodajButton;
    EditText nazwaProd;
    EditText cenaProd;
    CheckBox dostepnosc;
    ListView listaProduktow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        dodajButton = findViewById(R.id.button);
        nazwaProd = findViewById(R.id.editTextText);
        cenaProd = findViewById(R.id.editTextNumberDecimal);
        dostepnosc = findViewById(R.id.checkBox);
        listaProduktow = findViewById(R.id.listviewProd);

        dodajButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String tekst = nazwaProd.getText().toString();
                        double cenaT = Double.parseDouble(cenaProd.getText().toString());
                        boolean dostT = dostepnosc.isChecked();

                        // tekst.matches("\\d+") -> sprawdzanie czy tylko CYFRY
                        // tekst.matches("[\\p{L}+]") -> czy tylko LITERY
                        if(tekst.matches("\\p{L}+")){
                            produkty.add(new Produkt(tekst,cenaT,dostT));
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Niepoprawne dane!",Toast.LENGTH_LONG).show();
                        }


                        adapter.notifyDataSetChanged();

                    }
                }
        );

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, produkty);
        listaProduktow.setAdapter(adapter);

        listaProduktow.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        TextView elementListy = (TextView) view;
                        elementListy.setPaintFlags(elementListy.getPaintFlags() ^ Paint.STRIKE_THRU_TEXT_FLAG);
                    }
                }
        );

    }
}