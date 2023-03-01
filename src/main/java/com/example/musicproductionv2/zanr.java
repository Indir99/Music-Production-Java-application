package com.example.musicproductionv2;

import java.util.Date;

public class zanr {
    Integer sifra;
    String naziv, kratica;

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

    public String getKratica() {
        return kratica;
    }

    public void setKratica(String kratica) {
        this.kratica = kratica;
    }

    public zanr(Integer sifra, String naziv, String kratica) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.kratica = kratica;
    }
}
