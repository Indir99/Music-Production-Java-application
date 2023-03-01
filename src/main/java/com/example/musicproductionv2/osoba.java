package com.example.musicproductionv2;

import java.util.Date;

public class osoba {
    Integer sifra;
    String ime, prezime, zanimanje, adresa, kontakt;
    Date datRodj;

    public Integer getSifra() {
        return sifra;
    }

    public void setSifra(Integer sifra) {
        this.sifra = sifra;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(String zanimanje) {
        this.zanimanje = zanimanje;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public Date getDatRodj() {
        return datRodj;
    }

    public void setDatRodj(Date datRodj) {
        this.datRodj = datRodj;
    }

    public osoba(Integer sifra, String ime, String prezime, String umjIme, String adresa, String kontakt, Date datRodj) {
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
        this.zanimanje = umjIme;
        this.adresa = adresa;
        this.kontakt = kontakt;
        this.datRodj = datRodj;
    }
}
