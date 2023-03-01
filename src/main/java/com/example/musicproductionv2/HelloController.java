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

import static java.lang.String.valueOf;

public class HelloController implements Initializable {

    //Panes
    public TabPane paneIzvodjac, panePjesma, paneTekstopisac, paneAranzer, paneKompozitor, paneOsoba, paneZanr, paneAlbum;
    public TabPane paneSpot, paneFunkcija;

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



    // Osoba - table
    public TableView<osoba> tableOsoba;
    public TableColumn<osoba,Integer> tcSifraOsoba;
    public TableColumn<osoba,String> tcImeOsoba, tcPrezimeOsoba, tcZanimanjeOsoba, tcAdresaOsoba, tcKontaktOsoba;
    public TableColumn<osoba, Date> tcDatRodjOsoba;
    ObservableList<osoba> listOsoba;
    ObservableList<osoba> dataListOsoba;
    // Dodaj osobu
    public TextField tfDOime, tfDOprezime, tfDOzanimanje, tfDOadresa, tfDOkontakt;
    public DatePicker dpDOdatRodj;
    public Button btnDodajOsobu;
    //Uredi osobu
    public TextField tfUOsifra, tfUOime, tfUOprezime, tfUOzanimanje, tfUOadresa, tfUOkontakt;
    public DatePicker dpUOdatRodj;
    public Button btnUrediOsobu;
    //Izbrisi osobu
    public TextField tfIOsifra;
    public Button btnIzbrisiOsobu;
    //Pretrazi osobu:
    public TextField tfPOfilter;

    // Zanr - table
    public TableView<zanr> tableZanr;
    public TableColumn<zanr,Integer> tcSifraZanr;
    public TableColumn<zanr,String> tcNazivZanr, tcKraticaZanr;
    ObservableList<zanr> listZanr;
    ObservableList<zanr> dataListZanr;
    // Dodaj zanr
    public TextField tfDZnaziv, tfDZkratica;
    public Button btnDodajZanr;
    //Uredi zanr
    public TextField tfUZsifra, tfUZnaziv, tfUZkratica;
    public Button btnUrediZanr;
    //Izbrisi zanr
    public TextField tfIZsifra;
    public Button btnIzbrisiZanr;
    //Pretrazi zanr:
    public TextField tfPZfilter;


    // Album - table
    public TableView<album> tableAlbum;
    public TableColumn<album,Integer> tcSifraAlbum, tcBrojPjesamaAlbum;
    public TableColumn<album,String> tcNazivAlbum;
    public TableColumn<album, Date> tcDatIzdAlbum;
    ObservableList<album> listAlbum;
    ObservableList<album> dataListAlbum;
    // Dodaj album
    public TextField tfDAnaziv, tfDAbrojPjesama;
    public DatePicker dpDAdatIzd;
    public Button btnDodajAlbum;
    //Uredi album
    public TextField tfUAsifraAlbum, tfUAnaziv, tfUAbrojPjesama;
    public DatePicker dpUAdatIzd;
    public Button btnUrediAlbum;
    //Izbrisi osobu
    public TextField tfIAsifraAlbum;
    public Button btnIzbrisiAlbum;
    //Pretrazi osobu:
    public TextField tfPAlbumFilter;



    // Spot - table
    public TableView<spot> tableSpot;
    public TableColumn<spot,Integer> tcSifraSpot, tcSifraPjesmaSpot, tcSifraIzvodjacSpot, tcSifraAlbumSpot;
    public TableColumn<spot,String> tcLokacijaSpot;
    public TableColumn<spot, Date> tcDatSnimanjaSpot;
    ObservableList<spot> listSpot;
    ObservableList<spot> dataListSpot;
    // Dodaj spot
    public TextField tfDSsifraPjesma, tfDSsifraIzvodjac, tfDSsifraAlbum, tfDSlokacija;
    public DatePicker dpDSdatSnim;
    public Button btnDodajSpot;
    //Uredi spot
    public TextField tfUSsifraSpot, tfUSsifraPjesma, tfUSsifraIzvodjac, tfUSsifraAlbum, tfUSlokacija;
    public DatePicker dpUSdatSnim;
    public Button btnUrediSpot;
    //Izbrisi spot
    public TextField tfISsifraSpot;
    public Button btnIzbrisiSpot;
    //Pretrazi spot:
    public TextField tfPSfilter;


    // Funkcija - table
    public TableView<funkcija> tableFunkcija;
    public TableColumn<funkcija,Integer> tcSifraFunkcija;
    public TableColumn<funkcija,String> tcNazivFunkcija;
    ObservableList<funkcija> listFunkcija;
    ObservableList<funkcija> dataListFunkcija;
    // Dodaj funkciju
    public TextField tfDFnaziv;
    public Button btnDodajFunkciju;
    //Uredi funkciju
    public TextField tfUFsifra, tfUFnaziv;
    public Button btnUrediFunkciju;
    //Izbrisi funkciju
    public TextField tfIFsifra;
    public Button btnIzbrisiFunkciju;
    //Pretrazi funkciju:
    public TextField tfPFfilter;

