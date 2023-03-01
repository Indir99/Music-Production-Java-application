package com.example.musicproductionv2;

import java.util.Date;

public class funkcija {
    Integer sifra;
    String naziv;

    public Integer getSifra() {
        return sifra;
    }

    public void setSifra(Integer sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public funkcija(Integer sifra, String naziv) {
        this.sifra = sifra;
        this.naziv = naziv;
    }
}
