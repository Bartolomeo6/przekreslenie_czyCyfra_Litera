package com.example.listaprzekreslenie;

import androidx.annotation.NonNull;

public class Produkt {
    private String Nazwa;
    private Double Cena;
    private Boolean CzyDostepny;

    public Produkt(String nazwa, Double cena, Boolean czyDostepny) {
        Nazwa = nazwa;
        Cena = cena;
        CzyDostepny = czyDostepny;
    }

    @NonNull
    public String toString(){
        return this.Nazwa+" "+this.Cena+" "+this.CzyDostepny;
    }
}