    // Pjesma - table
    public TableView<pjesma> tablePjesma;
    public TableColumn<pjesma,Integer> tcSifraPjesma,tcSifraIzvodjacPjesma,tcSifraAlbumPjesma, tcSifraSpotPjesma;
    public TableColumn<pjesma,Integer> tcSifraTekstopisacPjesma,tcSifraKompozitorPjesma,tcSifraAranzerPjesma, tcSifraZanrPjesma;
    public TableColumn<pjesma,String> tcNazivPjesma, tcJezikPjesma;
    public TableColumn<pjesma, Date> tcDatumIzdavanjaPjesma;
    ObservableList<pjesma> listPjesma;
    ObservableList<pjesma> dataListPjesma;
    // Dodaj pjesmu
    public TextField tfDPsifraIzvodjac, tfDPsifraAlbum, tfDPsifraSpot, tfDPnaziv, tfDPjezik, tfDPsifraTekstopisac;
    public TextField tfDPsifraKompozitor, tfDPsifraAranzer, tfDPsifraZanr;
    public DatePicker dpDPdatIzd;
    public Button btnDodajPjesmu;
    //Uredi pjesmu
    public TextField tfUPsifra, tfUPsifraIzvodjac, tfUPsifraAlbum, tfUPsifraSpot, tfUPnaziv, tfUPjezik, tfUPsifraTekstopisac;
    public TextField tfUPsifraKompozitor, tfUPsifraAranzer, tfUPsifraZanr;
    public DatePicker dpUPdatIzd;
    public Button btnUrediPjesmu;
    //Izbrisi pjesmu
    public TextField tfIPsifra;
    public Button btnIzbrisiPjesmu;
    //Pretrazi pjesmu:
    public TextField tfPPfilter;






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
            paneOsoba.setVisible(false);
            paneZanr.setVisible(false);
            paneAlbum.setVisible(false);
            paneSpot.setVisible(false);
            paneFunkcija.setVisible(false);
        }
        else if(event.getSource()==btnIzvodjac) {
            paneIzvodjac.setVisible(true);
            panePjesma.setVisible(false);
            paneTekstopisac.setVisible(false);
            paneAranzer.setVisible(false);
            paneKompozitor.setVisible(false);
            paneOsoba.setVisible(false);
            paneZanr.setVisible(false);
            paneAlbum.setVisible(false);
            paneSpot.setVisible(false);
            paneFunkcija.setVisible(false);
        }
        else if(event.getSource()==btnTekstopisac) {
            paneTekstopisac.setVisible(true);
            panePjesma.setVisible(false);
            paneIzvodjac.setVisible(false);
            paneAranzer.setVisible(false);
            paneKompozitor.setVisible(false);
            paneOsoba.setVisible(false);
            paneZanr.setVisible(false);
            paneAlbum.setVisible(false);
            paneSpot.setVisible(false);
            paneFunkcija.setVisible(false);
        }
        else if(event.getSource()==btnAranzer){
            paneAranzer.setVisible(true);
            panePjesma.setVisible(false);
            paneIzvodjac.setVisible(false);
            paneTekstopisac.setVisible(false);
            paneKompozitor.setVisible(false);
            paneOsoba.setVisible(false);
            paneZanr.setVisible(false);
            paneAlbum.setVisible(false);
            paneSpot.setVisible(false);
            paneFunkcija.setVisible(false);
        }
        else if(event.getSource()==btnKompozitor){
            paneKompozitor.setVisible(true);
            panePjesma.setVisible(false);
            paneIzvodjac.setVisible(false);
            paneTekstopisac.setVisible(false);
            paneAranzer.setVisible(false);
            paneOsoba.setVisible(false);
            paneZanr.setVisible(false);
            paneAlbum.setVisible(false);
            paneSpot.setVisible(false);
            paneFunkcija.setVisible(false);
        }
        else if(event.getSource()==btnOsoba){
            paneOsoba.setVisible(true);
            panePjesma.setVisible(false);
            paneIzvodjac.setVisible(false);
            paneTekstopisac.setVisible(false);
            paneAranzer.setVisible(false);
            paneKompozitor.setVisible(false);
            paneZanr.setVisible(false);
            paneAlbum.setVisible(false);
            paneSpot.setVisible(false);
            paneFunkcija.setVisible(false);
        }
        else if(event.getSource()==btnZanr){
            paneZanr.setVisible(true);
            panePjesma.setVisible(false);
            paneIzvodjac.setVisible(false);
            paneTekstopisac.setVisible(false);
            paneAranzer.setVisible(false);
            paneKompozitor.setVisible(false);
            paneOsoba.setVisible(false);
            paneAlbum.setVisible(false);
            paneSpot.setVisible(false);
            paneFunkcija.setVisible(false);

        }
        else if(event.getSource()==btnAlbum){
            paneAlbum.setVisible(true);
            panePjesma.setVisible(false);
            paneIzvodjac.setVisible(false);
            paneTekstopisac.setVisible(false);
            paneAranzer.setVisible(false);
            paneKompozitor.setVisible(false);
            paneOsoba.setVisible(false);
            paneZanr.setVisible(false);
            paneSpot.setVisible(false);
            paneFunkcija.setVisible(false);
        }
        else if(event.getSource()==btnSpot){
            paneSpot.setVisible(true);
            panePjesma.setVisible(false);
            paneIzvodjac.setVisible(false);
            paneTekstopisac.setVisible(false);
            paneAranzer.setVisible(false);
            paneKompozitor.setVisible(false);
            paneOsoba.setVisible(false);
            paneZanr.setVisible(false);
            paneAlbum.setVisible(false);
            paneFunkcija.setVisible(false);
        } else if (event.getSource()==btnFunkcija) {
            paneFunkcija.setVisible(true);
            panePjesma.setVisible(false);
            paneIzvodjac.setVisible(false);
            paneTekstopisac.setVisible(false);
            paneAranzer.setVisible(false);
            paneKompozitor.setVisible(false);
            paneOsoba.setVisible(false);
            paneZanr.setVisible(false);
            paneAlbum.setVisible(false);
            paneSpot.setVisible(false);

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
        paneOsoba.setVisible(false);
        paneZanr.setVisible(false);
        paneAlbum.setVisible(false);
        paneSpot.setVisible(false);
        paneFunkcija.setVisible(false);

        updateIzvodjacTable();
        pretraziIzvodjace();

        updateTekstopisacTable();
        pretraziTekstopisce();

        updateAranzerTable();
        pretraziAranzere();

        updateKompozitorTable();
        pretraziKompozitore();

        updateOsobaTable();
        pretraziOsobe();

        updateZanrTable();
        pretraziZanr();

        updateAlbumTable();
        pretraziAlbume();

        updateSpotTable();
        pretraziSpotove();

        updateFunkcijaTable();
        pretraziFunkcije();

        updatePjesmaTable();
        pretraziPjesme();


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

    /* ----------------------------------------------- osoba ------------------------------------------*/
    public void dodajOsobu() {
        conn = HelloApplication.ConnectDb();
        String sql = "INSERT INTO osoba (imeOsoba, prezimeOsoba, zanimanjeOsoba, datumRodjOsoba, adresaOsoba, kontaktOsoba) VALUES (?,?,?,?,?,?)";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,tfDOime.getText());
            pst.setString(2,tfDOprezime.getText());
            pst.setString(3,tfDOzanimanje.getText());
            pst.setDate(4, java.sql.Date.valueOf(dpDOdatRodj.getValue()));
            pst.setString(5,tfDOadresa.getText());
            pst.setString(6,tfDOkontakt.getText());
            pst.execute();

            AlertBox.display("Dodaj osobu","Uspješno ste dodali osobu koja radi na spotu.");

        } catch (Exception e){
            AlertBox.display("Dodaj osobu","Error: Provjerite da li su sva polja ispravno popunjena.");
            System.out.println(e.fillInStackTrace());
        }
        updateOsobaTable();
        pretraziOsobe();
    }

    public void urediOsobu(){
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfUOsifra.getText());
            String ime = tfUOime.getText();
            if(!(ime.isEmpty()))
            {
                String sql = "UPDATE osoba SET imeOsoba = '"+ime+"' WHERE sifraOsoba ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            String prezime = tfUOprezime.getText();
            if(!(prezime.isEmpty()))
            {
                String sql = "UPDATE osoba SET prezimeOsoba = '"+prezime+"' WHERE sifraOsoba ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            String zanimanje = tfUOzanimanje.getText();
            if(!(zanimanje.isEmpty()))
            {
                String sql = "UPDATE osoba SET zanimanjeOsoba = '"+zanimanje+"' WHERE sifraOsoba ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            String adresa = tfUOadresa.getText();
            if(!(adresa.isEmpty()))
            {
                String sql = "UPDATE osoba SET adresaOsoba = '"+adresa+"' WHERE sifraOsoba ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            String kontakt = tfUOkontakt.getText();
            if(!(kontakt.isEmpty()))
            {
                String sql = "UPDATE osoba SET kontaktOsoba = '"+kontakt+"' WHERE sifraOsoba ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            Date datRodj = java.sql.Date.valueOf(dpUOdatRodj.getValue());
            if(datRodj != null)
            {
                String sql = "UPDATE osoba SET datumRodjOsoba='"+datRodj+"' WHERE sifraOsoba ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            AlertBox.display("Uredi osobu","Uspješno ste izmijenili podatke o osobi.");
        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Uredi osobu","Error: Neuspješna izmjena.");
        }
        updateOsobaTable();
        pretraziOsobe();
    }

    public void updateOsobaTable(){
        try {
            tcSifraOsoba.setCellValueFactory(new PropertyValueFactory<osoba, Integer>("sifra"));
            tcImeOsoba.setCellValueFactory(new PropertyValueFactory<osoba, String>("Ime"));
            tcPrezimeOsoba.setCellValueFactory(new PropertyValueFactory<osoba, String>("Prezime"));
            tcZanimanjeOsoba.setCellValueFactory(new PropertyValueFactory<osoba, String>("zanimanje"));
            tcAdresaOsoba.setCellValueFactory(new PropertyValueFactory<osoba, String>("Adresa"));
            tcKontaktOsoba.setCellValueFactory(new PropertyValueFactory<osoba, String>("Kontakt"));
            tcDatRodjOsoba.setCellValueFactory(new PropertyValueFactory<osoba, Date>("DatRodj"));
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        try {
            listOsoba = HelloApplication.getDataOsoba();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableOsoba.setItems(listOsoba);
    }

    public void izbrisiOsobu() {
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfIOsifra.getText());
            if(checkIDosoba(sifra)) {
                String sql = "DELETE FROM osoba WHERE sifraOsoba='"+sifra+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                updateOsobaTable();
                pretraziOsobe();
                AlertBox.display("Izbriši osobu","Uspješno ste izbrisali osobu.");
            }
            else{
                AlertBox.display("Izbriši osobu","Error: Pogrešno unesen ID.");
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Izbriši osobu","Error: Neuspješno brisanje.");
        }
    }

    public void pretraziOsobe(){
        tcSifraOsoba.setCellValueFactory(new PropertyValueFactory<osoba, Integer>("sifra"));
        tcImeOsoba.setCellValueFactory(new PropertyValueFactory<osoba, String>("Ime"));
        tcPrezimeOsoba.setCellValueFactory(new PropertyValueFactory<osoba, String>("Prezime"));
        tcZanimanjeOsoba.setCellValueFactory(new PropertyValueFactory<osoba, String>("zanimanje"));
        tcAdresaOsoba.setCellValueFactory(new PropertyValueFactory<osoba, String>("Adresa"));
        tcKontaktOsoba.setCellValueFactory(new PropertyValueFactory<osoba, String>("Kontakt"));
        tcDatRodjOsoba.setCellValueFactory(new PropertyValueFactory<osoba, Date>("DatRodj"));
        try {
            dataListOsoba = HelloApplication.getDataOsoba();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableOsoba.setItems(dataListOsoba);
        FilteredList<osoba> filteredData = new FilteredList<>(dataListOsoba, b -> true);
        tfPOfilter.textProperty().addListener(((observableValue, oldValue, newValue) -> {
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
                else if(person.getZanimanje().toLowerCase().indexOf(lowerCaseFilter) != -1){
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
        SortedList<osoba> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableOsoba.comparatorProperty());
        tableOsoba.setItems(sortedData);
    }
    private boolean checkIDosoba(Integer sifra) {
        for (osoba singer : listOsoba) {
            if (sifra == singer.getSifra()) {
                return true;
            }
        }
        return false;
    }


    /* ----------------------------------------------- zanr ------------------------------------------*/
    public void dodajZanr() {
        conn = HelloApplication.ConnectDb();
        String sql = "INSERT INTO zanr (nazivZanr, kraticaZanr) VALUES (?,?)";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,tfDZnaziv.getText());
            pst.setString(2,tfDZkratica.getText());
            pst.execute();

            AlertBox.display("Dodaj žanr","Uspješno ste dodali žanr.");

        } catch (Exception e){
            AlertBox.display("Dodaj žanr","Error: Provjerite da li su sva polja ispravno popunjena.");
            System.out.println(e.fillInStackTrace());
        }
        updateZanrTable();
        pretraziZanr();
    }

    public void urediZanr(){
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfUZsifra.getText());
            String naziv = tfUZnaziv.getText();
            if(!(naziv.isEmpty()))
            {
                String sql = "UPDATE zanr SET nazivZanr = '"+naziv+"' WHERE sifraZanr ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            String kratica = tfUZkratica.getText();
            if(!(kratica.isEmpty()))
            {
                String sql = "UPDATE zanr SET kraticaZanr = '"+kratica+"' WHERE sifraZanr ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            AlertBox.display("Uredi žanr","Uspješno ste izmijenili podatke o žanru.");
        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Uredi žanr","Error: Neuspješna izmjena.");
        }
        updateZanrTable();
        pretraziZanr();
    }

    public void updateZanrTable(){
        try {
            tcSifraZanr.setCellValueFactory(new PropertyValueFactory<zanr, Integer>("sifra"));
            tcNazivZanr.setCellValueFactory(new PropertyValueFactory<zanr, String>("Naziv"));
            tcKraticaZanr.setCellValueFactory(new PropertyValueFactory<zanr, String>("kratica"));
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        try {
            listZanr = HelloApplication.getDataZanr();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableZanr.setItems(listZanr);
    }

    public void izbrisiZanr() {
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfIZsifra.getText());
            if(checkIDzanr(sifra)) {
                String sql = "DELETE FROM zanr WHERE sifraZanr='"+sifra+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                updateZanrTable();
                pretraziZanr();
                AlertBox.display("Izbriši žanr","Uspješno ste izbrisali žanr.");
            }
            else{
                AlertBox.display("Izbriši žanr","Error: Pogrešno unesen ID.");
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Izbriši žanr","Error: Neuspješno brisanje.");
        }
    }

    public void pretraziZanr(){
        tcSifraZanr.setCellValueFactory(new PropertyValueFactory<zanr, Integer>("sifra"));
        tcNazivZanr.setCellValueFactory(new PropertyValueFactory<zanr, String>("Naziv"));
        tcKraticaZanr.setCellValueFactory(new PropertyValueFactory<zanr, String>("kratica"));
        try {
            dataListZanr = HelloApplication.getDataZanr();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableZanr.setItems(dataListZanr);
        FilteredList<zanr> filteredData = new FilteredList<>(dataListZanr, b -> true);
        tfPZfilter.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if(person.getNaziv().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(person.getKratica().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else{
                    return false;
                }
            });
        } ));
        SortedList<zanr> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableZanr.comparatorProperty());
        tableZanr.setItems(sortedData);
    }
    private boolean checkIDzanr(Integer sifra) {
        for (zanr singer : listZanr) {
            if (sifra == singer.getSifra()) {
                return true;
            }
        }
        return false;
    }

    /* ----------------------------------------------- album ------------------------------------------*/
    public void dodajAlbum() {
        conn = HelloApplication.ConnectDb();
        String sql = "INSERT INTO album (nazivAlbum, brojPjesamaAlbum, datumIzdavanaAlbum) VALUES (?,?,?)";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,tfDAnaziv.getText());
            pst.setInt(2, Integer.parseInt(tfDAbrojPjesama.getText()));
            pst.setDate(3, java.sql.Date.valueOf(dpDAdatIzd.getValue()));
            pst.execute();

            AlertBox.display("Dodaj album","Uspješno ste dodali album.");

        } catch (Exception e){
            AlertBox.display("Dodaj album","Error: Provjerite da li su sva polja ispravno popunjena.");
            System.out.println(e.fillInStackTrace());
        }
        updateAlbumTable();
        pretraziAlbume();
    }

    public void urediAlbum(){
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfUOsifra.getText());
            String naziv = tfUAnaziv.getText();
            if(!(naziv.isEmpty()))
            {
                String sql = "UPDATE album SET nazivAlbum = '"+naziv+"' WHERE nazivAlbum ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            Integer brojPjesama = Integer.valueOf(tfUAbrojPjesama.getText());
            if(brojPjesama > 0)
            {
                String sql = "UPDATE album SET brojPjesamaAlbum = '"+brojPjesama+"' WHERE sifraAlbum ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            Date datIzd = java.sql.Date.valueOf(dpUAdatIzd.getValue());
            if(datIzd != null)
            {
                String sql = "UPDATE album SET datumIzdavanaAlbum='"+datIzd+"' WHERE sifraAlbum ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            AlertBox.display("Uredi album","Uspješno ste izmijenili podatke o albumu.");
        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Uredi album","Error: Neuspješna izmjena.");
        }
        updateAlbumTable();
        pretraziAlbume();
    }

    public void updateAlbumTable(){
        try {
            tcSifraAlbum.setCellValueFactory(new PropertyValueFactory<album, Integer>("sifra"));
            tcNazivAlbum.setCellValueFactory(new PropertyValueFactory<album, String>("naziv"));
            tcBrojPjesamaAlbum.setCellValueFactory(new PropertyValueFactory<album, Integer>("brojPjesama"));
            tcDatIzdAlbum.setCellValueFactory(new PropertyValueFactory<album, Date>("DatIzd"));
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        try {
            listAlbum = HelloApplication.getDataAlbum();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableAlbum.setItems(listAlbum);
    }

    public void izbrisiAlbum() {
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfIAsifraAlbum.getText());
            if(checkIDalbum(sifra)) {
                String sql = "DELETE FROM album WHERE sifraAlbum='"+sifra+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                updateAlbumTable();
                pretraziAlbume();
                AlertBox.display("Izbriši album","Uspješno ste izbrisali album.");
            }
            else{
                AlertBox.display("Izbriši album","Error: Pogrešno unesen ID.");
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Izbriši album","Error: Neuspješno brisanje.");
        }
    }

    public void pretraziAlbume(){
        tcSifraAlbum.setCellValueFactory(new PropertyValueFactory<album, Integer>("sifra"));
        tcNazivAlbum.setCellValueFactory(new PropertyValueFactory<album, String>("naziv"));
        tcBrojPjesamaAlbum.setCellValueFactory(new PropertyValueFactory<album, Integer>("brojPjesama"));
        tcDatIzdAlbum.setCellValueFactory(new PropertyValueFactory<album, Date>("DatIzd"));
        try {
            dataListAlbum = HelloApplication.getDataAlbum();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableAlbum.setItems(dataListAlbum);
        FilteredList<album> filteredData = new FilteredList<>(dataListAlbum, b -> true);
        tfPAlbumFilter.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if(person.getNaziv().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else{
                    return false;
                }
            });
        } ));
        SortedList<album> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableAlbum.comparatorProperty());
        tableAlbum.setItems(sortedData);
    }
    private boolean checkIDalbum(Integer sifra) {
        for (album singer : listAlbum) {
            if (sifra == singer.getSifra()) {
                return true;
            }
        }
        return false;
    }


    /* ----------------------------------------------- spot ------------------------------------------*/
    public void dodajSpot() {
        conn = HelloApplication.ConnectDb();
        String sql = "INSERT INTO spot (sifraPjesma, sifraIzvodjac, sifraAlbum, lokacijaSpot, datumSpot) VALUES (?,?,?,?,?)";
        try{

            pst = conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(tfDSsifraPjesma.getText()));
            pst.setInt(2, Integer.parseInt(tfDSsifraIzvodjac.getText()));
            pst.setInt(3, Integer.parseInt(tfDSsifraAlbum.getText()));
            pst.setString(4,tfDSlokacija.getText());
            pst.setDate(5, java.sql.Date.valueOf(dpDSdatSnim.getValue()));
            pst.execute();

            AlertBox.display("Dodaj spot","Uspješno ste dodali spot.");

        } catch (Exception e){
            AlertBox.display("Dodaj spot","Error: Provjerite da li su sva polja ispravno popunjena.");
            System.out.println(e.fillInStackTrace());
        }
        updateSpotTable();
        pretraziSpotove();
    }

    public void urediSpot(){
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfUSsifraSpot.getText());
            Integer sifraPjesma = Integer.valueOf(tfUSsifraPjesma.getText());
            if(sifraPjesma >= 0)
            {
                String sql = "UPDATE spot SET sifraPjesma = '"+sifraPjesma+"' WHERE sifraSpot ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            Integer sifraIzvodjac = Integer.valueOf(tfUSsifraIzvodjac.getText());
            if(sifraIzvodjac >= 0)
            {
                String sql = "UPDATE spot SET sifraIzvodjac = '"+sifraIzvodjac+"' WHERE sifraSpot ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            Integer sifraAlbum = Integer.valueOf(tfUSsifraAlbum.getText());
            if(sifraAlbum>=0)
            {
                String sql = "UPDATE spot SET sifraAlbum = '"+sifraAlbum+"' WHERE sifraSpot ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            String lokacija = tfUSlokacija.getText();
            if(!(lokacija.isEmpty()))
            {
                String sql = "UPDATE spot SET lokacijaSpot = '"+lokacija+"' WHERE sifraSpot ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            Date datSnim = java.sql.Date.valueOf(dpUSdatSnim.getValue());
            if(datSnim != null)
            {
                String sql = "UPDATE spot SET datumSpot='"+datSnim+"' WHERE sifraSpot ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            AlertBox.display("Uredi spot","Uspješno ste izmijenili podatke o spotu.");
        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Uredi spotu","Error: Neuspješna izmjena.");
        }
        updateSpotTable();
        pretraziSpotove();
    }

    public void updateSpotTable(){
        try {
            tcSifraSpot.setCellValueFactory(new PropertyValueFactory<spot, Integer>("sifra"));
            tcSifraPjesmaSpot.setCellValueFactory(new PropertyValueFactory<spot, Integer>("sifraPjesma"));
            tcSifraIzvodjacSpot.setCellValueFactory(new PropertyValueFactory<spot, Integer>("sifraIzvodjac"));
            tcSifraAlbumSpot.setCellValueFactory(new PropertyValueFactory<spot, Integer>("sifraAlbum"));
            tcLokacijaSpot.setCellValueFactory(new PropertyValueFactory<spot, String>("Lokacija"));
            tcDatSnimanjaSpot.setCellValueFactory(new PropertyValueFactory<spot, Date>("DatumSnimanja"));
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        try {
            listSpot = HelloApplication.getDataSpot();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableSpot.setItems(listSpot);
    }

    public void izbrisiSpot(){
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfISsifraSpot.getText());
            if(checkIDspot(sifra)) {
                String sql = "DELETE FROM spot WHERE sifraSpot='"+sifra+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                updateSpotTable();
                pretraziSpotove();
                AlertBox.display("Izbriši spot","Uspješno ste izbrisali spot.");
            }
            else{
                AlertBox.display("Izbriši spot","Error: Pogrešno unesen ID.");
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Izbriši spot","Error: Neuspješno brisanje.");
        }
    }

    public void pretraziSpotove(){
        tcSifraSpot.setCellValueFactory(new PropertyValueFactory<spot, Integer>("sifra"));
        tcSifraPjesmaSpot.setCellValueFactory(new PropertyValueFactory<spot, Integer>("sifraPjesma"));
        tcSifraIzvodjacSpot.setCellValueFactory(new PropertyValueFactory<spot, Integer>("sifraIzvodjac"));
        tcSifraAlbumSpot.setCellValueFactory(new PropertyValueFactory<spot, Integer>("sifraAlbum"));
        tcLokacijaSpot.setCellValueFactory(new PropertyValueFactory<spot, String>("Lokacija"));
        tcDatSnimanjaSpot.setCellValueFactory(new PropertyValueFactory<spot, Date>("DatumSnimanja"));
        try {
            dataListSpot = HelloApplication.getDataSpot();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableSpot.setItems(dataListSpot);
        FilteredList<spot> filteredData = new FilteredList<>(dataListSpot, b -> true);
        tfPSfilter.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if(person.getLokacija().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else{
                    return false;
                }
            });
        } ));
        SortedList<spot> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableSpot.comparatorProperty());
        tableSpot.setItems(sortedData);
    }
    private boolean checkIDspot(Integer sifra) {
        for (spot singer : listSpot) {
            if (sifra == singer.getSifra()) {
                return true;
            }
        }
        return false;
    }


    /* ----------------------------------------------- funkcija ------------------------------------------*/
    public void dodajFunkciju() {
        conn = HelloApplication.ConnectDb();
        String sql = "INSERT INTO funkcija (nazivZanr) VALUES (?)";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,tfDFnaziv.getText());
            pst.execute();

            AlertBox.display("Dodaj funkciju","Uspješno ste dodali funkciju.");

        } catch (Exception e){
            AlertBox.display("Dodaj funkciju","Error: Provjerite da li su sva polja ispravno popunjena.");
            System.out.println(e.fillInStackTrace());
        }
        updateFunkcijaTable();
        pretraziFunkcije();
    }

    public void urediFunkcju(){
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfUFsifra.getText());
            String naziv = tfUFnaziv.getText();
            if(!(naziv.isEmpty()))
            {
                String sql = "UPDATE funkcija SET nazivFunkcija = '"+naziv+"' WHERE sifraFunkcija ='"+sifra+"';";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }
            AlertBox.display("Uredi funkciju","Uspješno ste izmijenili podatke o funkciji.");
        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Uredi funkciju","Error: Neuspješna izmjena.");
        }
        updateFunkcijaTable();
        pretraziFunkcije();
    }

    public void updateFunkcijaTable(){
        try {
            tcSifraFunkcija.setCellValueFactory(new PropertyValueFactory<funkcija, Integer>("sifra"));
            tcNazivFunkcija.setCellValueFactory(new PropertyValueFactory<funkcija, String>("Naziv"));
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        try {
            listFunkcija = HelloApplication.getDataFunkcija();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableFunkcija.setItems(listFunkcija);
    }

    public void izbrisiFunkciju() {
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfIFsifra.getText());
            if(checkIDfunkcija(sifra)) {
                String sql = "DELETE FROM funkcija WHERE sifraFunkcija='"+sifra+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                updateFunkcijaTable();
                pretraziFunkcije();
                AlertBox.display("Izbriši funkciju","Uspješno ste izbrisali funkciju.");
            }
            else{
                AlertBox.display("Izbriši funkciju","Error: Pogrešno unesen ID.");
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Izbriši funkciju","Error: Neuspješno brisanje.");
        }
    }

    public void pretraziFunkcije(){
        tcSifraFunkcija.setCellValueFactory(new PropertyValueFactory<funkcija, Integer>("sifra"));
        tcNazivFunkcija.setCellValueFactory(new PropertyValueFactory<funkcija, String>("Naziv"));
        try {
            dataListFunkcija = HelloApplication.getDataFunkcija();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableFunkcija.setItems(dataListFunkcija);
        FilteredList<funkcija> filteredData = new FilteredList<>(dataListFunkcija, b -> true);
        tfPZfilter.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if(person.getNaziv().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else{
                    return false;
                }
            });
        } ));
        SortedList<funkcija> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableFunkcija.comparatorProperty());
        tableFunkcija.setItems(sortedData);
    }
    private boolean checkIDfunkcija(Integer sifra) {
        for (funkcija singer : listFunkcija) {
            if (sifra == singer.getSifra()) {
                return true;
            }
        }
        return false;
    }

    /* ----------------------------------------------- pjesma ------------------------------------------*/
    public void dodajPjesmu() {
        conn = HelloApplication.ConnectDb();
        String sql = "INSERT INTO pjesma (sifraIzvodjac, sifraAlbum, sifraSpot, nazivPjesma, jezikPjesma, datumIzdavanjaPjesma, " +
                "sifraTekstopisac, sifraKompozitor, sifraAranzer, sifraZanr) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try{
            pst = conn.prepareStatement(sql);

            pst.setInt(1, Integer.parseInt(tfDPsifraIzvodjac.getText()));
            pst.setInt(2, Integer.parseInt(tfDPsifraAlbum.getText()));
            pst.setInt(3, Integer.parseInt(tfDPsifraSpot.getText()));
            pst.setString(4,tfDPnaziv.getText());
            pst.setString(5,tfDPjezik.getText());
            pst.setDate(6, java.sql.Date.valueOf(dpDPdatIzd.getValue()));
            pst.setInt(7, Integer.parseInt(tfDPsifraTekstopisac.getText()));
            pst.setInt(8, Integer.parseInt(tfDPsifraKompozitor.getText()));
            pst.setInt(9, Integer.parseInt(tfDPsifraAranzer.getText()));
            pst.setInt(10, Integer.parseInt(tfDPsifraZanr.getText()));
            pst.execute();

            AlertBox.display("Dodaj pjesmu","Uspješno ste dodali pjesmu.");

        } catch (Exception e){
            AlertBox.display("Dodaj pjesmu","Error: Provjerite da li su sva polja ispravno popunjena.");
            System.out.println(e.fillInStackTrace());
        }
        updatePjesmaTable();
        pretraziPjesme();
    }

    public void urediPjesmu(){
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfUPsifra.getText());
            Integer sifraIzvodjac = Integer.valueOf(tfUPsifraIzvodjac.getText());
            Integer sifraAlbum = Integer.valueOf(tfUPsifraAlbum.getText());
            Integer sifraSpot = Integer.valueOf(tfUPsifraSpot.getText());
            if(checkID(sifraIzvodjac) && checkIDalbum(sifraAlbum) && checkIDspot(sifraSpot) && checkIDpjesma(sifra)){
                String naziv = tfUPnaziv.getText();
                if(!(naziv.isEmpty()))
                {
                    String sql = "UPDATE pjesma SET nazivPjesma = '"+naziv+"' WHERE sifraPjesma ='"+sifra+"';";
                    pst = conn.prepareStatement(sql);
                    pst.execute();
                }
                String jezik = tfUPjezik.getText();
                if(!(jezik.isEmpty()))
                {
                    String sql = "UPDATE pjesma SET jezikPjesma = '"+jezik+"' WHERE sifraPjesma ='"+sifra+"';";
                    pst = conn.prepareStatement(sql);
                    pst.execute();
                }
                Date datIzd = java.sql.Date.valueOf(dpUPdatIzd.getValue());
                if(datIzd != null)
                {
                    String sql = "UPDATE pjesma SET datumIzdavanjaPjesma='"+datIzd+"' WHERE sifraPjesma ='"+sifra+"';";
                    pst = conn.prepareStatement(sql);
                    pst.execute();
                }
                Integer sifraTekstopisac = Integer.valueOf(tfUPsifraTekstopisac.getText());
                if(sifraTekstopisac >= 0)
                {
                    String sql = "UPDATE pjesma SET sifraTekstopisac = '"+sifraTekstopisac+"' WHERE sifraPjesma ='"+sifra+"';";
                    pst = conn.prepareStatement(sql);
                    pst.execute();
                }
                Integer sifraKompozitor = Integer.valueOf(tfUPsifraKompozitor.getText());
                if(sifraKompozitor >= 0)
                {
                    String sql = "UPDATE pjesma SET sifraKompozitor = '"+sifraKompozitor+"' WHERE sifraPjesma ='"+sifra+"';";
                    pst = conn.prepareStatement(sql);
                    pst.execute();
                }
                Integer sifraAranzer = Integer.valueOf(tfUPsifraAranzer.getText());
                if(sifraAranzer >= 0)
                {
                    String sql = "UPDATE pjesma SET sifraAranzer = '"+sifraAranzer+"' WHERE sifraPjesma ='"+sifra+"';";
                    pst = conn.prepareStatement(sql);
                    pst.execute();
                }
                Integer sifraZanr = Integer.valueOf(tfUPsifraZanr.getText());
                if(sifraZanr >= 0)
                {
                    String sql = "UPDATE pjesma SET sifraZanr = '"+sifraTekstopisac+"' WHERE sifraPjesma ='"+sifra+"';";
                    pst = conn.prepareStatement(sql);
                    pst.execute();
                }

            }
            else{
                AlertBox.display("Uredi pjesmu","Provjerite ispravnost sifri koje unosite.");
            }
            AlertBox.display("Uredi pjesmu","Uspješno ste izmijenili podatke pjesme.");
        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Uredi pjesmu","Error: Neuspješna izmjena.");
        }
        updatePjesmaTable();
        pretraziPjesme();
    }

    public void updatePjesmaTable(){
        try {
            tcSifraPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, Integer>("sifra"));
            tcSifraIzvodjacPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, Integer>("sifraIzvodjac"));
            tcSifraAlbumPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, Integer>("sifraAlbum"));
            tcSifraSpotPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, Integer>("sifraSpot"));
            tcNazivPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, String>("naziv"));
            tcJezikPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, String>("jezik"));
            tcDatumIzdavanjaPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, Date>("DatIzd"));
            tcSifraTekstopisacPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, Integer>("sifraTekstopisac"));
            tcSifraKompozitorPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, Integer>("sifraKompozitor"));
            tcSifraAranzerPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, Integer>("sifraAranzer"));
            tcSifraZanrPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, Integer>("sifraZanr"));
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        try {
            listPjesma = HelloApplication.getDataPjesma();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tablePjesma.setItems(listPjesma);
    }

    public void izbrisiPjesmu() {
        try {
            conn = HelloApplication.ConnectDb();
            Integer sifra = Integer.valueOf(tfIPsifra.getText());
            if(checkIDpjesma(sifra)) {
                String sql = "DELETE FROM pjesma WHERE sifraPjesma='"+sifra+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                updatePjesmaTable();
                pretraziPjesme();
                AlertBox.display("Izbriši pjesmu","Uspješno ste izbrisali pjesmu.");
            }
            else{
                AlertBox.display("Izbriši pjesmu","Error: Pogrešno unesen ID.");
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            AlertBox.display("Izbriši Pjesmu","Error: Neuspješno brisanje.");
        }
    }

    public void pretraziPjesme(){
        tcSifraIzvodjacPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, Integer>("sifraIzvodjac"));
        tcSifraAlbumPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, Integer>("sifraAlbum"));
        tcSifraSpotPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, Integer>("sifraSpot"));
        tcNazivPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, String>("naziv"));
        tcJezikPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, String>("jezik"));
        tcDatumIzdavanjaPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, Date>("DatIzd"));
        tcSifraTekstopisacPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, Integer>("sifraTekstopisac"));
        tcSifraKompozitorPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, Integer>("sifraKompozitor"));
        tcSifraAranzerPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, Integer>("sifraAranzer"));
        tcSifraZanrPjesma.setCellValueFactory(new PropertyValueFactory<pjesma, Integer>("sifraZanr"));
        try {
            dataListPjesma = HelloApplication.getDataPjesma();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tablePjesma.setItems(dataListPjesma);
        FilteredList<pjesma> filteredData = new FilteredList<>(dataListPjesma, b -> true);
        tfPPfilter.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if(person.getNaziv().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(person.getJezik().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else{
                    return false;
                }
            });
        } ));
        SortedList<pjesma> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tablePjesma.comparatorProperty());
        tablePjesma.setItems(sortedData);
    }
    private boolean checkIDpjesma(Integer sifra) {
        for (pjesma singer : listPjesma) {
            if (sifra == singer.getSifra()) {
                return true;
            }
        }
        return false;
    }



}