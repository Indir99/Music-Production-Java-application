package com.example.musicproductionv2;

import java.util.Date;

public class pjesma {
    Integer sifra, sifraIzvodjac, sifraAlbum, sifraSpot, sifraTekstopisac, sifraKompozitor, sifraAranzer, sifraZanr ;
    String naziv, jezik;
    Date datIzd;

    public Integer getSifra() {
        return sifra;
    }

    public void setSifra(Integer sifra) {
        this.sifra = sifra;
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

    public Integer getSifraSpot() {
        return sifraSpot;
    }

    public void setSifraSpot(Integer sifraSpot) {
        this.sifraSpot = sifraSpot;
    }

    public Integer getSifraTekstopisac() {
        return sifraTekstopisac;
    }

    public void setSifraTekstopisac(Integer sifraTekstopisac) {
        this.sifraTekstopisac = sifraTekstopisac;
    }

    public Integer getSifraKompozitor() {
        return sifraKompozitor;
    }

    public void setSifraKompozitor(Integer sifraKompozitor) {
        this.sifraKompozitor = sifraKompozitor;
    }

    public Integer getSifraAranzer() {
        return sifraAranzer;
    }

    public void setSifraAranzer(Integer sifraAranzer) {
        this.sifraAranzer = sifraAranzer;
    }

    public Integer getSifraZanr() {
        return sifraZanr;
    }

    public void setSifraZanr(Integer sifraZanr) {
        this.sifraZanr = sifraZanr;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getJezik() {
        return jezik;
    }

    public void setJezik(String jezik) {
        this.jezik = jezik;
    }

    public Date getDatIzd() {
        return datIzd;
    }

    public void setDatIzd(Date datIzd) {
        this.datIzd = datIzd;
    }

    public pjesma(Integer sifra, Integer sifraIzvodjac, Integer sifraAlbum, Integer sifraSpot, Integer sifraTekstopisac,
                  Integer sifraKompozitor, Integer sifraAranzer, Integer sifraZanr, String naziv, String jezik, Date datIzd) {
        this.sifra = sifra;
        this.sifraIzvodjac = sifraIzvodjac;
        this.sifraAlbum = sifraAlbum;
        this.sifraSpot = sifraSpot;
        this.sifraTekstopisac = sifraTekstopisac;
        this.sifraKompozitor = sifraKompozitor;
        this.sifraAranzer = sifraAranzer;
        this.sifraZanr = sifraZanr;
        this.naziv = naziv;
        this.jezik = jezik;
        this.datIzd = datIzd;
    }
}
