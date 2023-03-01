package com.example.musicproductionv2;

import java.util.Date;

public class spot {
    Integer sifra, sifraPjesma, sifraIzvodjac, sifraAlbum;
    String lokacija;
    Date datumSnimanja;

    public Integer getSifra() {
        return sifra;
    }

    public void setSifra(Integer sifra) {
        this.sifra = sifra;
    }

    public Integer getSifraPjesma() {
        return sifraPjesma;
    }

    public void setSifraPjesma(Integer sifraPjesma) {
        this.sifraPjesma = sifraPjesma;
    }

    public Integer getSifraIzvodjac() {
        return sifraIzvodjac;
    }

    public void setSifraIzvodjac(Integer sifraIzvodjac) {
        this.sifraIzvodjac = sifraIzvodjac;
    }

    public Integer getSifraAlbum() {
        return sifraAlbum;
    }

    public void setSifraAlbum(Integer sifraAlbum) {
        this.sifraAlbum = sifraAlbum;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public Date getDatumSnimanja() {
        return datumSnimanja;
    }

    public void setDatumSnimanja(Date datumSnimanja) {
        this.datumSnimanja = datumSnimanja;
    }

    public spot(Integer sifra, Integer sifraPjesma, Integer sifraIzvodjac, Integer sifraAlbum, String lokacija, Date datumSnimanja) {
        this.sifra = sifra;
        this.sifraPjesma = sifraPjesma;
        this.sifraIzvodjac = sifraIzvodjac;
        this.sifraAlbum = sifraAlbum;
        this.lokacija = lokacija;
        this.datumSnimanja = datumSnimanja;
    }
}

