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
    public TabPane paneIzvodjac, panePjesma;

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
    //Connection
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    private void handleButtonAction(ActionEvent event){
        if(event.getSource()==btnPjesma){
            panePjesma.setVisible(true);
            paneIzvodjac.setVisible(false);
        }
        else if(event.getSource()==btnIzvodjac) {
            paneIzvodjac.setVisible(true);
            panePjesma.setVisible(false);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        panePjesma.setVisible(true);
        paneIzvodjac.setVisible(false);
        updateIzvodjacTable();
        pretraziIzvodjace();
    }

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
            System.out.println("Successful");
        } catch (Exception e){
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
        String prezime = tfUIprezime.getText();
        String umjIme = tfUIumjIme.getText();
        String adresa = tfUIadresa.getText();
        String kontakt = tfUIkontakt.getText();
        Date datRodj = java.sql.Date.valueOf(dpUIdatRodj.getValue());


        String sql = "UPDATE izvodjac SET imeIzvodjac='"+ime+"', prezimeIzvodjac ='"+prezime+"', umjImeIzvodjac ='"+umjIme+"'," +
                "datRodjIzvodjac='"+datRodj+"',adresaIzvodjac='"+adresa+"', kontaktIzvodjac='"+kontakt+"' WHERE sifraIzvodjac='"+sifra+"';";

            pst = conn.prepareStatement(sql);
            pst.execute();
            System.out.println("Successful");
        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
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
                System.out.println("Successful");
            }
            else{
                System.out.println("False");
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
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





}