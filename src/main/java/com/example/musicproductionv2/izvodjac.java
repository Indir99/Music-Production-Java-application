package com.example.musicproductionv2;

import java.util.Date;

public class izvodjac {
    Integer sifra;
    String ime, prezime, umjIme, adresa, kontakt;
    Date datRodj;

    public void setSifra(Integer sifra) {
        this.sifra = sifra;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setUmjIme(String umjIme) {
        this.umjIme = umjIme;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public void setDatRodj(Date datRodj) {
        this.datRodj = datRodj;
    }

    public Integer getSifra() { return  sifra;}

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getUmjIme() {
        return umjIme;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getKontakt() {
        return kontakt;
    }

    public Date getDatRodj() {
        return datRodj;
    }

    public izvodjac(Integer sifra, String ime, String prezime, String umjIme, String adresa, String kontakt, Date datRodj) {
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
        this.umjIme = umjIme;
        this.adresa = adresa;
        this.kontakt = kontakt;
        this.datRodj = datRodj;
    }
}
