package com.example.musicproductionv2;

import java.util.Date;

public class album {
    Integer sifra, brojPjesama;
    String naziv;
    Date datIzd;

    public Integer getSifra() {
        return sifra;
    }

    public void setSifra(Integer sifra) {
        this.sifra = sifra;
    }

    public Integer getBrojPjesama() {
        return brojPjesama;
    }

    public void setBrojPjesama(Integer brojPjesama) {
        this.brojPjesama = brojPjesama;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatIzd() {
        return datIzd;
    }

    public void setDatIzd(Date datIzd) {
        this.datIzd = datIzd;
    }

    public album(Integer sifra, Integer brojPjesama, String naziv, Date datIzd) {
        this.sifra = sifra;
        this.brojPjesama = brojPjesama;
        this.naziv = naziv;
        this.datIzd = datIzd;
    }
}
