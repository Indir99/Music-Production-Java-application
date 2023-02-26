package com.example.musicproductionv2;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    //Panes
    public TabPane paneIzvodjac, panePjesma, paneTekstopisac, paneAranzer, paneKompozitor;

    // Menu buttons
    public Button btnPjesma, btnIzvodjac, btnTekstopisac, btnAranzer, btnKompozitor;
    public Button btnOsoba, btnZanr, btnAlbum, btnSpot, btnFunkcija;



    // Izvodjac - table
    public TableView<izvodjac> tableIzvodjac;
    public TableColumn<izvodjac,Integer> tcSifraIzvodjac;
    public TableColumn<izvodjac,String> tcImeIzvodjac, tcPrezimeIzvodjac, tcUmjImeIzvodjac, tcAdresaIzvodjac, tcKontaktIzvodjac;
    public TableColumn<izvodjac, Date> tcDatRodjIzvodjac;
    ObservableList<izvodjac> listIzvodjac;
    ObservableList<izvodjac> dataListIzvodjac;
    // Dodaj izvodjaca
    public TextField tfDIime, tfDIprezime, tfDIumjIme, tfDIadresa, tfDIkontakt;
    public DatePicker dpDIdatRodj;
    public Button btnDodajIzvodjaca;
    //Uredi izvodjaca
    public TextField tfUIsifra, tfUIime, tfUIprezime, tfUIumjIme, tfUIadresa, tfUIkontakt;
    public DatePicker dpUIdatRodj;
    public Button btnUrediIzvodjaca;
    //Izbrisi izvodjaca
    public TextField tfIIsifra;
    public Button btnIzbrisiIzvodjaca;
    //Pretrazi izvodjaca:
    public TextField tfPIfilter;

    // Tekstopisac - table
    public TableView<tekstopisac> tableTekstopisac;
    public TableColumn<tekstopisac,Integer> tcSifraTekstopisac;
    public TableColumn<tekstopisac,String> tcImeTekstopisac, tcPrezimeTekstopisac, tcUmjImeTekstopisac, tcAdresaTekstopisac, tcKontaktTekstopisac;
    public TableColumn<tekstopisac, Date> tcDatRodjTekstopisac;
    ObservableList<tekstopisac> listTekstopisac;
    ObservableList<tekstopisac> dataListTekstopisac;
    // Dodaj tekstopisca
    public TextField tfDTime, tfDTprezime, tfDTumjIme, tfDTadresa, tfDTkontakt;
    public DatePicker dpDTdatRodj;
    public Button btnDodajTekstopisca;
    //Uredi tekstopisca
    public TextField tfUTsifra, tfUTime, tfUTprezime, tfUTumjIme, tfUTadresa, tfUTkontakt;
    public DatePicker dpUTdatRodj;
    public Button btnUrediTekstopisca;
    //Izbrisi tekstopisca
    public TextField tfITsifra;
    public Button btnIzbrisiTekstopisca;
    //Pretrazi tekstopisca:
    public TextField tfPTfilter;


    // Aranzer - table
    public TableView<aranzer> tableAranzer;
    public TableColumn<aranzer,Integer> tcSifraAranzer;
    public TableColumn<aranzer,String> tcImeAranzer, tcPrezimeAranzer, tcUmjImeAranzer, tcAdresaAranzer, tcKontaktAranzer;
    public TableColumn<aranzer, Date> tcDatRodjAranzer;
    ObservableList<aranzer> listAranzer;
    ObservableList<aranzer> dataListAranzer;
    // Dodaj aranzera
    public TextField tfDAime, tfDAprezime, tfDAumjIme, tfDAadresa, tfDAkontakt;
    public DatePicker dpDAdatRodj;
    public Button btnDodajAranzera;
    //Uredi aranzera
    public TextField tfUAsifra, tfUAime, tfUAprezime, tfUAumjIme, tfUAadresa, tfUAkontakt;
    public DatePicker dpUAdatRodj;
    public Button btnUrediAranzera;
    //Izbrisi aranzera
    public TextField tfIAsifra;
    public Button btnIzbrisiAranzera;
    //Pretrazi izvodjaca:
    public TextField tfPAfilter;


    // Kompozitor - table
    public TableView<kompozitor> tableKompozitor;
    public TableColumn<kompozitor,Integer> tcSifraKompozitor;
    public TableColumn<kompozitor,String> tcImeKompozitor, tcPrezimeKompozitor, tcUmjImeKompozitor, tcAdresaKompozitor, tcKontaktKompozitor;
    public TableColumn<kompozitor, Date> tcDatRodjKompozitor;
    ObservableList<kompozitor> listKompozitor;
    ObservableList<kompozitor> dataListKompozitor;
    // Dodaj kompozitora
    public TextField tfDKime, tfDKprezime, tfDKumjIme, tfDKadresa, tfDKkontakt;
    public DatePicker dpDKdatRodj;
    public Button btnDodajKompozitora;
    //Uredi kompozitora
    public TextField tfUKsifra, tfUKime, tfUKprezime, tfUKumjIme, tfUKadresa, tfUKkontakt;
    public DatePicker dpUKdatRodj;
    public Button btnUrediKompozitora;
    //Izbrisi kompozitora
    public TextField tfIKsifra;
    public Button btnIzbrisiKompozitora;
    //Pretrazi kompozitora:
    public TextField tfPKfilter;

    //Connection
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;


    // Handle buttons
    @FXML
    private void handleButtonAction(ActionEvent event){
        if(event.getSource()==btnPjesma){
            panePjesma.setVisible(true);
            paneIzvodjac.setVisible(false);
            paneTekstopisac.setVisible(false);
            paneAranzer.setVisible(false);
            paneKompozitor.setVisible(false);
        }
        else if(event.getSource()==btnIzvodjac) {
            paneIzvodjac.setVisible(true);
            panePjesma.setVisible(false);
            paneTekstopisac.setVisible(false);
            paneAranzer.setVisible(false);
            paneKompozitor.setVisible(false);
        }
        else if(event.getSource()==btnTekstopisac) {
            paneTekstopisac.setVisible(true);
            panePjesma.setVisible(false);
            paneIzvodjac.setVisible(false);
            paneAranzer.setVisible(false);
            paneKompozitor.setVisible(false);
        }
        else if(event.getSource()==btnAranzer){
            paneAranzer.setVisible(true);
            panePjesma.setVisible(false);
            paneIzvodjac.setVisible(false);
            paneTekstopisac.setVisible(false);
            paneKompozitor.setVisible(false);
        }
        else if(event.getSource()==btnKompozitor){
            paneKompozitor.setVisible(true);
            panePjesma.setVisible(false);
            paneIzvodjac.setVisible(false);
            paneTekstopisac.setVisible(false);
            paneAranzer.setVisible(false);
        }

    }

    // initialize
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        panePjesma.setVisible(true);
        paneIzvodjac.setVisible(false);
        paneTekstopisac.setVisible(false);
        paneAranzer.setVisible(false);
        paneKompozitor.setVisible(false);

        updateIzvodjacTable();
        pretraziIzvodjace();

        updateTekstopisacTable();
        pretraziTekstopisce();

        updateAranzerTable();
        pretraziAranzere();

        updateKompozitorTable();
        pretraziKompozitore();


    }

    /* ----------------------------------------------- izvodjac ------------------------------------------*/
    public void dodajIzvodjaca() {
        conn = HelloApplication.ConnectDb();
        String sql = "INSERT INTO izvodjac (imeIzvodjac, prezimeIzvodjac, umjImeIzvodjac, datRodjIzvodjac, adresaIzvodjac, kontaktIzvodjac) VALUES (?,?,?,?,?,?)";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,tfDIime.getText());
            pst.setString(2,tfDIprezime.getText());
            pst.setString(3,tfDIumjIme.getText());
            pst.setDate(4, java.sql.Date.valueOf(dpDIdatRodj.getValue()));
            pst.setString(5,tfDIadresa.getText());
            pst.setString(6,tfDIkontakt.getText());
            pst.execute();

            AlertBox.display("Dodaj izvođača","Uspješno ste dodali izvođača.");

        } catch (Exception e){
            AlertBox.display("Dodaj izvođača","Error: Provjerite da li su sva polja ispravno popunjena.");
            System.out.println(e.fillInStackTrace());
        }
        updateIzvodjacTable();
        pretraziIzvodjace();
    }

    public void urediIzvodjaca(){
        try {
        conn = HelloApplication.ConnectDb();
        Integer sifra = Integer.valueOf(tfUIsifra.getText());
        String ime = tfUIime.getText();
        if(!(ime.isEmpty()))
        {
            String sql = "UPDATE izvodjac SET imeIzvodjac = '"+ime+"' WHERE sifraIzvodjac ='"+sifra+"';";
            pst = conn.prepareStatement(sql);
            pst.execute();
        }
        String prezime = tfUIprezime.getText();
        if(!(prezime.isEmpty()))
        {
            String sql = "UPDATE izvodjac SET prezimeIzvodjac = '"+prezime+"' WHERE sifraIzvodjac ='"+sifra+"';";
            pst = conn.prepareStatement(sql);
            pst.execute();
        }
        String umjIme = tfUIumjIme.getText();
        if(!(umjIme.isEmpty()))
        {
            String sql = "UPDATE izvodjac SET umjImeIzvodjac = '"+umjIme+"' WHERE sifraIzvodjac ='"+sifra+"';";
            pst = conn.prepareStatement(sql);
            pst.execute();
        }
        String adresa = tfUIadresa.getText();
        if(!(adresa.isEmpty()))
        {
            String sql = "UPDATE izvodjac SET adresaIzvodjac = '"+adresa+"' WHERE sifraIzvodjac ='"+sifra+"';";
            pst = conn.prepareStatement(sql);
            pst.execute();
        }
        String kontakt = tfUIkontakt.getText();
        if(!(kontakt.isEmpty()))
        {
            String sql = "UPDATE izvodjac SET kontaktIzvodjac = '"+kontakt+"' WHERE sifraIzvodjac ='"+sifra+"';";
            pst = conn.prepareStatement(sql);
            pst.execute();
        }
        Date datRodj = java.sql.Date.valueOf(dpUIdatRodj.getValue());
        if(datRodj != null)
        {
            String sql = "UPDATE izvodjac SET datRodjIzvodjac='"+datRodj+"' WHERE sifraIzvodjac ='"+sifra+"';";
            pst = conn.prepareStatement(sql);
            pst.execute();
        }
            AlertBox.display("Uredi izvođača","Uspješno ste izmijenili podatke izvođača.");
        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Uredi izvođača","Error: Neuspješna izmjena.");
        }
        updateIzvodjacTable();
        pretraziIzvodjace();
    }

    public void updateIzvodjacTable(){
        try {
            tcSifraIzvodjac.setCellValueFactory(new PropertyValueFactory<izvodjac, Integer>("sifra"));
            tcImeIzvodjac.setCellValueFactory(new PropertyValueFactory<izvodjac, String>("Ime"));
            tcPrezimeIzvodjac.setCellValueFactory(new PropertyValueFactory<izvodjac, String>("Prezime"));
            tcUmjImeIzvodjac.setCellValueFactory(new PropertyValueFactory<izvodjac, String>("UmjIme"));
            tcAdresaIzvodjac.setCellValueFactory(new PropertyValueFactory<izvodjac, String>("Adresa"));
            tcKontaktIzvodjac.setCellValueFactory(new PropertyValueFactory<izvodjac, String>("Kontakt"));
            tcDatRodjIzvodjac.setCellValueFactory(new PropertyValueFactory<izvodjac, Date>("DatRodj"));
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        try {
            listIzvodjac = HelloApplication.getDataIzvodjac();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableIzvodjac.setItems(listIzvodjac);
    }

    public void izbrisiIzvodjaca() {
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfIIsifra.getText());
            if(checkID(sifra)) {
                String sql = "DELETE FROM izvodjac WHERE sifraIzvodjac='"+sifra+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                updateIzvodjacTable();
                pretraziIzvodjace();
                AlertBox.display("Izbriši izvođača","Uspješno ste izbrisali izvođača.");
            }
            else{
                AlertBox.display("Izbriši izvođača","Error: Pogrešno unesen ID.");
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Izbriši izvođača","Error: Neuspješno brisanje.");
        }
    }

    public void pretraziIzvodjace(){
        tcSifraIzvodjac.setCellValueFactory(new PropertyValueFactory<izvodjac, Integer>("sifra"));
        tcImeIzvodjac.setCellValueFactory(new PropertyValueFactory<izvodjac, String>("Ime"));
        tcPrezimeIzvodjac.setCellValueFactory(new PropertyValueFactory<izvodjac, String>("Prezime"));
        tcUmjImeIzvodjac.setCellValueFactory(new PropertyValueFactory<izvodjac, String>("UmjIme"));
        tcAdresaIzvodjac.setCellValueFactory(new PropertyValueFactory<izvodjac, String>("Adresa"));
        tcKontaktIzvodjac.setCellValueFactory(new PropertyValueFactory<izvodjac, String>("Kontakt"));
        tcDatRodjIzvodjac.setCellValueFactory(new PropertyValueFactory<izvodjac, Date>("DatRodj"));
        try {
            dataListIzvodjac = HelloApplication.getDataIzvodjac();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableIzvodjac.setItems(dataListIzvodjac);
        FilteredList<izvodjac> filteredData = new FilteredList<>(dataListIzvodjac, b -> true);
        tfPIfilter.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if(person.getIme().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(person.getPrezime().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(person.getUmjIme().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(person.getAdresa().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(person.getKontakt().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                //else if(person.getSifra() == Integer.valueOf(tfPIfilter.getText())) {
                //    return true;
                //}
                else{
                    return false;
                }
            });
        } ));
        SortedList<izvodjac> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableIzvodjac.comparatorProperty());
        tableIzvodjac.setItems(sortedData);
    }
    private boolean checkID(Integer sifra) {
        for (izvodjac singer : listIzvodjac) {
            if (sifra == singer.getSifra()) {
                return true;
            }
        }
        return false;
    }



    /* ----------------------------------------------- tekstopisac ------------------------------------------*/
    public void dodajTekstopisca() {
        conn = HelloApplication.ConnectDb();
        String sql = "INSERT INTO tekstopisac (imeTekstopisac, prezimeTekstopisac, umjImeTekstopisac, datRodjTekstopisac, adresaTekstopisac, kontaktTekstopisac) VALUES (?,?,?,?,?,?)";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,tfDTime.getText());
            pst.setString(2,tfDTprezime.getText());
            pst.setString(3,tfDTumjIme.getText());
            pst.setDate(4, java.sql.Date.valueOf(dpDTdatRodj.getValue()));
            pst.setString(5,tfDTadresa.getText());
            pst.setString(6,tfDTkontakt.getText());
            pst.execute();

            AlertBox.display("Dodaj tekstopisca","Uspješno ste dodali tekstopisca.");

        } catch (Exception e){
            AlertBox.display("Dodaj tekstopisca","Error: Provjerite da li su sva polja ispravno popunjena.");
            System.out.println(e.fillInStackTrace());
        }
        updateTekstopisacTable();
        pretraziTekstopisce();
    }

    public void urediTekstopisca(){
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfUTsifra.getText());
            String ime = tfUTime.getText();
            if(!(ime.isEmpty()))
            {
                String sql = "UPDATE tekstopisac SET imeTekstopisac = '"+ime+"' WHERE sifraTekstopisac ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            String prezime = tfUTprezime.getText();
            if(!(prezime.isEmpty()))
            {
                String sql = "UPDATE tekstopisac SET prezimeTekstopisac = '"+prezime+"' WHERE sifraTekstopisac ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            String umjIme = tfUTumjIme.getText();
            if(!(umjIme.isEmpty()))
            {
                String sql = "UPDATE tekstopisac SET umjImeTekstopisac = '"+umjIme+"' WHERE sifraTekstopisac ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            String adresa = tfUTadresa.getText();
            if(!(adresa.isEmpty()))
            {
                String sql = "UPDATE tekstopisac SET adresaTekstopisac = '"+adresa+"' WHERE sifraTekstopisac ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            String kontakt = tfUIkontakt.getText();
            if(!(kontakt.isEmpty()))
            {
                String sql = "UPDATE tekstopisac SET kontaktTekstopisac = '"+kontakt+"' WHERE sifraTekstopisac ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            Date datRodj = java.sql.Date.valueOf(dpUIdatRodj.getValue());
            if(datRodj != null)
            {
                String sql = "UPDATE tekstopisac SET datRodjTekstopisac='"+datRodj+"' WHERE sifraTekstopisac ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            AlertBox.display("Uredi tekstopisca","Uspješno ste izmijenili podatke tekstopisca.");
        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Uredi tekstopisca","Error: Neuspješna izmjena.");
        }
        updateTekstopisacTable();
        pretraziTekstopisce();
    }

    public void updateTekstopisacTable(){
        try {
            tcSifraTekstopisac.setCellValueFactory(new PropertyValueFactory<tekstopisac, Integer>("sifra"));
            tcImeTekstopisac.setCellValueFactory(new PropertyValueFactory<tekstopisac, String>("Ime"));
            tcPrezimeTekstopisac.setCellValueFactory(new PropertyValueFactory<tekstopisac, String>("Prezime"));
            tcUmjImeTekstopisac.setCellValueFactory(new PropertyValueFactory<tekstopisac, String>("UmjIme"));
            tcAdresaTekstopisac.setCellValueFactory(new PropertyValueFactory<tekstopisac, String>("Adresa"));
            tcKontaktTekstopisac.setCellValueFactory(new PropertyValueFactory<tekstopisac, String>("Kontakt"));
            tcDatRodjTekstopisac.setCellValueFactory(new PropertyValueFactory<tekstopisac, Date>("DatRodj"));
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        try {
            listTekstopisac = HelloApplication.getDataTekstopisac();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableTekstopisac.setItems(listTekstopisac);
    }

    public void izbrisiTekstopisca() {
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfIIsifra.getText());
            if(checkIDtekstopisac(sifra)) {
                String sql = "DELETE FROM tekstopisac WHERE sifraTekstopisac='"+sifra+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                updateTekstopisacTable();
                pretraziTekstopisce();
                AlertBox.display("Izbriši tekstopisca","Uspješno ste izbrisali tekstopisca.");
            }
            else{
                AlertBox.display("Izbriši tekstopisca","Error: Pogrešno unesen ID.");
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Izbriši tekstopisca","Error: Neuspješno brisanje.");
        }
    }

    public void pretraziTekstopisce(){
        tcSifraTekstopisac.setCellValueFactory(new PropertyValueFactory<tekstopisac, Integer>("sifra"));
        tcImeTekstopisac.setCellValueFactory(new PropertyValueFactory<tekstopisac, String>("Ime"));
        tcPrezimeTekstopisac.setCellValueFactory(new PropertyValueFactory<tekstopisac, String>("Prezime"));
        tcUmjImeTekstopisac.setCellValueFactory(new PropertyValueFactory<tekstopisac, String>("UmjIme"));
        tcAdresaTekstopisac.setCellValueFactory(new PropertyValueFactory<tekstopisac, String>("Adresa"));
        tcKontaktTekstopisac.setCellValueFactory(new PropertyValueFactory<tekstopisac, String>("Kontakt"));
        tcDatRodjTekstopisac.setCellValueFactory(new PropertyValueFactory<tekstopisac, Date>("DatRodj"));
        try {
            dataListTekstopisac = HelloApplication.getDataTekstopisac();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableTekstopisac.setItems(dataListTekstopisac);
        FilteredList<tekstopisac> filteredData = new FilteredList<>(dataListTekstopisac, b -> true);
        tfPTfilter.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if(person.getIme().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(person.getPrezime().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(person.getUmjIme().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(person.getAdresa().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(person.getKontakt().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                //else if(person.getSifra() == Integer.valueOf(tfPIfilter.getText())) {
                //    return true;
                //}
                else{
                    return false;
                }
            });
        } ));
        SortedList<tekstopisac> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableTekstopisac.comparatorProperty());
        tableTekstopisac.setItems(sortedData);
    }
    private boolean checkIDtekstopisac(Integer sifra) {
        for (tekstopisac singer : listTekstopisac) {
            if (sifra == singer.getSifra()) {
                return true;
            }
        }
        return false;
    }


    /* ----------------------------------------------- aranzer ------------------------------------------*/

    public void dodajAranzera() {
        conn = HelloApplication.ConnectDb();
        String sql = "INSERT INTO aranzer (imeAranzer, prezimeAranzer, umjImeAranzer, datRodjAranzer, adresaAranzer, kontaktAranzer) VALUES (?,?,?,?,?,?)";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,tfDAime.getText());
            pst.setString(2,tfDAprezime.getText());
            pst.setString(3,tfDAumjIme.getText());
            pst.setDate(4, java.sql.Date.valueOf(dpDAdatRodj.getValue()));
            pst.setString(5,tfDAadresa.getText());
            pst.setString(6,tfDAkontakt.getText());
            pst.execute();

            AlertBox.display("Dodaj aranžera","Uspješno ste dodali aranžera.");

        } catch (Exception e){
            AlertBox.display("Dodaj aranžera","Error: Provjerite da li su sva polja ispravno popunjena.");
            System.out.println(e.fillInStackTrace());
        }
        updateAranzerTable();
        pretraziAranzere();
    }

    public void urediAranzera(){
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfUAsifra.getText());
            String ime = tfUAime.getText();
            if(!(ime.isEmpty()))
            {
                String sql = "UPDATE aranzer SET imeAranzer = '"+ime+"' WHERE sifraAranzer ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            String prezime = tfUAprezime.getText();
            if(!(prezime.isEmpty()))
            {
                String sql = "UPDATE aranzer SET prezimeAranzer = '"+prezime+"' WHERE sifraAranzer ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            String umjIme = tfUAumjIme.getText();
            if(!(umjIme.isEmpty()))
            {
                String sql = "UPDATE aranzer SET umjImeAranzer = '"+umjIme+"' WHERE sifraAranzer ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            String adresa = tfUAadresa.getText();
            if(!(adresa.isEmpty()))
            {
                String sql = "UPDATE aranzer SET adresaAranzer = '"+adresa+"' WHERE sifraAranzer ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            String kontakt = tfUAkontakt.getText();
            if(!(kontakt.isEmpty()))
            {
                String sql = "UPDATE aranzer SET kontaktAranzer = '"+kontakt+"' WHERE sifraAranzer ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            Date datRodj = java.sql.Date.valueOf(dpUAdatRodj.getValue());
            if(datRodj != null)
            {
                String sql = "UPDATE aranzer SET datRodjAranzer='"+datRodj+"' WHERE sifraAranzer ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            AlertBox.display("Uredi aranžera","Uspješno ste izmijenili podatke aranžera.");
        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Uredi aranžera","Error: Neuspješna izmjena.");
        }
        updateAranzerTable();
        pretraziAranzere();
    }

    public void updateAranzerTable(){
        try {
            tcSifraAranzer.setCellValueFactory(new PropertyValueFactory<aranzer, Integer>("sifra"));
            tcImeAranzer.setCellValueFactory(new PropertyValueFactory<aranzer, String>("Ime"));
            tcPrezimeAranzer.setCellValueFactory(new PropertyValueFactory<aranzer, String>("Prezime"));
            tcUmjImeAranzer.setCellValueFactory(new PropertyValueFactory<aranzer, String>("UmjIme"));
            tcAdresaAranzer.setCellValueFactory(new PropertyValueFactory<aranzer, String>("Adresa"));
            tcKontaktAranzer.setCellValueFactory(new PropertyValueFactory<aranzer, String>("Kontakt"));
            tcDatRodjAranzer.setCellValueFactory(new PropertyValueFactory<aranzer, Date>("DatRodj"));
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        try {
            listAranzer = HelloApplication.getDataAranzer();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableAranzer.setItems(listAranzer);
    }

    public void izbrisiAranzera() {
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfIAsifra.getText());
            if(checkIDaranzer(sifra)) {
                String sql = "DELETE FROM aranzer WHERE sifraAranzer='"+sifra+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                updateAranzerTable();
                pretraziAranzere();
                AlertBox.display("Izbriši aranžera","Uspješno ste izbrisali aranžera.");
            }
            else{
                AlertBox.display("Izbriši aranžera","Error: Pogrešno unesen ID.");
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Izbriši aranžera","Error: Neuspješno brisanje.");
        }
    }

    public void pretraziAranzere(){
        tcSifraAranzer.setCellValueFactory(new PropertyValueFactory<aranzer, Integer>("sifra"));
        tcImeAranzer.setCellValueFactory(new PropertyValueFactory<aranzer, String>("Ime"));
        tcPrezimeAranzer.setCellValueFactory(new PropertyValueFactory<aranzer, String>("Prezime"));
        tcUmjImeAranzer.setCellValueFactory(new PropertyValueFactory<aranzer, String>("UmjIme"));
        tcAdresaAranzer.setCellValueFactory(new PropertyValueFactory<aranzer, String>("Adresa"));
        tcKontaktAranzer.setCellValueFactory(new PropertyValueFactory<aranzer, String>("Kontakt"));
        tcDatRodjAranzer.setCellValueFactory(new PropertyValueFactory<aranzer, Date>("DatRodj"));
        try {
            dataListAranzer = HelloApplication.getDataAranzer();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableAranzer.setItems(dataListAranzer);
        FilteredList<aranzer> filteredData = new FilteredList<>(dataListAranzer, b -> true);
        tfPAfilter.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if(person.getIme().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(person.getPrezime().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(person.getUmjIme().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(person.getAdresa().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(person.getKontakt().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                //else if(person.getSifra() == Integer.valueOf(tfPIfilter.getText())) {
                //    return true;
                //}
                else{
                    return false;
                }
            });
        } ));
        SortedList<aranzer> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableAranzer.comparatorProperty());
        tableAranzer.setItems(sortedData);
    }
    private boolean checkIDaranzer(Integer sifra) {
        for (aranzer singer : listAranzer) {
            if (sifra == singer.getSifra()) {
                return true;
            }
        }
        return false;
    }

    /* ----------------------------------------------- kompozitor ------------------------------------------*/


    public void dodajKompozitora() {
        conn = HelloApplication.ConnectDb();
        String sql = "INSERT INTO kompozitor (imeKompozitor, prezimeKompozitor, umjImeKompozitor, datRodjKompozitor, adresaKompozitor, kontaktKompozitor) VALUES (?,?,?,?,?,?)";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,tfDKime.getText());
            pst.setString(2,tfDKprezime.getText());
            pst.setString(3,tfDKumjIme.getText());
            pst.setDate(4, java.sql.Date.valueOf(dpDKdatRodj.getValue()));
            pst.setString(5,tfDKadresa.getText());
            pst.setString(6,tfDKkontakt.getText());
            pst.execute();

            AlertBox.display("Dodaj kompozitora","Uspješno ste dodali kompozitora.");

        } catch (Exception e){
            AlertBox.display("Dodaj kompozitora","Error: Provjerite da li su sva polja ispravno popunjena.");
            System.out.println(e.fillInStackTrace());
        }
        updateKompozitorTable();
        pretraziKompozitore();
    }

    public void urediKompozitora(){
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfUKsifra.getText());
            String ime = tfUKime.getText();
            if(!(ime.isEmpty()))
            {
                String sql = "UPDATE kompozitor SET imeKompozitor = '"+ime+"' WHERE sifraKompozitor ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            String prezime = tfUKprezime.getText();
            if(!(prezime.isEmpty()))
            {
                String sql = "UPDATE kompozitor SET prezimeKompozitor = '"+prezime+"' WHERE sifraKompozitor ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            String umjIme = tfUKumjIme.getText();
            if(!(umjIme.isEmpty()))
            {
                String sql = "UPDATE kompozitor SET umjImeKompozitor = '"+umjIme+"' WHERE sifraKompozitor ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            String adresa = tfUKadresa.getText();
            if(!(adresa.isEmpty()))
            {
                String sql = "UPDATE kompozitor SET adresaKompozitor = '"+adresa+"' WHERE sifraKompozitor ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            String kontakt = tfUKkontakt.getText();
            if(!(kontakt.isEmpty()))
            {
                String sql = "UPDATE kompozitor SET kontaktKompozitor = '"+kontakt+"' WHERE sifraKompozitor ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            Date datRodj = java.sql.Date.valueOf(dpUKdatRodj.getValue());
            if(datRodj != null)
            {
                String sql = "UPDATE kompozitor SET datRodjKompozitor='"+datRodj+"' WHERE sifraKompozitor ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            AlertBox.display("Uredi kompozitora","Uspješno ste izmijenili podatke kompozitora.");
        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Uredi kompozitora","Error: Neuspješna izmjena.");
        }
        updateKompozitorTable();
        pretraziKompozitore();
    }

    public void updateKompozitorTable(){
        try {
            tcSifraKompozitor.setCellValueFactory(new PropertyValueFactory<kompozitor, Integer>("sifra"));
            tcImeKompozitor.setCellValueFactory(new PropertyValueFactory<kompozitor, String>("Ime"));
            tcPrezimeKompozitor.setCellValueFactory(new PropertyValueFactory<kompozitor, String>("Prezime"));
            tcUmjImeKompozitor.setCellValueFactory(new PropertyValueFactory<kompozitor, String>("UmjIme"));
            tcAdresaKompozitor.setCellValueFactory(new PropertyValueFactory<kompozitor, String>("Adresa"));
            tcKontaktKompozitor.setCellValueFactory(new PropertyValueFactory<kompozitor, String>("Kontakt"));
            tcDatRodjKompozitor.setCellValueFactory(new PropertyValueFactory<kompozitor, Date>("DatRodj"));
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        try {
            listKompozitor = HelloApplication.getDataKompozitor();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableKompozitor.setItems(listKompozitor);
    }

    public void izbrisiKompozitora() {
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfIKsifra.getText());
            if(checkIDkompozitor(sifra)) {
                String sql = "DELETE FROM kompozitor WHERE sifraKompozitor='"+sifra+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                updateKompozitorTable();
                pretraziKompozitore();
                AlertBox.display("Izbriši kompozitora","Uspješno ste izbrisali kompozitora.");
            }
            else{
                AlertBox.display("Izbriši kompozitora","Error: Pogrešno unesen ID.");
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Izbriši kompozitora","Error: Neuspješno brisanje.");
        }
    }

    public void pretraziKompozitore(){
        tcSifraKompozitor.setCellValueFactory(new PropertyValueFactory<kompozitor, Integer>("sifra"));
        tcImeKompozitor.setCellValueFactory(new PropertyValueFactory<kompozitor, String>("Ime"));
        tcPrezimeKompozitor.setCellValueFactory(new PropertyValueFactory<kompozitor, String>("Prezime"));
        tcUmjImeKompozitor.setCellValueFactory(new PropertyValueFactory<kompozitor, String>("UmjIme"));
        tcAdresaKompozitor.setCellValueFactory(new PropertyValueFactory<kompozitor, String>("Adresa"));
        tcKontaktKompozitor.setCellValueFactory(new PropertyValueFactory<kompozitor, String>("Kontakt"));
        tcDatRodjKompozitor.setCellValueFactory(new PropertyValueFactory<kompozitor, Date>("DatRodj"));
        try {
            dataListKompozitor = HelloApplication.getDataKompozitor();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableKompozitor.setItems(dataListKompozitor);
        FilteredList<kompozitor> filteredData = new FilteredList<>(dataListKompozitor, b -> true);
        tfPKfilter.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if(person.getIme().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(person.getPrezime().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(person.getUmjIme().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(person.getAdresa().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(person.getKontakt().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                //else if(person.getSifra() == Integer.valueOf(tfPIfilter.getText())) {
                //    return true;
                //}
                else{
                    return false;
                }
            });
        } ));
        SortedList<kompozitor> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableKompozitor.comparatorProperty());
        tableKompozitor.setItems(sortedData);
    }
    private boolean checkIDkompozitor(Integer sifra) {
        for (kompozitor singer : listKompozitor) {
            if (sifra == singer.getSifra()) {
                return true;
            }
        }
        return false;
    }
}